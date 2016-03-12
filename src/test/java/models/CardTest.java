package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

        @Test
        public void testGetSuit(){
            Card c = new Card(5,Suit.Clubs);
            assertEquals(Suit.Clubs,c.getSuit());
        }

        @Test
        public void testToString(){
            Card c = new Card(5,Suit.Clubs);
            assertEquals("5Clubs",c.toString());
        }

        @Test
        public void testGetValue(){
            Card c = new Card(5,Suit.Diamonds);
            assertEquals(5,c.getValue());

            //Check the value conversion in Person Test Class
        }

}

// NOTES: All unit tests passing