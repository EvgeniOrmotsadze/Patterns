/**
 * Created by evgeni on 11/27/2014.
 */
public interface Mapper<TFrom,TTo> {
    /**
     * ასახვა
     * @param from
     * @return
     */
    public TTo map(TFrom from);
}