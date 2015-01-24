import java.util.Iterator;

/**
 * Created by evgeni on 11/28/2014.
 */
public class FibonacciGenerator implements Iterable {

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private  int a = 0;
            private  int b = 1;
            private  int c = 1;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Object next() {
                a = b;
                b = c;
                c = a + b;
                return a;
            }
        };
    }
}
