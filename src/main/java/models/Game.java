package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */

public class Game {

    public boolean error;

    Person player = new Person();
    Person dealer = new Person();

    public java.util.List<Card> deck = new ArrayList<>();

    /////////////////////////////////////////////////
    // This here line is just for testing, remove it when we don't need to test the front end anymore.
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    /////////////////////////////////////////////////


    //public java.util.List<Card>>cols= new ArrayList<>();

    public Game(){
        //////////////////////////////////////////////////
        // Also for testing. Remove them when the time comes.
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        ///////////////////////////////////////////////////


    }

    public Money Ante(Money playerMoney) {
        playerMoney.balance -= 2;
        playerMoney.pot += 2;
        return playerMoney;
    }

    // NOTE: Why is this parameter here? What is it for?
    public void buildDeck(char answer) {

        // For normal version, we have: 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K, A
        // Total: 52
            // i < 15 means until 14 (each suit 14 cards)
        for (int i = 2; i < 15; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    // Remove the top card from cardList
    public Card pop(java.util.List<Card> cardList) {
        return cardList.remove(cardList.size()-1);
    }

    // Put one card into hand
    public void hit(java.util.List<Card> cardList) {
        cardList.add(pop(deck));
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    NOTE: The following function is for testing only. Somebody comment this out or delete it when we don't need it anymore.
    public void dealTwo() {
        for(int i = 0; i < 2; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
