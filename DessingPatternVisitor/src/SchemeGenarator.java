/**
 * Created by evgeni on 1/8/2015.
 */


public class SchemeGenarator extends Builder {

	@Override
	public Builder add(String a) {
		result = new StringBuilder("+" +result.toString()+ " " + a);
		return this;
	}

	@Override
	public Builder substact(String a) {
		result = new StringBuilder("-" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder devide(String a) {
		result = new StringBuilder("/" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder multifly(String a) {
		result = new StringBuilder("*" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder modulo(String a) {
		result = new StringBuilder("%" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder equal(String a) {
		result = new StringBuilder("eq?" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder not_equal(String a) {
		result = new StringBuilder("not eq?" +result.toString() + " " +a);
		return null;
	}

	@Override
	public Builder less_than(String a) {
		result = new StringBuilder("<" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder less_than_or_equal(String a) {
		result = new StringBuilder("<=" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder more_than(String a) {
		result = new StringBuilder(">" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder more_than_or_equal(String a) {
		result = new StringBuilder(">=" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder and(String a) {
		result = new StringBuilder("and" +result.toString() + " " +a);
		return this;
	}

	@Override
	public Builder or(String b) {
		result = new StringBuilder("||" +result.toString() + " " +b);
		return this;
	}

	@Override
	public Builder not() {
		result = new StringBuilder("not " + result.toString());
		return this;
	}

	@Override
	public Builder negate() {
		result = new StringBuilder("- " + result.toString());
		return this;
	}
}
