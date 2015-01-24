/**
 * Created by evgeni on 1/5/2015.
 */
public class ExpressionTypeResolver implements ExpressionVisitor{

    private static String Booleans = "Boolean";
    private static String Integers = "Integer";
    private static String Strings = "String";

    private String expName;
    private Object result;



    public String getType(){
        return this.expName;
    }

    public Object getValue(){
        return  this.result;
    }

    @Override
    public void visit(ConstantExpression exp) {
        expName = exp.getTypeName();
        result = exp.getValue();
    }

    @Override
    public void visit(ParameterExpression exp) {
       expName = exp.getTypeName();
       result = exp;

    }

    @Override
    public void visit(UnaryExpression exp) {
        exp.getExpression().accept(this);
        Object express = this.result;
        String expName = this.expName;

        if(exp.getOperations().equals("NOT")){
            if(expName.equals(Booleans)){
                this.result = !(Boolean)express;
            }else{
                this.result = null;
            }
        }else if(exp.getOperations().equals("NEGATE")){
            if(expName.equals(Integers)){
                this.result = -(Integer)express;
            }else{
                this.result = null;
            }
        }else{
            throw new UnsupportedOperationException("Invalid logical operation");
        }


    }

    @Override
    public void visit(BinaryExpression exp) {
        exp.getLeft().accept(this);
        Object left = this.result;
        String leftName = this.expName;
        exp.getRight().accept(this);
        Object right = this.result;
        String rightName = this.expName;
        if(exp.getOperation().equals("ADD")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right +(Integer)left ;
            }else if(leftName.equals(Strings) && rightName.equals(Strings)){
                this.result = (String)right+ left;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("SUBTRACT")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result =(Integer)right- (Integer)left;
            }else{
                this.result = null;
            }
        } else if(exp.getOperation().equals("MULTIPLY")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right * (Integer)left;
            }else{
                this.result = null;
            }
        } else if(exp.getOperation().equals("DIVIDE")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result =  (Integer)right /(Integer)left ;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("MODULO")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right % (Integer)left;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("EQUAL")){
            if(leftName.equals(rightName)) {
                this.result = left.equals(right);
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("NOT_EQUAL")){
            if(leftName.equals(rightName)) {
                this.result = !left.equals(right);
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("LESS_THAN")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
               this.result = (Integer)right < (Integer)left;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("LESS_THAN_OR_EQUAL")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right <= (Integer)left ;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("GREATER_THAN")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right > (Integer)left;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("GREATER_THAN_OR_EQUAL")){
            if(leftName.equals(Integers) && rightName.equals(Integers)){
                this.result = (Integer)right >= (Integer)left;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("AND")){
            if(leftName == Booleans && rightName == Booleans){
                this.result = (Boolean)left && (Boolean)right;
            }else{
                this.result = null;
            }
        }else if(exp.getOperation().equals("OR")){
            if(leftName.equals(Booleans) && rightName.equals(Booleans)){
                this.result = (Boolean)right || (Boolean)left ;
            }else{
                this.result = null;
            }
        }else{
            throw new UnsupportedOperationException("Invalid  operation");
        }
    }




}
