package CreditCard;

/**
 * Created by evgeni on 10/7/2014.
 */
public class Card {
    String owner;
    String type;
    String amount;

    public String getOwner(){
        return this.owner;
    }

    public String getType(){
        return this.type;
    }

    public String getAmount(){
        return this.amount;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

}
