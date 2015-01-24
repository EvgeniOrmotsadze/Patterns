/**
 * Created by evgeni on 1/8/2015.
 */

public class JavaGenerator extends Builder {

    @Override
    public Builder add(String a) {
        result.append(" + " + a);
        return this;
    }

    @Override
    public Builder substact(String a) {
		result.append(" - " + a);
        return this;
    }

    @Override
    public Builder devide(String a) {
		result.append(" / " + a);
        return this;
    }

    @Override
    public Builder multifly(String a) {
		result.append(" * " + a);
        return this;
    }

    @Override
    public Builder modulo(String a) {
        result.append(" % " +a);
		return this;
    }

    @Override
    public Builder equal(String a) {
        result.append(" == " +a);
        return this;
    }

    @Override
    public Builder not_equal(String a) {
        result.append(" != " +a);
		return this;
    }

    @Override
    public Builder less_than(String a) {
		result.append(" < " +a);
        return this;
    }

    @Override
    public Builder less_than_or_equal(String a) {
        result.append(" <= " +a);
		return this;
    }

    @Override
    public Builder more_than(String a) {
        result.append(" > " +a);
		return this;
    }

    @Override
    public Builder more_than_or_equal(String a) {
        result.append(" >= " +a);
		return this;
    }

    @Override
    public Builder and(String a) {
        result.append(" && " +a);
		return this;
    }

    @Override
    public Builder or(String b) {
        result.append(" || " + b);
		return this;
    }

    @Override
    public Builder not() {
		result = new StringBuilder("!" + result.toString());
        return this;
    }

    @Override
    public Builder negate() {
		result = new StringBuilder("-(" + result.toString() +")");
        return this;
    }
}
