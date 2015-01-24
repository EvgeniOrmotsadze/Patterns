/**
 * Created by evgeni on 1/5/2015.
 */
public class ConstantExpression extends Expression {
    private Object type;

    public ConstantExpression(Object type){
        this.type = type;
    }

    public Object getValue(){
        return this.type;
    }

    public String getTypeName(){
        if(type instanceof Boolean) return Boolean.class.getSimpleName();
        else if(type instanceof String) return String.class.getSimpleName();
        else return Integer.class.getSimpleName();
    }



    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
