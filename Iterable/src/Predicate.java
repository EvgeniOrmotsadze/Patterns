/**
 * Created by evgeni on 11/27/2014.
 */
public interface Predicate<T>{
    /**
     * კრიტერიუმი
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean check(T value);
}