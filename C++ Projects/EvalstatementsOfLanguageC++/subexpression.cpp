#include <iostream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "plus.h"
#include "minus.h"
#include "times.h"
#include "divide.h"
#include "equals.h"
#include "greaterThan.h"
#include "lessThan.h"
#include "and.h"
#include "or.h"
#include "not.h"
#include "ternaryOp.h"

SubExpression::SubExpression(Expression* left, Expression* right, Expression* third)
{
    this->left = left;
    this->right = right;
    this->third = third;
}

Expression* SubExpression::parse(istream& in)
{
    Expression* left;
    Expression* right;
    Expression* third;
    char operation, paren;

    left = Operand::parse(in);
    in >> operation;
    if (operation == '!') {
        in >> paren;
        return new Not(left);
    }
    else if (operation == ':') {
        right = Operand::parse(in);
        in >> operation;
        third = Operand::parse(in);
        in >> paren;
        return new TernaryOp(left, right, third);
    }
    right = Operand::parse(in);
    in >> paren;
    switch (operation)
    {
        case '+':
            return new Plus(left, right);
        case '-':
            return new Minus(left, right);
        case '*':
            return new Times(left, right);
        case '/':
            return new Divide(left, right);
        case '=':
            return new Equals(left, right);
        case '<':
            return new LessThan(left, right);
        case '>':
            return new GreaterThan(left, right);
        case '&':
            return new And(left, right);
        case '|':
            return new Or(left, right);
    }
    return 0;
}
