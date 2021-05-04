grammar Gian ;

compilationUnit : classDeclaration EOF ; // root rule
classDeclaration : className '{' classBody '}' ; // there's no keyword 'class' in Gian
className : ID ;
classBody : ( variable | print )* ;
variable : VARIABLE ID EQUALS value ; // variable definition
print : PRINT ID ; // print variable
value : op=NUMBER
      | op=STRING ; // variable value, must be numbers or strings

VARIABLE : 'var' ;
PRINT : 'print' ;
EQUALS : '=' ;
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z][a-zA-Z0-9]+ ;
WS: [ \t\n\r]+ -> skip ; //special TOKEN for skipping whitespaces