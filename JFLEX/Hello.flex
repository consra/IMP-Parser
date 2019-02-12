import java.util.*;
import java.util.Stack;

%%

%class HelloLexer
%line
%int
%{

  	Stack<Expression> stack = new Stack<>();
	SequenceNode Firstseq = new SequenceNode();
	MainNode mainNode = new MainNode(Firstseq);
	int lines = 2;
	void print_stack()
	{
		Stack<Expression> aux = (Stack<Expression>)stack.clone();
		while(!aux.empty())
		{
			String s;
			if(aux.peek() instanceof Symbol)
			{
				s = ((Symbol)aux.peek()).symbol();
				System.out.println(aux.pop().getClass().getName() + " " + s);
			}
			else
				System.out.println(aux.pop().getClass().getName());

		}
		System.out.println("");
	}
	void restrict_stack_div(ArrayList<Expression> list, int type)
	{
		Stack<Expression> new_stack = new Stack<>();
		for(int i = list.size()-1; i >= 0; i--)
		{
			new_stack.push(list.get(i));
		}

		while(new_stack.size() >= 3)
		{
			Expression e1 = new_stack.pop();
			Expression s = new_stack.pop();
			Expression e2 = new_stack.pop();
			DivNode node = new DivNode(e1, e2);
			new_stack.push(node);
		}

		if(type == 0)
			stack.push(new_stack.pop());
		else
			stack.push(new BracketNode(new_stack.pop()));
	}

	void restrict_stack_plus(ArrayList<Expression> list, int type)
	{
		Stack<Expression> new_stack = new Stack<>();
		for(int i = list.size()-1; i >= 0; i--)
		{
			new_stack.push(list.get(i));
		}

		while(new_stack.size() >= 3)
		{
			Expression e1 = new_stack.pop();
			Expression s = new_stack.pop();
			Expression e2 = new_stack.pop();
			PlusNode node = new PlusNode(e1, e2);
			new_stack.push(node);
		}
		if(type == 0)
			stack.push(new_stack.pop());
		else
			stack.push(new BracketNode(new_stack.pop()));
	}
	ArrayList<Expression> reduced_boolean(ArrayList<Expression> list, String symbol)
	{

		NopNode nop = new NopNode();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) instanceof Symbol)
			{
				String car = ((Symbol)list.get(i)).symbol();
				if(car.equals(symbol))
				{
					if(symbol.equals("/"))
						list.set(i, new DivNode(list.get(i-1), list.get(i+1)));
					else if(symbol.equals("+"))
						list.set(i, new PlusNode(list.get(i-1), list.get(i+1)));
					else if(symbol.equals(">"))
						list.set(i, new GreaterNode(list.get(i-1), list.get(i+1)));
					list.set(i-1, nop);
					list.set(i+1, nop);
				}
			}
		}

		ArrayList<Expression> new_list1 = new ArrayList<Expression>();
		for(int i = 0; i < list.size(); i++)
		{
			if(!(list.get(i) instanceof NopNode))
				new_list1.add(list.get(i));
		}
		return new_list1;
	}
	void print_list(ArrayList<Expression> list)
	{
		System.out.println("Lista: ");
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("end");
	}
	void stack_collapse(ArrayList<Expression> list, String sym)
	{
		Stack<Expression> new_stack = new Stack<>();
		for(int i = list.size()-1; i >= 0; i--)
		{
			new_stack.push(list.get(i));
		}

		while(new_stack.size() >= 3)
		{
			Expression e1 = new_stack.pop();
			Expression s = new_stack.pop();
			Expression e2 = new_stack.pop();
			if(sym.equals("&&"))
			{
				AndNode node = new AndNode(e1, e2);
				new_stack.push(node);
			}
			if(sym.equals(">"))
			{
				GreaterNode node = new GreaterNode(e1, e2);
				new_stack.push(node);
			}
		}

		if(stack.peek() instanceof Symbol && ((Symbol)stack.peek()).symbol().equals("!"))
		{
			stack.pop();
			//if(stack.peek() instanceof Symbol && ((Symbol) stack.peek()).symbol().equals("(") )
				//stack.
			NotNode n = new NotNode(new BracketNode(new_stack.pop()));

			if(stack.peek() instanceof IfNode)
			{
				if(((IfNode) stack.peek()).getCond() == null)
					((IfNode) stack.peek()).setCond(n);
			}
			else if(stack.peek() instanceof WhileNode)
			{
				if(((WhileNode) stack.peek()).getCond() == null)
					((WhileNode) stack.peek()).setCond(n);
			}
			else
				stack.push(n);

		}
		else
		{
			BracketNode brnode = new BracketNode(new_stack.pop());
			if(stack.peek() instanceof IfNode)
			{
				if(((IfNode) stack.peek()).getCond() == null)
					((IfNode) stack.peek()).setCond(brnode);
			}
			else if(stack.peek() instanceof WhileNode)
			{
				if(((WhileNode) stack.peek()).getCond() == null)
					((WhileNode) stack.peek()).setCond(brnode);
			}
			else
				stack.push(brnode);
		}
	}
	void restrict_stack_boolean(ArrayList<Expression> list)
	{
		list = reduced_boolean(list, "/");
		list = reduced_boolean(list, "+");

		int count_and = 0;
		int count_greater = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) instanceof Symbol){
				if(((Symbol)list.get(i)).symbol().equals(">"))
					count_greater++;
				if(((Symbol)list.get(i)).symbol().equals("&&"))
					count_and++;
			}
		}

		if(count_and == 0)
		{
			stack_collapse(list, ">");
		}
		else if (count_greater == 0)
		{
			stack_collapse(list, "&&");
		}
		else
		{
			list = reduced_boolean(list, ">");
			stack_collapse(list, "&&");
		}
	}
	void seq_logic(String type)
	{
		Expression node = new IfNode();
		SequenceNode seq = (SequenceNode)stack.pop();

		if(type.equals("while"))
		{
			node = new WhileNode();
		}

		if(seq.getC1() == null)
		{
			seq.setC1(node);
			stack.push(seq);
		}
		else if(seq.getC2() == null)
		{
			seq.setC2(node);
			stack.push(seq);

		}
		else
		{
			SequenceNode new_seq = new SequenceNode();
			new_seq.setC1(seq.getC2());
			new_seq.setC2(node);
			seq.setC2(new_seq);
			stack.push(new_seq);
		}
		stack.push(node);
	}

	void restrict_stack(int type)
	{
		ArrayList<Expression> list = new ArrayList<>();
		int boolean_expr = 0;
		while(true)
		{
			if(stack.peek() instanceof Symbol)
			{
				String car = ((Symbol)stack.peek()).symbol();
				if( car.equals("(") ||
					car.equals("{")  )
				{
					stack.pop();
					break;
				}
				else if(((Symbol)stack.peek()).symbol().equals("="))
				{
					break;
				}
				else if(car.equals("&&") || car.equals(">") || car.equals("!"))
				{
					boolean_expr = 1;
				}
			}
			if(stack.peek() instanceof BoolNode || stack.peek() instanceof NotNode)
				boolean_expr = 1;

			list.add(stack.pop());
		}

		Collections.reverse(list);
		if(boolean_expr == 1)
		{
			restrict_stack_boolean(list);
			return;
		}

		Set<Integer> PlusPos = new HashSet<Integer>();
		Set<Integer> DivPos = new HashSet<Integer>();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) instanceof Symbol)
			{
				Symbol s = (Symbol) list.get(i);
				if(s.symbol().equals("+"))
					PlusPos.add(i);
				if(s.symbol().equals("/"))
					DivPos.add(i);
			}
		}
		if(PlusPos.size() == 0 && DivPos.size() == 0)
		{
			stack.push(list.get(0));
		}
		if(PlusPos.size() != 0 && DivPos.size() == 0)
		{
			restrict_stack_plus(list, type);
		}
		if(PlusPos.size() == 0 && DivPos.size() != 0)
		{
			restrict_stack_div(list, type);
		}
		NopNode nop = new NopNode();
		if(PlusPos.size() != 0 && DivPos.size() != 0)
		{
			ArrayList<Expression> new_list = new ArrayList<>();
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i) instanceof Symbol)
				{
					String s = ((Symbol)list.get(i)).symbol();
					if(s.equals("/"))
					{
						DivNode new_node = new DivNode(list.get(i-1), list.get(i+1));
						list.set(i, new_node);
						list.set(i-1, nop);
						list.set(i+1, nop);
					}
				}
			}

			for(int i = 0; i < list.size(); i++)
			{
				if(!(list.get(i) instanceof NopNode))
					new_list.add(list.get(i));
			}

			restrict_stack_plus(new_list, type);
		}

	}
	void SemicolonLogic()
	{
		restrict_stack(0);
		if(stack.size() < 4)
			System.out.println("Logic Error");


		Expression e1 = stack.pop();
		Expression symbol = stack.pop();
		Expression e2 = stack.pop();

		AssignmentNode node = new AssignmentNode(e2, e1, lines-1);
		SequenceNode seq = (SequenceNode)stack.pop();
		if(seq.getC1() == null)
		{
			seq.setC1(node);
			stack.push(seq);
		}
		else if(seq.getC2() == null)
		{
			seq.setC2(node);
			stack.push(seq);
		}
		else
		{
			SequenceNode new_seq = new SequenceNode();
			new_seq.setC1(seq.getC2());
			new_seq.setC2(node);
			seq.setC2(new_seq);
			stack.push(new_seq);
		}
	}
	void open_bracket_logic()
	{
		Expression top = stack.peek();
		if(top instanceof IfNode)
		{
			IfNode top_if = (IfNode) top;
			SequenceNode seq = new SequenceNode();
			BlockNode blocknode = new BlockNode();
			blocknode.setExpr(seq);
			if(top_if.getB1() == null)
			{
				top_if.setB1(blocknode);
			}
			else if(top_if.getB2() == null)
			{
				top_if.setB2(blocknode);
			}
			stack.push(seq);
		}

		if(top instanceof WhileNode)
		{
			WhileNode top_if = (WhileNode) top;
			SequenceNode seq = new SequenceNode();
			BlockNode blocknode = new BlockNode();
			blocknode.setExpr(seq);
			if(top_if.getB() == null)
			{
				top_if.setB(blocknode);
			}

			stack.push(seq);
		}
	}

	void empty_block_logic()
	{
		Expression top = stack.peek();
		if(top instanceof IfNode)
		{
			IfNode top_if = (IfNode) top;

			BlockNode blocknode = new BlockNode();
			if(top_if.getB1() == null)
			{
				top_if.setB1(blocknode);
			}
			else if(top_if.getB2() == null)
			{
				top_if.setB2(blocknode);
				stack.pop();
			}

			//corrections
			if(top_if.getB1() != null)
			{
				BlockNode bl = (BlockNode)top_if.getB1();
				if(bl.getExpr() != null)
				{
					SequenceNode seq = (SequenceNode)bl.getExpr();
					if(seq.getC2() == null)
					{
						bl.setExpr(seq.getC1());
					}
				}
			}
		}

		if(top instanceof WhileNode)
		{
			WhileNode top_if = (WhileNode) top;
			BlockNode blocknode = new BlockNode();
			if(top_if.getB() == null)
			{
				top_if.setB(blocknode);
				stack.pop();
			}
		}
	}

	void close_bracket_logic()
	{
		stack.pop();
		Expression top = stack.peek();
		if(top instanceof IfNode)
		{
			IfNode top_if = (IfNode) top;

			if(top_if.getB1() != null && top_if.getB2() != null)
			{
				// corrections
				BlockNode b1 = (BlockNode)top_if.getB1();
				BlockNode b2 = (BlockNode)top_if.getB2();

				if(b1.getExpr() != null)
				{
					SequenceNode seq = (SequenceNode) b1.getExpr();

					if(seq.getC2() == null)
						b1.setExpr(seq.getC1());
				}

				if(b2.getExpr() != null)
				{
					SequenceNode seq = (SequenceNode) b2.getExpr();

					if(seq.getC2() == null)
						b2.setExpr(seq.getC1());
				}

				stack.pop();
			}


		}

		if(top instanceof WhileNode)
		{
			WhileNode top_if = (WhileNode) top;
			if(top_if.getB() != null)
			{
				// corrections
				BlockNode b1 = (BlockNode)top_if.getB();

				if(b1.getExpr() != null)
				{
					SequenceNode seq = (SequenceNode) b1.getExpr();

					if(seq.getC2() == null)
						b1.setExpr(seq.getC1());
				}


				stack.pop();
			}
		}
	}

