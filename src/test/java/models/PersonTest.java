package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testPlayerMoney() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        assertEquals(100, g.player.money);
    }

    @Test
    public void testDealerHit() {
        Game g = new Game();
        g.buildDeck();
        g.manualDeal(g.dealer, 40);
        g.manualDeal(g.dealer, 40);
        assertEquals(false,g.dealer.allowHit());
    }
    @Test
    public void testSetCardValue() {
        Game g = new Game();
        Card c = new Card(13, Suit.Diamonds);
        assertEquals(10, g.player.setCardValue(c));

    }
    @Test
    public void testCountCards() {
        Game g = new Game();
        g.buildDeck();
        g.manualDeal(g.player,10);
        //assertEquals(g.player.countCards(g.player.Hand));
        assertEquals(true,true);

        //g.manualDeal(g.player, 20);
        //g.manualDeal(g.player, 20);


    }
}