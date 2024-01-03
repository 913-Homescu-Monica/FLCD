%{ 	 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "parser.tab.h"

int line = 1;
%} 

%option noyywrap

IDENTIFIER		\#([A-Za-z]+)
INTEGER_CONSTANT	\-?[1-9][0-9]*|0
CHARACTER_CONSTANT		\'[a-zA-Z0-9]\'
STRING_CONSTANT		\"[a-zA-Z0-9]+\"

%%

"+" { printf("OPERATOR -> %s\n", yytext); return PLUS; }
"-" { printf("OPERATOR -> %s\n", yytext); return MINUS; }
"*" { printf("OPERATOR -> %s\n", yytext); return TIMES; }
"/" { printf("OPERATOR -> %s\n", yytext); return DIV; }
"%" { printf("OPERATOR -> %s\n", yytext); return MOD; }
"=" { printf("OPERATOR -> %s\n", yytext); return EQ; }
"<=" { printf("OPERATOR -> %s\n", yytext); return LESSEQ; }
"==" { printf("OPERATOR -> %s\n", yytext); return EQQ; }
"!=" { printf("OPERATOR -> %s\n", yytext); return NEQ; }
">=" { printf("OPERATOR -> %s\n", yytext); return BIGGEREQ; }
">" { printf("OPERATOR -> %s\n", yytext); return BIGGER; }
"<" { printf("OPERATOR -> %s\n", yytext); return LESS; }

"{" { printf("SEPARATOR -> %s\n", yytext); return BRACKETOPEN; }
"}" { printf("SEPARATOR -> %s\n", yytext); return BRACKETCLOSE; }
"(" { printf("SEPARATOR -> %s\n", yytext); return OPEN; }
")" { printf("SEPARATOR -> %s\n", yytext); return CLOSE; }
"[" { printf("SEPARATOR -> %s\n", yytext); return SQBRACKETOPEN; }
"]" { printf("SEPARATOR -> %s\n", yytext); return SQBRACKETCLOSE; }
":" { printf("SEPARATOR -> %s\n", yytext); return COLON; }
";" { printf("SEPARATOR -> %s\n", yytext); return SEMICOLON; }
"," { printf("SEPARATOR -> %s\n", yytext); return COMMA; }

"program" { printf("RESERVED WORD -> %s\n", yytext); return PROGRAM; }
"input" { printf("RESERVED WORD -> %s\n", yytext); return INPUT; }
"output" { printf("RESERVED WORD -> %s\n", yytext); return OUTPUT; }
"int" { printf("RESERVED WORD -> %s\n", yytext); return INT; }
"char" { printf("RESERVED WORD -> %s\n", yytext); return CHAR; }
"str" { printf("RESERVED WORD -> %s\n", yytext); return STR; }
"given" { printf("RESERVED WORD -> %s\n", yytext); return GIVEN; }
"then" { printf("RESERVED WORD -> %s\n", yytext); return THEN; }
"otherwise" { printf("RESERVED WORD -> %s\n", yytext); return OTHERWISE; }
"aslongas" { printf("RESERVED WORD -> %s\n", yytext); return ASLONGAS; }
"repeat" { printf("RESERVED WORD -> %s\n", yytext); return REPEAT; }

{IDENTIFIER}		{ printf("IDENTIFIER -> %s\n", yytext); return IDENTIFIER; }
{INTEGER_CONSTANT}		{ printf("INTEGER CONSTANT -> %s\n", yytext); return INTEGER_CONSTANT; }
{STRING_CONSTANT}		{ printf("STRING CONSTANT -> %s\n", yytext); return STRING_CONSTANT; }
{CHARACTER_CONSTANT}		{ printf("CHARACTER CONSTANT -> %s\n", yytext); return CHARACTER_CONSTANT; }

[ \t]+		{}
[\n]+	{line++;}

. {printf("Error for token %s on line %d!\n", yytext, line); exit(1);}

%%