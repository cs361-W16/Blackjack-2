package models;

/**
 * Created by jonathan on 3/5/2016.
 */
public class Money {

    public int  pot;
    public int  balance;

    // Adding function
    public int Increment(int count, int howMuch ) {
        count = count + howMuch;
        return count;
    }

    // Subtracting function
    public int Decrement(int count, int howMuch) {
        count = count - howMuch;
        return count;
    }

}
