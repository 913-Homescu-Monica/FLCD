
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     PLUS = 258,
     MINUS = 259,
     TIMES = 260,
     DIV = 261,
     MOD = 262,
     EQ = 263,
     LESSEQ = 264,
     EQQ = 265,
     NEQ = 266,
     BIGGEREQ = 267,
     BIGGER = 268,
     LESS = 269,
     BRACKETOPEN = 270,
     BRACKETCLOSE = 271,
     OPEN = 272,
     CLOSE = 273,
     SQBRACKETOPEN = 274,
     SQBRACKETCLOSE = 275,
     COLON = 276,
     SEMICOLON = 277,
     COMMA = 278,
     PROGRAM = 279,
     INPUT = 280,
     OUTPUT = 281,
     INT = 282,
     CHAR = 283,
     STR = 284,
     GIVEN = 285,
     THEN = 286,
     OTHERWISE = 287,
     ASLONGAS = 288,
     REPEAT = 289,
     IDENTIFIER = 290,
     INTEGER_CONSTANT = 291,
     STRING_CONSTANT = 292,
     CHARACTER_CONSTANT = 293
   };
#endif



#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


