package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public class AbsractClothes extends  AbstractFactory {

    @Override
    public Clothes getClose(String clothes) {
        if (clothes.equals("Tshirt")) {
            return new Tshirt();

        } else if (clothes.equals("Trousers")) {
            return new Trousers();

        } else {
            return null;
        }
    }

    @Override
    public Size getSize(String size) {
        return null;
    }

    @Override
    public Season getSeason(String season) {
        return null;
    }
}
