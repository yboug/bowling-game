package com.yb.bowling.frame;

import com.yb.bowling.roll.Roll;

/**
 *     Frame contains two Rolls the score for this frame is the sum of  each two Rolls knocked pins
 *
 * @author Youness Bougrine
 *
 */

public class Frame {
    private Roll firstRoll;
    private Roll secondRoll;

    public Frame(Roll firstRoll,Roll secondRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    /**
     *
     * @param firstRoll
     */
    public Frame(Roll firstRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = new Roll();
    }

    public int numberOfKnockedPins() {
        return firstRoll.getNumberOfKnockedPins() + secondRoll.getNumberOfKnockedPins();
    }

    public int numberOfPinsKnockedInFirstRoll() {
        return firstRoll.getNumberOfKnockedPins();
    }

    public boolean isStrike(){
        return false;
    }

    public boolean isSpare(){
        return false;
    }
}
