/**
 * Created by evgeni on 1/5/2015.
 */
public interface  ExpressionVisitor {

    public void visit(ConstantExpression exp);

    public void visit(ParameterExpression exp);

    public void visit(UnaryExpression exp);

    public void visit(BinaryExpression exp);


}
