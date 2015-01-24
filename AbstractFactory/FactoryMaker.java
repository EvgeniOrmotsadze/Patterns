package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public class FactoryMaker {
    public AbstractFactory getFact(String name){
        if(name.equals("Clothes")){
            return new AbsractClothes();
        } else if (name.equals("Size")){
            return  new AbstractSize();
        } else if(name.equals("Season")){
            return new AbstactSeason();
        } else{
            return null;
        }

    }
}
