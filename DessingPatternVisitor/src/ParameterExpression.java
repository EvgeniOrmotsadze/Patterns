/**
 * Created by evgeni on 1/5/2015.
 */
public class ParameterExpression extends Expression {
    private String paramter;
    private Object type;

    public ParameterExpression(Object type){
        this.type = type;
        this.paramter = type.getClass().getSimpleName();
    }

    public Class getType(){
        if(type instanceof Boolean) return Boolean.class;
        else if(type instanceof String) return String.class;
        else return Integer.class;
    }

    public String getTypeName(){
        return this.paramter;
    }


    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
