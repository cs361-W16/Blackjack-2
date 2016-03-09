package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */

public class Game {

    public boolean error;

    int pot = 0;

    Person player = new Person();
    Person dealer = new Person();

    public java.util.List<Card> deck = new ArrayList<>();



    public Game(){
    }


    //Deck Functions
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

    public void clearDeck(){
        deck.clear();

    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }
    //End of Deck Functions


    //Player Hand Functions
    // Remove the top card from cardList
    public Card pop(java.util.List<Card> cardList) {
        return cardList.remove(cardList.size()-1);
    }

    // Put one card into hand
    public void hit(Person person1) {
        person1.addHand(pop(deck));
    }

    public void Deal(){
        hit(player);
        hit(player);
        hit(dealer);
        hit(dealer);
    }

    public void clearHands(){
        player.clearHand();
        dealer.clearHand();
    }
    //End of Player Hand Functions

    //Turns
    public void Hold(){
       dealerAction();

        //SET ALL BUTTONS TO FALSE IF IMPLIMENTING HERE
    }
    //Sets player and dealer hands and creates a new deck
    public void newRound(){
        clearHands();
        clearDeck();
        buildDeck();
        shuffle();
        Deal();
    }

    public int endRound(){
        if (player.countCards() > 21) {
            System.out.println("Player Busted");
            return 0;
        }else if(player.countCards() > dealer.countCards()){
            System.out.println("Player Wins");
            return 1;
        }else if (player.countCards() == dealer.countCards()){
            System.out.println("Tie Game");
            return 2;
        }else{
            System.out.println("Dealer Wins");
            return 3;
        }
    }

    public int dealerAction(){
        while(dealer.countCards() < 17){
            hit(dealer);
            if(dealer.countCards() > 21){
                System.out.println("Dealer Busted");
                return 1;
            }
        }
        endRound();
        return 0;
    }
    //End of Turns

    //Money things
    public void beginingBalance(){
        player.addMoney(100);
    }

    public void Bet(){
        player.loseMoney(2);
        pot +=2;
    }

    public void winBet(){
        player.addMoney(pot);
        pot = 0;
    }

    public void doubleDown(){

    }

    //End of Money things
}
