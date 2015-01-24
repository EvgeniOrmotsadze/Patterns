package AbstractFactory;

/**
 * Created by evgeni on 10/7/2014.
 */
public  class AbstractSize extends AbstractFactory {

    @Override
    public Clothes getClose(String clothes) {
        return null;
    }

    @Override
    public Size getSize(String size) {
        if(size.equals("S")){
            return new S();
        }else if(size.equals("M")){
            return new M();
        }else if(size.equals("L")){
            return new L();
        }else{
            return null;
        }
    }

    @Override
    public Season getSeason(String season) {
        return null;
    }
}
