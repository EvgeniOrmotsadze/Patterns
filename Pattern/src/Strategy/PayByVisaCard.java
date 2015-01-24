package Strategy;

import CreditCard.Card;

/**
 * Created by evgeni on 10/7/2014.
 */
public class PayByVisaCard extends Payment{
    @Override
    public void pay(Card card){
        System.out.println("Pay user " + card.getOwner() + " amount - " + card.getAmount() + " using by VisaCard. \n" );
    }
}
