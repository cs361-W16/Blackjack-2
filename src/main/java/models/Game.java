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

    //public java.util.List<Card>>cols= new ArrayList<>();

    public Game(){
    }

    public Money Ante(Money playerMoney) {
        playerMoney.balance -= 2;
        playerMoney.pot += 2;
        return playerMoney;
    }

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

    
}
