// Compiler Theory and Design
// Lindley, Thomas
// 01NOV2021
// This file contains the bodies of the functions that produces the compilation
// listing

#include <cstdio>
#include <string>
#include <queue>

using namespace std;

#include "listing.h"

static int lineNumber;
static string error = "";
static int totalErrors = 0;
static int syntaxErrors = 0;
static int semanticErrors = 0;
static int lexicalErrors = 0;
static queue<string> errorQueue;

static void displayErrors();

void firstLine()
{
	lineNumber = 1;
	printf("\n%4d  ",lineNumber);
}

void nextLine()
{
	displayErrors();
	lineNumber++;
	printf("%4d  ",lineNumber);
}

int lastLine()
{
	printf("\r");
	displayErrors();
	printf("     \n");
	if (totalErrors == 0)
		printf("Compilation Successful\n");
	else if (totalErrors >= 1){
		printf("Lexical Errors %d\n", lexicalErrors);
		printf("Syntax Errors %d\n", syntaxErrors);
		printf("Semantic Errors %d\n", semanticErrors);
	}
	return totalErrors;
}
    
void appendError(ErrorCategories errorCategory, string message)
{
	string messages[] = { "Lexical Error, Invalid Character ", "",
		"Semantic Error, ", "Semantic Error, Duplicate Identifier: ",
		"Semantic Error, Undeclared " };
	if(errorCategory == LEXICAL){
		lexicalErrors++;
	}
	if(errorCategory == GENERAL_SEMANTIC){
		semanticErrors++;
	}
	if(errorCategory == SYNTAX){
		syntaxErrors++;
	}
	error = messages[errorCategory] + message;
	errorQueue.push(error);
	totalErrors++;
}

void displayErrors()
{
	while (!errorQueue.empty()){
		printf("%s\n", errorQueue.front().c_str());
		errorQueue.pop();
	}
}
