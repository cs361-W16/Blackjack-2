package models;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Created by jonathan on 3/5/2016.
 */
public class Person {
    public java.util.List<Card> Hand = new ArrayList<>();
    public int wallet = 0;

    public void checkBust(int count){
        if (count > 21) {
            // busted
            // call new game
        }

    }

    // Assign the card into blackjack rank
    public int setCardValue (Card c) {
        int rank = c.getValue();
        if(rank >= 2 && rank <= 10)
            return rank; //2-10
        else if(rank >= 11 && rank <= 13)
            return 10; //J,Q,K
        else if(rank == 14)
            return 11; //A

        return -1; //error
    }

    // Count total cards in hand
    public int countCards() {
        int count = 0;
        int numAces = 0;

        for(int i = 0; i < Hand.size(); ++i){
            int val = setCardValue(Hand.get(i));
            if(val == 11)
                numAces++;
            count += val;
        }

        while(count > 21 && numAces > 0){
            count -= 10; //count-11+1 which turns Ace into a 1
            numAces--;
        }

        return count;

    }

    public void addHand(Card card){
        Hand.add(card);
    }

    public void clearHand(){
            Hand.clear();
    }

    public int getMoney(){
        return wallet;
    }

    public void addMoney(int money){
        wallet += money;
    }

    public void loseMoney(int money){
        wallet -= money;
    }
}
