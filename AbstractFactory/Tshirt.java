package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public class Tshirt implements  Clothes {
    @Override
    public void wear() {
        System.out.println("Wearing Tshirt");
    }
}
