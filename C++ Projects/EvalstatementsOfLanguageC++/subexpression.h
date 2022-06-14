class SubExpression: public Expression
{
public:
    SubExpression(Expression* left, Expression* right, Expression* third = nullptr);
    static Expression* parse(istream& in);
protected:
    Expression* left;
    Expression* right;
    Expression* third;
};
