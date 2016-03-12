// Credits to group 17, group 13,  group 21, Michael Hilton, StackOverflow, and TA's
// What should I write next??

package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    //public boolean error;

    public Person player = new Player();
    public Person dealer = new Dealer();

    public java.util.List<Card> deck = new ArrayList<>();
    public int ante;
    public int currentWinner; // 1 means USER, 2 means DEALER, 3 means TIE
    private boolean gameOn;

    public Game(){
        gameOn = false;
        //////////////////////////////////////////////////
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        ///////////////////////////////////////////////////
    }
    /////////////////////////////////////////////////
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void dealTwo() {
        for(int i = 0; i < 2; i++){
            cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean gameInit() {
        return gameOn;
    }

    public void newRound() {
        ante = 2;
        player.money = player.money - ante;
        player.Hand.clear();
        player.sumOfCard = 0;
        dealer.Hand.clear();
        dealer.sumOfCard = 0;
        currentWinner = 0; // 0 means NOBODY.......NOBODY BUT YOU!~~

        gameOn = true;
    }
    public void buildDeck() {
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

    public void deal(Person player) {
        player.Hand.add(deck.get(deck.size() - 1));


        player.sumOfCard = player.countCards(player.Hand);

        //int tempCard = (deck.get(deck.size() - 1)).getValue();
        //newCardValue = player.setCardValue(tempCard);

        // Add the "CORRECT" value into empty variable.
        //player.totalCard = player.totalCard+ (deck.get(deck.size() - 1)).getValue();
        //player.totalCard = player.totalCard + newCardValue;

        deck.remove(deck.size() - 1);
    }

    // For testing purpose only
    public void manualDeal(Person player, int x) {
        player.Hand.add(deck.get(x));
        player.sumOfCard = player.sumOfCard + deck.get(x).getValue();
        deck.remove(deck.size() - 1);
    }


    public void endRound() {
        if (player.sumOfCard > 21) {
            currentWinner = 2; // means dealer win
        }
        else if (dealer.sumOfCard > 21) {
            currentWinner = 1; // means player win
            player.money = player.money + (2 * ante);
        }
        else if (player.sumOfCard > dealer.sumOfCard) {
            currentWinner = 1; // means player win
            player.money = player.money + (2 * ante);
        } else if (player.sumOfCard < dealer.sumOfCard) {
            currentWinner = 2; // means dealer win
        } else {
            currentWinner = 3;
            player.money = player.money + ante;
        }
    }

    public void doubleDown(){
        if(ante<4) {
            player.money -= ante;
            ante += ante;
        }
    }
}
