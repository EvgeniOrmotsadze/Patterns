import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by evgeni on 11/28/2014.
 */
public class Fibonacci{
    public static void main(String[] args){
        FibonacciGenerator fb = new FibonacciGenerator();
        Iterator<Integer> fibonacci = fb.iterator();
       // FibonacciLimit10(fibonacci);
        FibonacciFrom15to10(fibonacci);

    }
    private static void FibonacciLimit10(Iterator<Integer> fibonacci){

        for(int i = 0 ; i < 10; i++){
            System.out.println(fibonacci.next());
        }
    }

    private static void FibonacciFrom15to10(Iterator<Integer> fibonacci) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= 15; i++){
            int value = fibonacci.next();
            list.add(value);
        }

        Iterable<Integer> it = Iterables.skip(list, 8);
        Iterator<Integer> skip = it.iterator();
        ArrayList<Integer> reverse = new ArrayList<Integer>();
        while(skip.hasNext()) reverse.add(skip.next());
        Iterable<Integer> its = Iterables.reverse(reverse);
        Iterator<Integer> rev = its.iterator();
        while(rev.hasNext()) System.out.println(rev.next());
    }
}
