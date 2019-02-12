import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

abstract interface Expression {
	String show();
	Expression interpret(int type);
};

/* singleton pattern */
class VarList
{
	static VarList Instance = null;
	public Map<String, Integer> variables = new LinkedHashMap<String, Integer>();

	private VarList(String params)
	{

		if(params != null)
		{
			String[] aux = params.replace(",", "").replace(";", "").split(" ");
			for(int i = 0; i < aux.length; i++)
			{
				if(aux[i] != null && !aux[i].equals("int") )
					variables.put(aux[i], Integer.MAX_VALUE);
			}
		}
	}
	static VarList getInstance(String params)
	{
		if(Instance == null)
			Instance = new VarList(params);

 		return Instance;
	}

	boolean isInVarList(String variable)
	{
		for(String var : variables.keySet())
		{
			if(var.equals(variable))
				return true;
		}

		return false;
	}
};
class UndeclaredVariablesList
{
	static UndeclaredVariablesList Instance = null;
	public Map<String, Integer> variables = new LinkedHashMap<String, Integer>();

	private UndeclaredVariablesList()
	{

	}
	void execute()
	{
		if(this.variables.entrySet().size() == 0)
			return;

		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output", "UTF-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		for (Map.Entry<String, Integer> entry : this.variables.entrySet()) {

			writer.print("UnassignedVar" + " " + entry.getValue() + "\n");
		}

		writer.close();
		System.exit(0);
	}
	void addEntry(String var, int line)
	{
		this.variables.put(var , line);
	}
	static UndeclaredVariablesList getInstance()
	{
		if(Instance == null)
			Instance = new UndeclaredVariablesList();

 		return Instance;
	}
};
class WhileNode implements Expression
{
	Expression cond = null;
	Expression b = null;
	WhileNode()
	{
	}

	public String show()
	{
		String build = "​<WhileNode> while" + "\n";

		String print = "";
		print += cond.show() + b.show();

		build += Parser.addNewline(print);
		return build;
	}

	void setCond(Expression cond)
	{
		this.cond = cond;
	}
	void setB(Expression b)
	{
		this.b = b;
	}
	Expression getCond()
	{
		return this.cond;
	}
	Expression getB()
	{
		return this.b;
	}
	public Expression interpret(int type) {
		while(true)
		{
			BracketNode brcondition = (BracketNode)this.getCond();
			BoolNode condition = (BoolNode) brcondition.interpret(0);
			if(!(condition.getValue()))
				break;

			this.getB().interpret(0);
		}
		return null;
	}
};

class SequenceNode implements Expression
{
	Expression c1 = null;
	Expression c2 = null;

	SequenceNode()
	{
	}

	public String show()
	{
		String build = "​<SequenceNode>" + "\n";

		String print = "";
		print += c1.show();
		if(c2 != null)
			print += c2.show();

		build += Parser.addNewline(print);
		return build;
	}

	void setC1(Expression c1)
	{
		this.c1 = c1;
	}
	void setC2(Expression c2)
	{
		this.c2 = c2;
	}
	Expression getC1()
	{
		return this.c1;
	}
	Expression getC2()
	{
		return this.c2;
	}
	public Expression interpret(int type) {
		if(this.getC1() != null)
			this.getC1().interpret(0);

		if(this.getC2() != null)
			this.getC2().interpret(0);

		return null;
	}
}

class IfNode implements Expression
{
	Expression cond = null;
	Expression b1 = null;
	Expression b2 = null;
	IfNode()
	{
	}

	public String show()
	{
		String build = "​<IfNode> if" + "\n";

		String print = "";
		print += cond.show();
		print += b1.show();
		print += b2.show();

		build += Parser.addNewline(print);
		return build;
	}

	void setCond(Expression cond)
	{
		this.cond = cond;
	}
	void setB1(Expression b1)
	{
		this.b1 = b1;
	}
	void setB2(Expression b2)
	{
		this.b2 = b2;
	}
	Expression getCond()
	{
		return this.cond;
	}
	Expression getB1()
	{
		return this.b1;
	}
	Expression getB2()
	{
		return this.b2;
	}
	public Expression interpret(int type) {
		BoolNode condition = (BoolNode) cond.interpret(0);

		if(condition.getValue() == true)
		{
			this.getB1().interpret(0);
		}
		else
		{
			this.getB2().interpret(0);
		}
		return null;
	}
};
class MainNode implements Expression {
	Expression expr;
	public MainNode(Expression expr)
	{
		this.expr = expr;
	}

