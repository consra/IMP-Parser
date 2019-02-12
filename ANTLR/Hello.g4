grammar Hello;

/* Parser Rules */
mainnode 	  : varlist ';' sequencenode | varlist ';' statement ;
varlist 	  : 'int ' (VAR',')* VAR;
ifnode 		  : 'if' bexpr blocknode 'else' blocknode ;
expr  : bracketnode
      | expr divnode expr
	  | expr plusnode expr
      | varnode
      | intnode
	  ;

bexpr :	bracketnode
 	  | notnode bexpr
	  | expr greaternode expr
	  | bexpr andnode bexpr
	  | boolnode
	  ;
sequencenode  : statement statement | statement sequencenode ;
greaternode   : '>' ;
andnode       : '&&';
plusnode 	  : '+' ;
divnode 	  : '/' ;
notnode		  : '!' ;
bracketnode   : '(' expr ')' | '(' bexpr ')';
blocknode	  : '{''}' | '{' sequencenode '}' | '{' statement '}' ;
assigmentnode : varnode '=' expr ';';
statement 	  : assigmentnode | whilenode | ifnode;

whilenode 	  :	'while' bexpr  blocknode ;
boolnode 	  : BVAL ;
varnode 	  : VAR ;
intnode 	  : AVAL ;

/* Lexer Rules */
fragment NUMBER     : [0-9]+ ;
fragment STRING 	: [a-z]+ ;
WS 			     	: [ \t\r\n]+ -> skip ;
BVAL                : 'true' | 'false' ;
VAR 				: STRING ;
AVAL 				: NUMBER ;
EQ  				: '=' ;
