class TernaryOp : public SubExpression
{
public:
    TernaryOp(Expression* left, Expression* right, Expression* third) :
        SubExpression(left, right, third)
    {
    }
    int evaluate()
    {
        if (left->evaluate()) {
            return right->evaluate();
        }
        else {
            return third->evaluate();
        }
    }
};
