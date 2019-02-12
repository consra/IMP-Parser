/* The following code was generated by JFlex 1.4.3 on 1/1/19, 9:54 PM */

import java.util.*;
import java.util.Stack;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 1/1/19, 9:54 PM from the specification file
 * <tt>Hello.flex</tt>
 */
class HelloLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\0\25\0\1\25\1\21\4\0\1\23\1\0\1\21\1\22"+
    "\1\0\1\21\1\26\2\0\1\21\1\2\11\1\1\0\1\27\1\0"+
    "\1\21\1\21\42\0\1\10\3\16\1\6\1\7\1\16\1\15\1\13"+
    "\2\16\1\11\1\16\1\24\3\16\1\4\1\12\1\3\1\5\1\16"+
    "\1\14\3\16\1\17\1\0\1\20\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\6\3\1\4\1\5\1\6\1\7"+
    "\1\1\1\10\3\3\1\11\2\3\1\12\5\3\1\13"+
    "\1\1\1\0\1\3\1\0\1\14\1\0\1\15";

  private static int [] zzUnpackAction() {
    int [] result = new int[36];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\30\0\60\0\30\0\110\0\140\0\170\0\220"+
    "\0\250\0\300\0\330\0\30\0\30\0\30\0\360\0\30"+
    "\0\u0108\0\u0120\0\u0138\0\140\0\u0150\0\u0168\0\30\0\u0180"+
    "\0\u0198\0\u01b0\0\u01c8\0\u01e0\0\140\0\140\0\u01f8\0\u0210"+
    "\0\u0228\0\140\0\u0240\0\30";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[36];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\2\6\1\7\1\10\3\6"+
    "\1\11\1\12\2\6\1\13\1\14\1\15\1\16\1\17"+
    "\1\6\2\2\1\20\31\0\2\3\30\0\1\6\1\21"+
    "\12\6\5\0\1\6\6\0\14\6\5\0\1\6\6\0"+
    "\6\6\1\22\5\6\5\0\1\6\6\0\5\6\1\23"+
    "\6\6\5\0\1\6\6\0\4\6\1\24\7\6\5\0"+
    "\1\25\6\0\12\6\1\26\1\6\5\0\1\6\23\0"+
    "\1\27\32\0\1\15\7\0\2\6\1\30\11\6\5\0"+
    "\1\6\6\0\7\6\1\31\4\6\5\0\1\6\6\0"+
    "\6\6\1\32\5\6\5\0\1\6\6\0\1\33\13\6"+
    "\5\0\1\6\6\0\10\6\1\34\3\6\5\0\1\6"+
    "\6\0\3\6\1\35\10\6\5\0\1\6\6\0\3\6"+
    "\1\36\10\6\5\0\1\6\6\0\7\6\1\30\4\6"+
    "\5\0\1\6\6\0\14\6\5\0\1\6\1\37\5\0"+
    "\6\6\1\40\5\6\5\0\1\6\6\0\14\41\5\0"+
    "\1\41\6\0\3\6\1\42\10\6\5\0\1\6\6\0"+
    "\14\41\5\0\1\41\1\0\1\43\1\44\3\0\14\41"+
    "\5\0\1\41\1\43\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[600];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\7\1\3\11\1\1\1\11"+
    "\6\1\1\11\7\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[36];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

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



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  HelloLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  HelloLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 92) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 11: 
          { stack.push(new BoolNode(yytext()));
          }
        case 14: break;
        case 10: 
          { empty_block_logic();
          }
        case 15: break;
        case 5: 
          { lines++;
		close_bracket_logic();
          }
        case 16: break;
        case 3: 
          { VarList list = VarList.getInstance(null);
	if(!list.variables.containsKey(yytext()))
	{
		UndeclaredVariablesList l = UndeclaredVariablesList.getInstance();
		l.addEntry(yytext(), lines);
	}

	stack.push(new VarNode(yytext()));
          }
        case 17: break;
        case 2: 
          { stack.push(new IntNode(yytext()));
          }
        case 18: break;
        case 4: 
          { lines++;
		open_bracket_logic();
          }
        case 19: break;
        case 12: 
          { seq_logic("while");
          }
        case 20: break;
        case 8: 
          { lines++;
		SemicolonLogic();
          }
        case 21: break;
        case 6: 
          { stack.push(new Symbol(yytext()));
          }
        case 22: break;
        case 13: 
          { VarList.getInstance(yytext());
	stack.push(mainNode);
	stack.push(Firstseq);
          }
        case 23: break;
        case 7: 
          { restrict_stack(1);
          }
        case 24: break;
        case 9: 
          { seq_logic("if");
          }
        case 25: break;
        case 1: 
          { 
          }
        case 26: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
