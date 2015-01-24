/**
 * Created by evgeni on 11/25/2014.
 */
import java.lang.*;
import java.util.*;

public class Iterables  {

    /**
     * უზრუნველყოფს a და b მიმდევრობების გადაბმას, შედეგად უნდა მიიღოთ ახალი მიმდევრობა,
     * რომელიც იწყება a და სრულდება b-ს მიმდევრობის ელემენტებით
     * @param a მიმდევრობა
     * @param b მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable <T>  chain(Iterable<T> a, Iterable<T> b){

        final Iterator<T> alt = a.iterator();
        final Iterator<T> blt = b.iterator();
        return  new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    @Override
                    public boolean hasNext() {
                        return  alt.hasNext() || blt.hasNext();
                    }

                    @Override
                    public T next() {
                        if(alt.hasNext()) return alt.next();
                        if(blt.hasNext()) return blt.next();
                        throw new NoSuchElementException();
                    }
                };
            };
        };
    }

    /**
     * დააბრუნებს მიმდევრობის პირველ n ელემენტს
     * @param iterable მიმდევრობა
     * @param n ელემენტების რაოდენობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */

    public static <T> Iterable<T> take(Iterable <T> iterable,int n){
        final Iterator<T> it = iterable.iterator();
        final int number = n;
        return new Iterable<T>(){
              @Override
              public Iterator<T> iterator() {
                  return new Iterator<T>() {
                      int counter = 0;
                      @Override
                      public boolean hasNext() {
                          return  it.hasNext() && counter < number;
                      }
                      @Override
                      public T next() {
                          if(!it.hasNext()) throw new NoSuchElementException();
                          counter++;
                          return it.next();
                      }
                  };
              };
          };
    }

    /**
     * დააბრუნებს მიმდევრობის ყველა ელემენტებს გარდა პირველი n ელემენტისა
     * @param iterable მიმდევრობა
     * @param n გამოსატოვებელი ელემენტების რაოდენობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */

