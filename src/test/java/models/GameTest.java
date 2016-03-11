package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jonathan on 3/5/2016.
 */
public class GameTest {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

}
