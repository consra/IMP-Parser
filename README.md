# IMP-Parser
Lexical analyzer written in Java, using JFlex and ANTLR, in order to parse a C-like language(IMP) and to interpret the AST tree

The project consists mainly of 2 parts:
  1) The first part is an interpreter and a parser written in Java using JFLEX
  2) The second part is only a parser written in Java using ANTLR
  
  
Example of input code (IMP language):

 ```c
int i, j;
i = 0;
j = 12;
while (!(i > 7)) {
	if (i > 8) {
		j = j + k;
	} else {}
	i = i + 1;
}
  ``` 
 # Parse Phase
 The code above will be translated in a AST tree after the parse phase:
 
 ```
 <MainNode>
	<SequenceNode>
		<AssignmentNode> =
			<VariableNode> i
			<IntNode> 0
		<SequenceNode>
			<AssignmentNode> =
				<VariableNode> j
				<IntNode> 12
			<WhileNode> while
				<BracketNode> ()
					<NotNode> !
						<BracketNode> ()
							<GreaterNode> >
								<VariableNode> i
								<IntNode> 7
				<BlockNode> {}
					<SequenceNode>
						<IfNode> if
							<BracketNode> ()
								<GreaterNode> >
									<VariableNode> i
									<IntNode> 8
							<BlockNode> {}
								<AssignmentNode> =
									<VariableNode> j
									<PlusNode> +
										<VariableNode> j
										<VariableNode> k
							<BlockNode> {}
						<AssignmentNode> =
							<VariableNode> i
							<PlusNode> +
								<VariableNode> i
								<IntNode> 1

 ```
# Interpret Phase
The AST thre will be interpreted 
