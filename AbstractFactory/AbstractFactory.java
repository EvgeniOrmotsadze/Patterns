package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public abstract class AbstractFactory {
    public abstract  Clothes getClose(String clothes);
    public abstract Size getSize(String size);
    public abstract Season getSeason(String season);
}
