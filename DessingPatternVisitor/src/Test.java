/**
 * Created by evgeni on 1/5/2015.
 */
public class Test {
    public static void main(String[] args) {

       /* BinaryExpression bn = new BinaryExpression(new BinaryExpression(new ConstantExpression(16),new ConstantExpression(15),"SUBTRACT"), new ConstantExpression(15),"ADD");
        BinaryExpression bn1 = new BinaryExpression(new ConstantExpression(32),new ConstantExpression(23 < 11),"NOT_EQUAL");
        ExpressionTypeResolver ex = new ExpressionTypeResolver();
        ex.visit(bn);
        System.out.println(ex.getValue());
        ex.visit(bn1);
        System.out.println(ex.getValue());*/
        BinaryExpression binary = new BinaryExpression(new BinaryExpression(new ConstantExpression(12),new ConstantExpression(10),"ADD"),new ConstantExpression(50),"ADD");
		CodeGenator gn = new CodeGenator(new JavaGenerator());
		CodeGenator c = new CodeGenator(new SchemeGenarator());
		c.visit(binary);
		System.out.println(c.getValue());



    }
}
