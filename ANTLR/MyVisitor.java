import java.lang.Integer;

class MyVisitor extends HelloBaseVisitor<Integer> {
    private int tabs = 0;

    // Functie rudimentara pentru a printa tab-uri
    private void printTabs() {
        for (int i = 0; i < this.tabs; i++) {
            System.out.print("\t");
        }
    }

	@Override public Integer visitMainnode(HelloParser.MainnodeContext ctx) {
	    this.printTabs();
	    System.out.println("<MainNode>");

	    this.tabs++;
		visit(ctx.getChild(2));
	    this.tabs--;

	    return 0;
	}

	@Override public Integer visitSequencenode(HelloParser.SequencenodeContext ctx) {
		this.printTabs();
		System.out.println("<SequenceNode>");

		this.tabs++;
		// visit(ctx.statement(0));
		// if(ctx.statement(1) == null && ctx.sequencenode() != null)
		// 	visit(ctx.sequencenode());
		// else
		// 	visit(ctx.statement(1));
		visit(ctx.getChild(0));
		visit(ctx.getChild(1));
		this.tabs--;

		return 0;
	}

	@Override public Integer visitIfnode(HelloParser.IfnodeContext ctx) {
		this.printTabs();
		System.out.println("<IfNode> if");
		this.tabs++;

			visit(ctx.bexpr());

		visit(ctx.blocknode(0));
		visit(ctx.blocknode(1));
		this.tabs--;

		return 0;
	}

	@Override public Integer visitWhilenode(HelloParser.WhilenodeContext ctx) {
		this.printTabs();
		System.out.println("<WhileNode> while");
		this.tabs++;
		visit(ctx.bexpr());
		visit(ctx.blocknode());
		this.tabs--;

		return 0;
	}
	@Override public Integer visitStatement(HelloParser.StatementContext ctx) {

		visit(ctx.getChild(0));

		return 0;
	}

	@Override public Integer visitBlocknode(HelloParser.BlocknodeContext ctx) {
		this.printTabs();
		System.out.println("<BlockNode> {}");
		if(ctx.getChild(0) == null)
			return 0;

		this.tabs++;
		if(ctx.sequencenode() != null)
		{
			visit(ctx.sequencenode());
		}
		if(ctx.statement() != null)
		{
			visit(ctx.statement());
		}
		this.tabs--;

		return 0;
	}

	@Override public Integer visitAssigmentnode(HelloParser.AssigmentnodeContext ctx) {
		this.printTabs();
		System.out.println("<AssignmentNode> =");

		this.tabs++;
		visit(ctx.getChild(0));
		visit(ctx.getChild(2));
		this.tabs--;

		return 0;
	}

	@Override public Integer visitPlusnode(HelloParser.PlusnodeContext ctx) {
		this.printTabs();
		System.out.println("<PlusNode> +");

		return 0;
	}

	@Override public Integer visitDivnode(HelloParser.DivnodeContext ctx) {
		this.printTabs();
		System.out.println("<DivNode> /");

		return 0;
	}

	@Override public Integer visitNotnode(HelloParser.NotnodeContext ctx) {
		this.printTabs();
		System.out.println("<NotNode> !");

		return 0;
	}

	@Override public Integer visitGreaternode(HelloParser.GreaternodeContext ctx) {
		this.printTabs();
		System.out.println("<GreaterNode> >");

		return 0;
	}

	@Override public Integer visitAndnode(HelloParser.AndnodeContext ctx) {
		this.printTabs();
		System.out.println("<AndNode> &&");

		return 0;
	}

	@Override public Integer visitBracketnode(HelloParser.BracketnodeContext ctx) {
		this.printTabs();
		System.out.println("<BracketNode> ()");

		this.tabs++;
		if(ctx.expr() != null)
			visit(ctx.expr());

		else if(ctx.bexpr() != null)
			visit(ctx.bexpr());

		this.tabs--;
		return 0;
	}

	@Override public Integer visitExpr(HelloParser.ExprContext ctx) {
		if(ctx.varnode() != null)
			visit(ctx.varnode());

		if(ctx.intnode() != null)
			visit(ctx.intnode());

		if(ctx.bracketnode() != null)
			visit(ctx.bracketnode());

		if(ctx.plusnode() != null)
		{
			visit(ctx.plusnode());
			this.tabs++;
			visit(ctx.expr(0));
			visit(ctx.expr(1));
			this.tabs--;
		}

		if(ctx.divnode() != null)
		{
			visit(ctx.divnode());

			this.tabs++;
			visit(ctx.expr(0));
			visit(ctx.expr(1));
			this.tabs--;
		}

		return 0;
	}

	@Override public Integer visitBexpr(HelloParser.BexprContext ctx) {
		if(ctx.boolnode() != null)
			visit(ctx.boolnode());

		 if(ctx.bracketnode() != null)
		 	visit(ctx.bracketnode());

		if(ctx.notnode() != null)
		{
			visit(ctx.notnode());
			this.tabs++;
			visit(ctx.bexpr(0));
			this.tabs--;
		}

		if(ctx.andnode() != null)
		{
			visit(ctx.andnode());

			this.tabs++;
			visit(ctx.bexpr(0));
			visit(ctx.bexpr(1));
			this.tabs--;
		}

		if(ctx.greaternode() != null)
		{
			visit(ctx.greaternode());

			this.tabs++;
			visit(ctx.expr(0));
			visit(ctx.expr(1));
			this.tabs--;
		}

		return 0;
	}

	@Override public Integer visitIntnode(HelloParser.IntnodeContext ctx) {
	    this.printTabs();
	    System.out.println("<IntNode> " + ctx.getText());

	    return 0;
	}

	@Override public Integer visitVarnode(HelloParser.VarnodeContext ctx) {
	    this.printTabs();
	    System.out.println("<VariableNode> " + ctx.getText());

	    return 0;
	}

	@Override public Integer visitBoolnode(HelloParser.BoolnodeContext ctx) {
		this.printTabs();
		System.out.println("<BoolNode> " + ctx.getText());

		return 0;
	}
}
