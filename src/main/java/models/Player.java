package models;

/**
 * Created by cameron, jonathan on 3/6/2016.
 */
public class Player extends Person {

    public Player() {
        money = 100;
    }

    // Player first turn never exceed 21
    // Always allow toHit first time by initializing to True
    public boolean allowHit() {
        return true;
    }
}
