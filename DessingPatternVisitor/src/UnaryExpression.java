/**
 * Created by evgeni on 1/5/2015.
 */
public class UnaryExpression extends Expression {

    private Expression expression;
    private String operations;

    public UnaryExpression(Expression expression,String operations){

        this.expression = expression;
        this.operations = operations;
    }

    public Expression getExpression(){
        return  this.expression;
    }

    public String getOperations(){
        return this.operations;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
