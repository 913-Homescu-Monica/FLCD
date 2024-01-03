%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex();
void yyerror(char *s);

#define YYDEBUG 1
%}

%token PLUS
%token MINUS
%token TIMES
%token DIV
%token MOD
%token EQ
%token LESSEQ
%token EQQ
%token NEQ
%token BIGGEREQ
%token BIGGER
%token LESS

%token BRACKETOPEN
%token BRACKETCLOSE
%token OPEN
%token CLOSE
%token SQBRACKETOPEN
%token SQBRACKETCLOSE
%token COLON
%token SEMICOLON
%token COMMA

%token PROGRAM
%token INPUT
%token OUTPUT
%token INT
%token CHAR
%token STR
%token GIVEN
%token THEN
%token OTHERWISE
%token ASLONGAS
%token REPEAT

%token IDENTIFIER
%token INTEGER_CONSTANT
%token STRING_CONSTANT
%token CHARACTER_CONSTANT

%start program

%%

program : PROGRAM compound_statement

decllist : declaration | declaration COMMA decllist

statement : decllist | assignstmt| iostmt | ifstmt | whilestmt

statement_list : statement | statement statement_list

compound_statement : BRACKETOPEN statement_list BRACKETCLOSE

expression : expression PLUS term | expression MINUS term | term

term : term TIMES factor | term DIV factor | term MOD factor | factor

factor : OPEN expression CLOSE | IDENTIFIER | constant

constant : INTEGER_CONSTANT | CHARACTER_CONSTANT | STRING_CONSTANT

iostmt : INPUT OPEN IDENTIFIER CLOSE | OUTPUT OPEN IDENTIFIER CLOSE | OUTPUT OPEN constant CLOSE

type : simple_type | array_declaration

simple_type : INT | CHAR | STR

array_declaration : simple_type SQBRACKETOPEN INTEGER_CONSTANT SQBRACKETCLOSE

declaration : type COLON IDENTIFIER

assignstmt : IDENTIFIER EQ expression

ifstmt : GIVEN OPEN condition CLOSE THEN compound_statement | GIVEN OPEN condition CLOSE THEN compound_statement OTHERWISE compound_statement

whilestmt : ASLONGAS OPEN condition CLOSE REPEAT compound_statement

condition : expression relation expression

relation : LESS | LESSEQ | EQQ | NEQ | BIGGEREQ | BIGGER

%%

void yyerror(char *s) {
  printf("%s\n", s);
}

extern FILE *yyin;

int main(int argc, char **argv) {
  if (argc > 1)
    yyin = fopen(argv[1], "r");
  if ((argc > 2) && (!strcmp(argv[2], "-d")))
    yydebug = 1;
  if (!yyparse())
    fprintf(stderr,"\nParsed successfully!\n");
}