import CreditCard.Card;
import CreditCard.MasterCard;
import CreditCard.VisaCard;
import Strategy.PayByMasterCard;
import Strategy.PayByVisaCard;
import Strategy.Payment;

/**
 * Created by evgeni on 10/7/2014.
 */
public class Test {
    public static void main(String[] args){
        Card card = new MasterCard();
        card.setAmount("200");
        card.setOwner("Evg00");

        Card card1 = new VisaCard();
        card1.setAmount("300");
        card1.setOwner("lasha");

        Payment p1 = new PayByMasterCard();
        p1.pay(card);

        Payment p2 = new PayByVisaCard();
        p2.pay(card1);


    }
}