	public String show()
	{

		String build = "​<MainNode>\n";

		String print = expr.show();

		build += Parser.addNewline(print);

		return build;
	}

	public Expression interpret(int type) {
		return expr.interpret(0);
	}
};

class VarNode implements Expression
{
	String var;
	VarNode(String expr)
	{
		this.var = expr;
	}

	public String show()
	{
		return "​<VariableNode> " + var + "\n";
	}

	String getValue()
	{
		return var;
	}

	public Expression interpret(int type) {
		VarList list = VarList.getInstance(null);
		if(!list.variables.containsKey(this.getValue()))
		{
			return new Eror("UnassignedVar");
		}
		if(type == 0)
		{

			int value = list.variables.get(this.getValue());
			//System.out.println(value + " " + this.getValue());
			if(value == Integer.MAX_VALUE)
				return new Eror("UnassignedVar");

			return new IntNode(String.valueOf(value));
		}
		else
		{
			return this;
		}
	}
};

class NotNode implements Expression
{
	Expression expr;
	NotNode(Expression expr)
	{
		this.expr = expr;
	}

	public String show()
	{

		String build = "";
		build += "​<NotNode> !\n";

		String print = "";

		print += expr.show();

		build += Parser.addNewline(print);

		return build;
	}

	public Expression interpret(int type){
		BoolNode n = (BoolNode) expr.interpret(0);

		return new BoolNode(String.valueOf((!n.getValue())));
	}
};

class BoolNode implements Expression
{
	String var;
	BoolNode(String expr)
	{
		this.var = expr;
	}

	public String show()
	{
		return "​<BoolNode> " + var + "\n";
	}
	boolean getValue()
	{
		return Boolean.parseBoolean(this.var);
	}
	public Expression interpret(int type) {
		return this;
	}
};

class BracketNode implements Expression
{
	Expression expr;
	public BracketNode(Expression expr)
	{
		this.expr = expr;
	}

	public String show()
	{

		String build = "";
		build += "​<BracketNode> ()\n";

		String print = "";

		print += expr.show();

		build += Parser.addNewline(print);

		return build;
	}
	void setExpr(Expression expr)
	{
		this.expr = expr;
	}
	public Expression interpret(int type) {
		return expr.interpret(0);
	}
};
class BlockNode implements Expression
{
	Expression expr = null;
	BlockNode()
	{}
	BlockNode(Expression expr)
	{
		this.expr = expr;
	}
	public String show()
	{

		String build = "";
		build += "​<BlockNode> {}\n";

		String print = "";

		if(expr != null)
			print += expr.show();

		build += Parser.addNewline(print);

		return build;
	}
	void setExpr(Expression expr)
	{
		this.expr = expr;
	}
	Expression getExpr()
	{
		return this.expr;
	}
	public Expression interpret(int type) {
		if(this.getExpr() != null)
			return expr.interpret(0);
		else  return null;
	}
};

class AssignmentNode implements Expression
{
	Expression c1;
	Expression c2;
	int line;
	AssignmentNode(Expression c1, Expression c2, int line)
	{
		this.c1 = c1;
		this.c2 = c2;
		this.line = line;
	}

	public String show()
	{
		String build = "​<AssignmentNode> =" + "\n";

		String print = "";
		print += c1.show() + c2.show();

		build += Parser.addNewline(print);
		return build;
	}

	int getLine()
	{
		return this.line;
	}
	public Expression interpret(int type) {

		if(c1.interpret(1) instanceof Eror)
		{
			((Eror)(c1.interpret(0))).terminateProgram(this.getLine());
		}
		if(c2.interpret(0) instanceof Eror)
		{
			((Eror)(c2.interpret(0))).terminateProgram(this.getLine());
		}

		VarNode var = (VarNode) c1.interpret(1);
		IntNode value = (IntNode) c2.interpret(0);
		VarList list = VarList.getInstance(null);

		if (list.variables.containsKey(var.getValue())) {
			list.variables.put(var.getValue(), value.getValue());
		} else {
			(new Eror("UnassignedVar")).terminateProgram(this.getLine());
		}

		return null;
	}
};

class Eror implements Expression
{
	String name;

	public Eror(String name)
	{
		this.name = name;
	}

	public void terminateProgram(int line)
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output", "UTF-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		writer.print(this.name + " " + line + "\n");
		writer.close();
		System.exit(0);
	}
	@Override
	public String show() {
		return null;
	}

	@Override
	public Expression interpret(int line) {
		return this;
	}
}
class NopNode implements Expression
{
	NopNode()
	{
	}

