package models;

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
