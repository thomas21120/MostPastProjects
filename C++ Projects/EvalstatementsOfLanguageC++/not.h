class Not : public SubExpression
{
public:
    Not(Expression* left) :
        SubExpression(left, nullptr)
    {
    }
    int evaluate()
    {
        return !left->evaluate();                    
    }
};

