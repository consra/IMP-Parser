# IMP-Parser
Lexical analyzer written in Java, using JFlex and ANTLR, in order to parse a C-like language(IMP) and to interpret the AST tree

The project consists mainly of 2 parts:
  1) The first part is an interpreter and a parser written in Java using JFLEX
  2) The second part is only a parser written in Java using ANTLR
  
  
Example of input code (IMP language):
    int i, j, k;
    i = 0;
    j = 12;
    while (!(i > 7)) {
	      if (j > 20) {
		    j = j + k;
	      } else {
		j = j + 1;
	}
	i = i + 1;
}
