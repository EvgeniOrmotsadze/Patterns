/**
 * Created by evgeni on 1/8/2015.
 */
public abstract class Builder {

    protected StringBuilder result;

    public Builder initialValue(String initialValue) {
        result = new StringBuilder(initialValue);
        return this;
    }

    public abstract Builder add(String a);

    public abstract Builder substact(String a);

    public abstract Builder devide(String a);

    public abstract Builder multifly(String a);

    public abstract Builder modulo(String a);

    public abstract Builder equal(String a);

    public abstract Builder not_equal(String a);

    public abstract Builder less_than(String a);

    public abstract Builder less_than_or_equal(String a);

    public abstract Builder more_than(String a);

    public abstract Builder more_than_or_equal(String a);

    public abstract Builder and(String a);

    public abstract Builder or(String b);

    public abstract Builder not();

    public abstract Builder negate();

    public String build(){
        return wrapInBrackets(result.toString());
    }

    private String wrapInBrackets(String s) {
        return "(" + s + ")";
    }
}