    public static <T> Iterable<T> skip (Iterable<T> iterable, int n){
        final Iterator<T> it = iterable.iterator();
        final int number = n;
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int counter = 0;
                    {
                        while (counter <= number && it.hasNext()) {
                            if (!it.hasNext()) throw new NoSuchElementException();
                             it.next();
                             counter++;
                        }
                    }
                    @Override
                    public boolean hasNext() {
                        return it.hasNext() && counter > number  ;
                    }
                    @Override
                    public T next() {
                        if(!it.hasNext()) throw new NoSuchElementException();
                        return it.next();
                    }
                };
            }
        };
    }



    /**
     * დააბრუნებს მიმდევრობის საწყის ელემენტებს, მანამ სანამ სრულდება predicate პირობა
     * @param iterable მიმდევრობა
     * @param predicate პირობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მირებული მიმდევრობა
     */
    public static <T> Iterable<T> takeWhile(Iterable<T> iterable,Predicate<T> predicate) {
        final Iterator<T> it = iterable.iterator();
        final Predicate<T> pred = predicate;

        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private T val;
                    private boolean isOver;
                    @Override
                    public boolean hasNext() {
                        if (isOver) return false;
                        if (val != null) return true;
                        if (!it.hasNext()) return false;
                        val = it.next();
                        if (!pred.check(val)) {
                            isOver = true;
                            return false;
                        } else {
                            return true;
                        }
                    }
                    @Override
                    public T next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        T result = val;
                        val = null;
                        hasNext();
                        return result;
                    }
                };
            }
        };
    }

    /**
     გამოტოვებს მიმდევრობის საწყის ელემენტებს, მანამ სანამ სრულდება predicate პირობა და დააბრუნებს დარჩენილ ელემენტებს
    * @param iterable მიმდევრობა
    * @param predicate პირობა
    * @param <T> მიმდევრობის ელემენტების ტიპი
    * @return მიღებული მიმდევრობა
    */

    public static <T> Iterable<T> skipWhile(Iterable<T> iterable,Predicate<T> predicate) {
        final  Iterator<T> it = iterable.iterator();
        final Predicate<T> pred = predicate;
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private T val;
                    {
                        T tmp = null;
                        if (!it.hasNext()) val = null;
                        while (it.hasNext() && pred.check( tmp = it.next())) {
                            val = tmp;
                        }
                        if(it.hasNext()) {
                            val = tmp;
                         }
                    }
                    @Override
                    public boolean hasNext() {
                        return val != null;
                    }

                    @Override
                    public T next() {
                        if (val == null) throw new NoSuchElementException();
                        T res = val;
                        if (it.hasNext()) val = it.next(); else val = null;
                        return res;
                    }
                };
            }
        };
    }

    /**
     * დააბრუნებს მიმდევრობის იმ ელემენტებს, რომლებიც აკმაყოფილებს predicate-ს პირობას
     * @param iterable მიმდევრობა
     * @param predicate პირობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> filter(Iterable<T> iterable, Predicate<T> predicate) {
        final Iterator<T> it = iterable.iterator();
        final Predicate<T> pred = predicate;
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {

                    List<T> list = new ArrayList<T>();
                    {
                        while(it.hasNext()){
                            T value = it.next();
                            if(pred.check(value)){
                                list.add(value);
                            }
                        }
                    }
                    @Override
                    public boolean hasNext() {
                        return list.size() > 0;
                    }
                    @Override
                    public T next() {
                        if(list.size() == 0) throw new NoSuchElementException();
                        T ret = list.get(0);
                        list.remove(0);
                        return ret;
                    }
                };
            }
        };
    }

    /**
     * უზრუნველყოფს მოცემული მიმდევრობის ელემენტების ასახავს (mapper-ს გამოყენებით) და მიღებული შედეგების მიმდევრობის დაბრუნებას
     * @param iterable მიმდევრობა
     * @param mapper ასახვა
     * @param <TFrom> საწყისი მიმდევრობის ელემენტების ტიპი
     * @param <TTo> მიღებული მიმდევრობის ელემენტის ტიპი
     * @return მიმრებული მიმდევრობა
     */
    public static <TFrom, TTo> Iterable<TTo> map(Iterable<TFrom> iterable,  Mapper<TFrom, TTo> mapper) {
        final Iterator<TFrom> it = iterable.iterator();
        final  Mapper<TFrom, TTo> mapp = mapper;
        return new Iterable<TTo>() {
            @Override
            public Iterator<TTo> iterator() {
                return new Iterator<TTo>() {

                    @Override
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override
                    public TTo next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        return mapp.map(it.next());
                    }

                };
            }
        };
    }


    /**
     * უზრუნველყოფს მიმდევრობის ელემენტების შებრუნებული რიგით დაბრუნებას
     * @param iterable მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> reverse(Iterable<T> iterable){
        final Iterator<T> it = iterable.iterator();
        final Stack<T> stack = new Stack<T>();
        while(it.hasNext()){
            stack.add(it.next());
        }
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    @Override
                    public boolean hasNext() {
                        return stack.size() > 0;
                    }

                    @Override
                    public T next() {
                        return stack.pop();
                    }
                };
            }
        };
    }


    /**
     * დააბრუნებს მიმდევრობის განსხვავებულ ელემენტებს
     * @param iterable მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> distinct(Iterable<T> iterable){
        final Iterator<T> it = iterable.iterator();
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {

                    private List<T> distinct = new ArrayList<T>();
                    private Iterator<T> result;
                    {
                        while (it.hasNext()) {
                            T t = it.next();
                            if (distinct.contains(t)) continue;
                            distinct.add(t);
                        }
                        result = distinct.iterator();
                    }
                    @Override
                    public boolean hasNext() {
                        return result.hasNext();
                    }

                    @Override
                    public T next() {
                        return result.next();
                    }

                    @Override
                    public void remove() {
                        result.remove();
                    }
                };
            }
        };
    }

    /**
     * დააბრუნებს ორი მიმდევრობის ელემენტებისგან შედგენილი სიმრავლეების გაერთიანებას მიმდევრობის სახით
     * @param a მიმდევრობა
     * @param b მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> union(Iterable<T> a,Iterable<T> b){
        final Iterator<T> aIt = a.iterator();
        final Iterator<T> bIt = b.iterator();

        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private Iterator<T> result;
                    {
                        List<T> list = new ArrayList<T>();

                        while (aIt.hasNext()) {
                            T t  = aIt.next();
                            if (list.contains(t)) continue;
                            list.add(t);
                        }

                        while (bIt.hasNext()) {
                            T t  = bIt.next();
                            if (list.contains(t)) continue;
                            list.add(t);
                        }

                        result = list.iterator();
                    }
                    @Override
                    public boolean hasNext() {
                        return result.hasNext();
                    }

                    @Override
                    public T next() {
                        return result.next();
                    }

                    @Override
                    public void remove() {
                        result.remove();
                    }
                };
            }

        };
    }

    /**
     * დააბრუნებს ორი მიმდევრობის ელემენებისგან შედგენილი სიმრავლეების თანაკვეთას მიმდევრობის სახით
     * @param a მიმდევრობა
     * @param b მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> intersect( Iterable<T> a,  Iterable<T> b){
        final Iterator<T> it = a.iterator();
        final  Iterator<T> bIt = b.iterator();
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private List<T> list = new ArrayList<T>();
                    T val;
                    {
                        while (it.hasNext()) {
                            list.add(it.next());
                        }
                    }
                    @Override
                    public boolean hasNext() {

                        if (val != null) return true;
                        while (bIt.hasNext()) {
                            val = bIt.next();
                            if (list.contains(val)) return true;
                        }
                        return false;
                    }

                    @Override
                    public T next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        T tmp = val;
                        val = null;
                        hasNext();
                        return tmp;
                    }
                };
            }
        };
    }

    /**
     * დააბრუნებს a მიმდევრობის იმ ელემენტებისგან შედგენილ მიმდევრობას, რომლებიც არ გვხვდება b-ში
     * @param a მიმდევრობა
     * @param b მიმდევრობა
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> except( Iterable<T> a,  Iterable<T> b){
        final Iterator<T> aIt = a.iterator();
        final  Iterator<T> bIt = b.iterator();
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private List<T> list = new ArrayList<T>();
                    private T val;
                    {
                        while (bIt.hasNext()) {
                            list.add(bIt.next());
                        }
                    }
                    @Override
                    public boolean hasNext() {
                        if (val != null) return true;
                        while (aIt.hasNext()) {
                            val = aIt.next();
                            if (!list.contains(val)) return true;
                        }
                        return false;
                    }

                    @Override
                    public T next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        T tmp = val;
                        val = null;
                      //  hasNext();
                        return tmp;
                    }
                };
            }
        };
    }


    /**
     * დააბრუნებს მთელი რიცხვების ზრდად (ბიჯი 1) მიმდევრობას რომელიც დაიწყება start-ით და დასრულდება end -ით.
     * იმ შემთხვევაში თუ end < start-ზე უნდა დაბრუნდეს კლებადი მიმდევრობა (ბიჯი -1)
     * @param /start საწყისი ელემენტი
     * @param /end ბოლო ელემენტი
     * @return მიღებული მიმდევრობა
     */
    public static Iterable<Integer> range( int starts,  int ends){
        final int start = starts;
        final int end = ends;
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    Integer val = start;
                    @Override
                    public boolean hasNext() {
                        return (start <= end ? val <= end : val >= start);
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        return (start <= end ? val++ : val--);
                    }
                };
            }
        };
    }

    /**
     * დააბრუნებს მიმდევრობას რომელიც მიიღება value-ს n-ჯერ გამეორებით
     * @param value
     * @param /count
     * @param <T>
     * @return
     */
    public static <T> Iterable<T> repeat(T value, int n){
        final T val = value;
        final int number = n;
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    Stack<T> list = new Stack<T>();
                    private  int counter = 0;
                    {
                        while (counter != number){
                            list.add(val);
                            counter++;
                        }
                    }

                    @Override
                    public boolean hasNext() {
                        return list.size() > 0;
                    }

                    @Override
                    public T next() {
                        return list.pop();
                    }
                };
            }
        };
    }

    /**
     * დააბრუნებს მიმდევრობას რომლიც იწყება iterable მიმდევრობის ელემენტებით და ბოლოვდება value-თი
     * @param iterable მიმდევრობა
     * @param value შედეგის ბოლო ელემენტი
     * @param <T> მიმდევრობის ელემენტების ტიპი
     * @return მიღებული მიმდევრობა
     */
    public static <T> Iterable<T> follow(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        final T values = value;
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int count = 0;
                    @Override
                    public boolean hasNext() {
                        if(!it.hasNext()){
                            count++;
                        }
                        if(it.hasNext()){
                            return true;
                        }
                        if(!it.hasNext()&& count == 1) return true;
                        return false;
                    }

                    @Override
                    public T next() {
                        if(it.hasNext()) return it.next();
                        else if(!it.hasNext() && count == 1) return values;
                        else throw  new NoSuchElementException();
                    }
                };
            }
        };
    }




}
