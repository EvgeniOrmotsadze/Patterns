/**
 * Created by evgeni on 1/5/2015.
 */
public class BinaryExpression extends Expression {

    private Expression right;
    private Expression left;
    private String operation;

    public BinaryExpression(Expression right,Expression left,String operation){
        this.right = right;
        this.left = left;
        this.operation = operation;
    }

    public Expression getRight(){
        return this.right;
    }

    public Expression getLeft(){
        return this.left;
    }

    public String getOperation(){
        return this.operation;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
