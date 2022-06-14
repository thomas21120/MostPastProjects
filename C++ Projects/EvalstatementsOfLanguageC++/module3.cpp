#include <iostream>
#include <string>
#include <vector>
#include <fstream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

SymbolTable symbolTable;

void parseAssignments(istream& in);

int main()
{
    Expression* expression;
    char paren, comma, choice;

    do {
        cout << "For console input enter A, for file input enter B, or X to exit: \n";
        cout << "When using logical operators, value = 1 for true or value = 0 for false: \n";
    cin >> choice;
    choice = toupper(choice);
        if (choice == 'A')
        {
            cout << "Enter expression: \n";
            cin >> paren;
            expression = SubExpression::parse(cin);
            cin >> comma;
            parseAssignments(cin);
            cout << "Value = " << expression->evaluate() << endl;
        }
        else if (choice == 'B') {         
            string fileName;
            ifstream fileIn;
            cout << "Enter filename of the input file: \n";
            cin >> fileName;
            fileIn.open(fileName);
            if (!fileIn.is_open()) {
                cout << "Can't open file: " << fileName << "." << endl;
                continue;
            }
            while (fileIn >> paren) {
              
                expression = SubExpression::parse(fileIn);
                fileIn >> comma;

                parseAssignments(fileIn);
                cout << "Value = " << expression->evaluate() << endl;
            }
            fileIn.close();
        }else if(choice != 'X') {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Please enter a valid selection\n";
        }
    } while (choice != 'X');
}

void parseAssignments(istream& in)
{
    char assignop, delimiter;
    string variable;
    double value;
    do
    {
        variable = parseName(in);
        in >> ws >> assignop >> value >> delimiter;
        symbolTable.insert(variable, value);
    }
    while (delimiter == ',');
}
