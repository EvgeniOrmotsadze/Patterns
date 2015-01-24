package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public class AbstactSeason extends  AbstractFactory {
    @Override
    public Clothes getClose(String clothes) {
        return null;
    }

    @Override
    public Size getSize(String size) {
        return null;
    }

    @Override
    public Season getSeason(String season) {
       if(season.equals("Winter")){
           return new Winter();
       }else if(season.equals("Summer")){
           return  new Summer();
       }else if(season.equals("Spring")){
           return  new Spring();
       }else {
           return  null;
       }

    }
}
