// Credits to group 17, group 13,  group 21, Michael Hilton, StackOverflow, and TA's
// What should I write next??

package models;

/**
 * Created by michaelhilton on 1/25/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */

public class Game {

    public boolean error;

<<<<<<< HEAD
    int pot = 0;

    Person player = new Person();
    Person dealer = new Person();

    public java.util.List<Card> deck = new ArrayList<>();
    /////////////////////////////////////////////////
    // This here line is just for testing, remove it when we don't need to test the front end anymore.
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();
    /////////////////////////////////////////////////
=======
    public Person player = new Player();
    public Person dealer = new Dealer();

    public java.util.List<Card> deck = new ArrayList<>();

    public int ante;
    public int currentWinner; // 1 means USER, 2 means DEALER, 3 means TIE

    ////////////// TESTING ///////////////////

    //This here line is just for testing, remove it when we don't need to test the front end anymore.
    //public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    //////////////////////////////////////////
>>>>>>> edit backend


    //public java.util.List<Card>>cols= new ArrayList<>();

    public Game(){
        ////////////// TESTING ///////////////////
        // Also for testing. Remove them when the time comes.
        //cols.add(new ArrayList<Card>());
        //cols.add(new ArrayList<Card>());
        /////////////////////////////////////////
    }
<<<<<<< HEAD
    //Deck Functions
=======

    public void newRound() {
        ante = 2;
        player.money = player.money - ante;
        player.Hand.clear();
        player.sumOfCard = 0;
        dealer.Hand.clear();
        dealer.sumOfCard = 0;
        currentWinner = 0; // 0 means NOBODY.......NOBODY BUT YOU!~~
    }

>>>>>>> edit backend
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

<<<<<<< HEAD
    public void clearDeck(){
        deck.clear();

=======
    public void deal (Person player) {
        player.Hand.add(deck.get(deck.size() - 1));

        player.sumOfCard = player.sumOfCard + player.countCards(player.Hand);

        //int tempCard = (deck.get(deck.size() - 1)).getValue();
        //newCardValue = player.setCardValue(tempCard);

        // Add the "CORRECT" value into empty variable.
        //player.totalCard = player.totalCard+ (deck.get(deck.size() - 1)).getValue();
        //player.totalCard = player.totalCard + newCardValue;

        deck.remove(deck.size()-1);
    }

    // For testing purpose only
    public void manualDeal (Person player, int x) {
        player.Hand.add(deck.get(x));
        player.sumOfCard = player.sumOfCard + deck.get(x).getValue();
        deck.remove(deck.size()-1);
>>>>>>> edit backend
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }
    //End of Deck Functions


<<<<<<< HEAD
    //Player Hand Functions
    // Remove the top card from cardList
=======
    public void endRound() {
        if (player.sumOfCard > 21) {
            currentWinner = 2; // means dealer win
        }
        if (dealer.sumOfCard > 21) {
            currentWinner = 1; // means player win
            player.money = player.money + (2 * ante);
        }
        if (player.sumOfCard > dealer.sumOfCard) {
            currentWinner = 1; // means player win
            player.money = player.money + (2 * ante);
        }
        else if (player.sumOfCard < dealer.sumOfCard) {
            currentWinner = 2; // means dealer win
        }
        else {
            currentWinner = 3;
            player.money = player.money + ante;
        }
    }

    public void doubleDown() {

    }

     /* public Money Ante(Money playerMoney) {
        playerMoney.balance -= 2;
        playerMoney.pot += 2;
        return playerMoney;
    }*/

/*    // Remove the top card from cardList
>>>>>>> edit backend
    public Card pop(java.util.List<Card> cardList) {
        return cardList.remove(cardList.size()-1);
    }

    // Put one card into hand
<<<<<<< HEAD
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    NOTE: The following function is for testing only. Somebody comment this out or delete it when we don't need it anymore.
    public void dealTwo() {
=======
    public void hit(java.util.List<Card> cardList) {
        cardList.add(pop(deck));
    }*/


//////////////////////////////// TESTING /////////////////////////////////////////////////////////////////
//    NOTE: The following function is for testing only. Somebody comment this out or delete
//    it when we don't need it anymore.

//  THIS LOOKS GOOD TAYLOR, I WILL BORROW YOUR IDEA FOR OUR DEAL
 /*   public void dealTwo() {
>>>>>>> edit backend
        for(int i = 0; i < 2; i++){
            //cols.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }*/
    //}
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    //End of Money things
}
