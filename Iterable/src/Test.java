import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by evgeni on 11/28/2014.
 */
public class Test {

    public static void main(String [] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(12);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(8);

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(3);
        b.add(4);
        b.add(5);
      /*  b.add(7);
        b.add(2);
        b.add(1);
        b.add(6);*/

       /* Iterable<Integer> list = Iterables.chain(a, b);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /* Iterable<Integer> list = Iterables.take(a, 10);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.except(a, b);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.intersect(a, b);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.repeat(10, 1);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

     /*   Iterable<Integer> list = Iterables.distinct(a);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.range(4,19);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

       /* Iterable<Integer> list = Iterables.reverse(a);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        /* Iterable<Integer> list = Iterables.follow(a,9);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.except(a,b);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

      /*  Iterable<Integer> list = Iterables.union(a,b);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        Predicate<Integer> pr = new Predicate<Integer>() {
            Integer num = new Integer(9);
            @Override
            public <Integer> boolean check(Integer value) {
                if((java.lang.Integer) value < num) return true;
                return false;
            }
        };
     /*   Iterable<Integer> list = Iterables.takeWhile(a,pr);
        Iterator<Integer> it =  list.iterator();
        System.out.println(it.next());
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

       /* Iterable<Integer> list = Iterables.skipWhile(a,pr);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/

       // }

        Iterable<Integer> list = Iterables.filter(a,pr);
        Iterator<Integer> it =  list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
