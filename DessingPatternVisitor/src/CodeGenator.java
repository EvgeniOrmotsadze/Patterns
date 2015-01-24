/**
 * Created by evgeni on 1/8/2015.
 * aq shemowmebebs agar vuketb an erti gza iyo rom typeresolvVisitor  damematebia da tu misi getValue null ar iqneboda ise damebechda :)
 */
public class CodeGenator implements ExpressionVisitor{

    private Builder bulder;

	private String result;
    public  CodeGenator(Builder concrateBulder){
        this.bulder = concrateBulder;
    }

	public Object getValue(){
		return  this.result;
	}


	@Override
	public void visit(ConstantExpression exp) {
		result = exp.getValue().toString();
	}

	@Override
	public void visit(ParameterExpression exp) {
		result = exp.getType().toString();

	}

	@Override
	public void visit(UnaryExpression exp) {
		exp.getExpression().accept(this);
		String express = this.result;

		if(exp.getOperations().equals("NOT")){
			this.result = bulder.initialValue(express).not().build();
		}else if(exp.getOperations().equals("NEGATE")){
			this.result = bulder.initialValue(express).negate().build();
		}else{
			throw new UnsupportedOperationException("Invalid logical operation");
		}
	}

	@Override
	public void visit(BinaryExpression exp) {
		exp.getLeft().accept(this);
		String left = this.result;

		exp.getRight().accept(this);
		String right = this.result;

		if(exp.getOperation().equals("ADD")){
			this.result = bulder.initialValue(left).add(right).build();

		}else if(exp.getOperation().equals("SUBTRACT")){
			this.result = bulder.initialValue(left).substact(right).build();
		} else if(exp.getOperation().equals("MULTIPLY")){
			this.result = bulder.initialValue(left).multifly(right).build();
		} else if(exp.getOperation().equals("DIVIDE")){
			this.result = bulder.initialValue(left).devide(right).build();
		}else if(exp.getOperation().equals("MODULO")){
			this.result = bulder.initialValue(left).modulo(right).build();
		}else if(exp.getOperation().equals("EQUAL")){
			this.result = bulder.initialValue(left).equal(right).build();
		}else if(exp.getOperation().equals("NOT_EQUAL")){
			this.result = bulder.initialValue(left).not_equal(right).build();
		}else if(exp.getOperation().equals("LESS_THAN")){
			this.result = bulder.initialValue(left).less_than(right).build();
		}else if(exp.getOperation().equals("LESS_THAN_OR_EQUAL")){
			this.result = bulder.initialValue(left).less_than_or_equal(right).build();
		}else if(exp.getOperation().equals("GREATER_THAN")){
			this.result = bulder.initialValue(left).more_than(right).build();
		}else if(exp.getOperation().equals("GREATER_THAN_OR_EQUAL")){
			this.result = bulder.initialValue(left).more_than_or_equal(right).build();
		}else if(exp.getOperation().equals("AND")){
			this.result = bulder.initialValue(left).and(right).build();
		}else if(exp.getOperation().equals("OR")){
			this.result = bulder.initialValue(left).or(right).build();
		}else{
			throw new UnsupportedOperationException("Invalid  operation");
		}
	}
}