%}
Number = [1-9][0-9]* | 0
BVal = "true" | "false"
if = "if"
else = "else"
while = "while"
Var = [a-z]+
Open_B = "{"
Closed_B = "}"
Open_P = "("
Closed_P = ")"
Empty_block="{""}"
op = "=" | "+" | "/" | "&&" | ">" | "!"
VarList = "int "({Var}","(" ")*)*{Var}";"
AVal = {Number}
Semicolon = ";"

//AExpr = {Var} | {AVal} | {AExpr} "+" {AExpr} | {AExpr} "/" {AExpr} | "("{AExpr}")"
//BExpr = {BVal} | {BExpr} "&&" {BExpr} | {AExpr} ">" {AExpr} | "!" {BExpr} | "("{BExpr}")"
//Prog = int {VarList};
//Block = "{""}"
//Stmt = {Var} " = " {AExpr}";"
Ignore = "," | "\n"

%%
{VarList} {
	VarList.getInstance(yytext());
	stack.push(mainNode);
	stack.push(Firstseq);
}
{op} {stack.push(new Symbol(yytext()));}
{Empty_block} {empty_block_logic();}
{Open_P} {stack.push(new Symbol(yytext()));}
{Open_B} {
 		lines++;
		open_bracket_logic();
		  }
{Closed_B} {
		lines++;
		close_bracket_logic();}
{if} {
	seq_logic("if");
	}
{else} {}
{while} {seq_logic("while");}
{BVal} {stack.push(new BoolNode(yytext()));}
{Var} {
	VarList list = VarList.getInstance(null);
	if(!list.variables.containsKey(yytext()))
	{
		UndeclaredVariablesList l = UndeclaredVariablesList.getInstance();
		l.addEntry(yytext(), lines);
	}

	stack.push(new VarNode(yytext()));
	}
{AVal} {stack.push(new IntNode(yytext()));}
{Semicolon} {
		lines++;
		SemicolonLogic();
}

{Closed_P} {restrict_stack(1);}
{Ignore} {}

. {}
