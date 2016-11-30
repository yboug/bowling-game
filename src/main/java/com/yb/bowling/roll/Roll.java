package com.yb.bowling.roll;

/**
 *    Bowling Roll  defined by number of knocked pins
 *
 * @author Youness Bougrine
 *
 */


public class Roll {

    private int numberOfKnockedPins;

    public Roll(int numberOfKnockedPins) {
        this.numberOfKnockedPins = numberOfKnockedPins;
    }

    public Roll(){
        this.numberOfKnockedPins = 0;
    }

    public int getNumberOfKnockedPins() {
        return numberOfKnockedPins;
    }
}
