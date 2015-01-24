package Strategy;

import CreditCard.Card;

/**
 * Created by evgeni on 10/7/2014.
 */
public class PayByMasterCard extends  Payment {
    @Override
    public void pay(Card card){
        System.out.print("Pay user " + card.getOwner() + " amount - " + card.getAmount() + " using by MasterCard. \n" );
    }
}
