package models;

import org.apache.commons.lang.ArrayUtils;

import com.fasterxml.jackson.annotation.JsonTypeInfo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Following AcesUp EN & SP format
// Taylor change UML diagram here

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")

public abstract class Person {

    public int money;

    public java.util.List<Card> Hand = new ArrayList<>();

    public Person() {
    }

    public int sumOfCard;

    public abstract boolean allowHit();


    // Reassign the value of each card to be suitable in Blackjack game
    public int setCardValue (Card C) {
        int cardVal = C.getValue();
        // if not-picture or not-aces card (2 - 10)
        if(cardVal >= 2 && cardVal <= 10)
            return cardVal;
            // if a picture card (J, Q, K)
        else if(cardVal >= 11 && cardVal <= 13)
            return 10;
            // if an aces card (A)
        else if(cardVal == 14)
            return 11;
        // if value of card less than 2 or more than 14
        return -1;
    }

    public int countCards(java.util.List<Card> Hand) {
        int count = 0;
        int numAces = 0;

        for (int i = 0; i < Hand.size(); ++i) {
            int val = setCardValue(Hand.get(i));
            if (val == 11)
                numAces++;
            count += val;
        }
        // Condition where ACE exist and sum of all cards greater than 21
        // Automatically reduces ACE from 11 to 1 value
        while (count > 21 && numAces > 0) {
            count -= 10;
            numAces--;
        }
        return count;

    }
}
