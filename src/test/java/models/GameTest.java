package models;

import static org.junit.Assert.*;
import org.junit.Test;


public class GameTest {
    @Test
    public void testGame(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }
    @Test
    public void testGameDeal() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.deal(g.player);
        g.deal(g.dealer);
        g.deal(g.player);
        g.deal(g.dealer);
        assertEquals(2,g.dealer.Hand.size());
        assertEquals(2,g.player.Hand.size());
    }

    @Test
    public void testEndRound(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.deal(g.player);
        g.deal(g.dealer);
        g.deal(g.player);
        g.deal(g.dealer);
        g.deal(g.player);
        g.deal(g.player);
        g.deal(g.player);
        g.endRound();
        //assertEquals(2, g.player.sumOfCard);
        assertEquals(2, g.currentWinner);
    }

    @Test
    public void testDoubleDown() {
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.newRound();
        g.doubleDown();
        assertEquals(96,g.player.money);
    }
}

