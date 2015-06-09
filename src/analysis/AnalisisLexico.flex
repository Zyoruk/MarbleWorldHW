package analysis;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico
%public
%full
%unicode
%line
%column
%char
%cup

NEWLINE = \r|\n|\r\n|\n\r
SPACE = [ \t\f]
NUM = [0-9][0-9]*.?[0-9]*
ID = (CHARACTER|"_") ([CHARACTER|0-9]){0,31}
TYPE = const? (char|int|float|string)
DOOR= [1-9]
CHARACTER= [a-zA-z]
%%

">" {return new Symbol(sym.MORETHAN);}
"<" {return new Symbol(sym.LESSTHAN);}
"<=" {return new Symbol(sym.LESSEQUALS);}
">=" {return new Symbol(sym.MOREEQUAL);}
"==" {return new Symbol(sym.EQUALS);}
"!=" {return new Symbol(sym.DIFFERENT);}
"+" {return new Symbol(sym.PLUS);}
"-" {return new Symbol(sym.MINUS);}
"*" {return new Symbol(sym.TIMES);}
"/" {return new Symbol(sym.DIVISION);}
"=" {return new Symbol(sym.ASSIGN);}
"(" {return new Symbol(sym.LBRACK);}
")" {return new Symbol(sym.RBRACK);}
"{" {return new Symbol(sym.LCURL);}
"}" {return new Symbol(sym.RCURL);}

"declare" {return new Symbol(sym.DECLARE);}
"move" {return new Symbol(sym.MOVE);}
"if" {return new Symbol(sym.IF);}
"then" {return new Symbol(sym.THEN);}
"else" {return new Symbol(sym.ELSE);}
"while" {return new Symbol(sym.WHILE);}
"do" {return new Symbol(sym.DO);}
"DECLARE" {return new Symbol(sym.DECLARE);}
"MOVE" {return new Symbol(sym.MOVE);}
"IF" {return new Symbol(sym.IF);}
"THEN" {return new Symbol(sym.THEN);}
"ELSE" {return new Symbol(sym.ELSE);}
"WHILE" {return new Symbol(sym.WHILE);}
"DO" {return new Symbol(sym.DO);}

"true" {return new Symbol(sym.TRUE);}
"false" {return new Symbol(sym.FALSE);}
"TRUE" {return new Symbol(sym.TRUE);}
"FALSE" {return new Symbol(sym.FALSE);}

{NUM} {return new Symbol(sym.NUM);}
{CHARACTER} {return new Symbol(sym.CHARACTER);}
{TYPE} {return new Symbol(sym.TYPE);}
{DOOR} {return new Symbol(sym.DOOR)}
{ID} {return new Symbol(sym.ID);}
{NEWLINE} {return new Symbol(sym.NEWLINE);}
{SPACE} {/*Spaces are ignored*/}
. {System.err.println("Invalid input: " + yytext() + "line: "+ yyline);}
