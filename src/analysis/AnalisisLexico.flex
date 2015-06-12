package analysis;
import java_cup.runtime.Symbol;
%%
%class AnalizadorLexico
%function next_token
%type java_cup.runtime.Symbol
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
ID =  (_[a-zA-Z]) ([a-zA-Z0-9_]){0,31}
TYPE = (const)? (char|int|float|string)
DOOR = (D[1-9])
%%

">" {
		final String str = "MORETHAN";
		output.append( str );
	    }
"<" {
		final String str = "LESSTHAN";
		output.append( str );
	    }
"<=" {
		final String str = "LESSEQUALS";
		output.append( str );
	    }
">=" {
		final String str = "MOREEQUALS";
		output.append( str );
	    }
"==" {
		final String str = "EQUALS";
		output.append( str );
	    }
"!=" {
		final String str = "DIFFERENT";
		output.append( str );
	    }
"+" {
		final String str = "PLUS";
		output.append( str );
	    }
"-" {
		final String str = "MINUS";
		output.append( str );
	    }
"*" {
		final String str = "TIMES";
		output.append( str );
	    }
"/" {
		final String str = "DIVIDES";
		output.append( str );
	    }
"=" {
		final String str = "ASSIGN";
		output.append( str );
	    }
"(" {
		final String str = "LBRACK";
		output.append( str );
	    }
")" {
		final String str = "RBRACK";
		output.append( str );
	    }
"{" {
		final String str = "LCURL";
		output.append( str );
	    }
"}" {
		final String str = "RCURL";
		output.append( str );
	    }

"declare" {
		final String str = "DECLARE";
		output.append( str );
	    }
"move"  {
		final String str = "MOVE";
		output.append( str );
	    }
"if"  {
		final String str = "IF";
		output.append( str );
	    }
"then"  {
		final String str = "THEN";
		output.append( str );
	    }
"else"  {
		final String str = "ELSE";
		output.append( str );
	    }
"while"  {
		final String str = "WHILE";
		output.append( str );
	    }
"do"  {
		final String str = "DO";
		output.append( str );
	    }
"DECLARE"  {
		final String str = "DECLARE";
		output.append( str );
	    }
"MOVE"  {
		final String str = "MOVE";
		output.append( str );
	    }
"IF"  {
		final String str = "IF";
		output.append( str );
	    }
"THEN"  {
		final String str = "THEN";
		output.append( str );
	    }
"ELSE"  {
		final String str = "ELSE";
		output.append( str );
	    }
"WHILE"  {
		final String str = "WHILE";
		output.append( str );
	    }
"DO"  {
		final String str = "DO";
		output.append( str );
	    }

"true"  {
		final String str = "TRUE";
		output.append( str );
	    }
"false"  {
		final String str = "FALSE";
		output.append( str );
	    }
"TRUE"  {
		final String str = "TRUE";
		output.append( str );
	    }
"FALSE"  {
		final String str = "FALSE";
		output.append( str );
	    }
{NUM}  {
		final String str = "NUM";
		output.append( str );
	    }
{DOOR}	{
		final String str = "DOOR":
		output.append(str);
		}
{ID}  {
		final String str = "ID";
		output.append( str );
	    }
{TYPE} {
		final String str = "TYPE";
		output.append( str );}
{NEWLINE}  {
		final String str = "\n";
		output.append( str );
	   }
{SPACE}  {
		final String str = " ";
		output.append( str );
	    }
. {
		final String str = "Invalid input: " + yytext() + "line: "+ yyline;
		errorsHandler.lexicalError(str);
	    }