package models;

public class Dealer extends Player {
    public Dealer() {

    }

    // If dealer totalCard is 17 and above, then toHit not allowed
    public boolean allowHit() {
        if (sumOfCard >= 17) {
            return false;
        }
        else {
            return true;
        }
    }
}
