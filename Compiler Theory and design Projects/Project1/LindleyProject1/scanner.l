/* Compiler Theory and Design
/* Lindley, Thomas
/* 01NOV2021
/* This file contains flex input file */

%{
#include <cstdio>
#include <string>

using namespace std;

#include "listing.h"
#include "tokens.h"

%}

%option noyywrap

ws		[ \t\r]+
comment		\-\-.*\n|"//".\n
line		[\n]
digit		[0-9]
real [0-9]+\.[0-9]*([eE]([+-]?)[0-9]+)?
id		[A-Za-z][0-9]*([_]?[A-Za-z0-9])*
int		{digit}+
punc		[\(\),:;]
bool	"([true])"|"([false])"
%%

{ws}		{ ECHO; }
{comment}	{ ECHO; nextLine();}
{line}		{ ECHO; nextLine();}
"=>"	{ ECHO; return(ARROW); }
"<"		{ ECHO; return(RELOP); }
"="	{ ECHO; return(RELOP); }
"/="	{ ECHO; return(RELOP); }
">"	{ ECHO; return(RELOP); }
">="	{ ECHO; return(RELOP); }
"<="	{ ECHO; return(RELOP); }
"+"|"-"			{ ECHO; return(ADDOP); }
"*"|"/"	{ ECHO; return(MULOP); }
"or" { ECHO; return(OROP); }
"not" { ECHO; return(NOTOP); }
"rem" { ECHO; return(REMOP); }
"**"	{ ECHO; return(EXPOP); }
begin		{ ECHO; return(BEGIN_); }
boolean		{ ECHO; return(BOOLEAN); }
end		{ ECHO; return(END); }
endreduce	{ ECHO; return(ENDREDUCE); }
function	{ ECHO; return(FUNCTION); }
integer		{ ECHO; return(INTEGER); }
is		{ ECHO; return(IS); }
reduce		{ ECHO; return REDUCE; }
returns		{ ECHO; return(RETURNS); }
and		{ ECHO; return(ANDOP); }
case	{ ECHO; return(CASE); }
endcase { ECHO; return(ENDCASE); }
if { ECHO; return(IF); }
endif { ECHO; return(ENDIF); }
others { ECHO; return(OTHERS); }
real	{ ECHO; return(REAL); }
then	{ ECHO; return(THEN); }
when	{ ECHO; return(WHEN); }
{real}	{ ECHO; return(REAL_LITERAL); }
{id}		{ ECHO; return(IDENTIFIER);}
{int}		{ ECHO; return(INT_LITERAL); }
{bool}	{ ECHO; return(BOOL_LITERAL); }
{punc}		{ ECHO; return(yytext[0]); }

.		{ ECHO; appendError(LEXICAL, yytext); }
%%

int main()
{
	firstLine();
	
	FILE *file = fopen("lexemes.txt", "wa"); 
	int token = yylex();
	while (token)
	{
		fprintf(file, "%d %s\n", token, yytext);
		token = yylex();
	}
	lastLine();
	fclose(file);
	return 0;
}