	@Override
	public String show() {
		return null;
	}

	@Override
	public Expression interpret(int type) {
		return null;
	}
}

class IntNode implements Expression {
	String number;

	public IntNode(String number) {
		super();
		this.number = number;
	}

	@Override
	public String show() {
		return "<IntNode> " + number + "\n";
	}

	int getValue()
	{
		return Integer.parseInt(this.number);
	}

	@Override
	public Expression interpret(int type) {
		return this;
	}
};

class PlusNode implements Expression {
	Expression e1 = null;
	Expression e2 = null;

	public PlusNode(Expression expr1, Expression expr2) {
		super();
		e1 = expr1;
		e2 = expr2;
	}

	@Override
	public String show()
	{
		String build = "​<PlusNode> +" + "\n";

		String print = "";
		print += e1.show() + e2.show();

		build += Parser.addNewline(print);
		return build;
	}

	@Override
	public Expression interpret(int type) {
		if(e1.interpret(0) instanceof Eror)
			return e1.interpret(0);
		if(e2.interpret(0) instanceof Eror)
			return e2.interpret(0);

		IntNode n1 = (IntNode) e1.interpret(0);
		IntNode n2 = (IntNode) e2.interpret(0);
		return new IntNode(Integer.toString(n1.getValue() + n2.getValue()));
	}
};

class GreaterNode implements Expression {
	Expression e1 = null;
	Expression e2 = null;

	public GreaterNode(Expression expr1, Expression expr2) {
		super();
		e1 = expr1;
		e2 = expr2;
	}

	@Override
	public String show()
	{
		String build = "​<GreaterNode> >" + "\n";

		String print = "";
		print += e1.show() + e2.show();

		build += Parser.addNewline(print);
		return build;
	}

	@Override
	public Expression interpret(int type) {
		if(e1.interpret(0) instanceof Eror)
			return e1.interpret(0);
		if(e2.interpret(0) instanceof Eror)
			return e2.interpret(0);

		IntNode n1 = (IntNode) e1.interpret(0);
		IntNode n2 = (IntNode) e2.interpret(0);
		return new BoolNode(String.valueOf( n1.getValue() > n2.getValue() ));
	}
};
class AndNode implements Expression {
	Expression e1 = null;
	Expression e2 = null;

	public AndNode(Expression expr1, Expression expr2) {
		super();
		e1 = expr1;
		e2 = expr2;
	}

	@Override
	public String show()
	{
		String build = "​<AndNode> &&" + "\n";

		String print = "";
		print += e1.show() + e2.show();

		build += Parser.addNewline(print);
		return build;
	}

	@Override
	public Expression interpret(int type) {
		if(e1.interpret(0) instanceof Eror)
			return e1.interpret(0);
		if(e2.interpret(0) instanceof Eror)
			return e2.interpret(0);

		BoolNode n1 = (BoolNode) e1.interpret(0);
		BoolNode n2 = (BoolNode) e2.interpret(0);
		return new BoolNode(String.valueOf(n1.getValue() && n2.getValue()));
	}
};

class DivNode implements Expression {
	Expression e1 = null;
	Expression e2 = null;

	public DivNode(Expression expr1, Expression expr2) {
		super();
		e1 = expr1;
		e2 = expr2;
	}

	@Override
	public String show()
	{
		String build = "​<DivNode> /" + "\n";

		String print = "";
		print += e1.show() + e2.show();

		build += Parser.addNewline(print);
		return build;
	}

	@Override
	public Expression interpret(int type) {
		if(e1.interpret(0) instanceof Eror)
			return e1.interpret(0);
		if(e2.interpret(0) instanceof Eror)
			return e2.interpret(0);

		IntNode n1 = (IntNode) e1.interpret(0);
		IntNode n2 = (IntNode) e2.interpret(0);
		if(n2.getValue() == 0)
		{
			return new Eror("DivideByZero");
		}
		return new IntNode(Integer.toString(n1.getValue() / n2.getValue()));
	}
};

class Symbol implements Expression {
	String symbol;

	public Symbol(String symbol) {
		super();
		this.symbol = symbol;
	}

	String symbol() {
		return symbol;
	}

	@Override
	public String show() {
		return null;
	}

	@Override
	public Expression interpret(int type) {
		return null;
	}
};
