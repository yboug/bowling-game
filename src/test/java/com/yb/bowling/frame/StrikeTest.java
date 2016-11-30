package com.yb.bowling.frame;

import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.Strike;
import com.yb.bowling.roll.Roll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *     Strike Test
 *      method:
 *          numberOfPinsKnockedInFirstRoll
 *          numberOfKnockedPins
 *          isStrike
 *          isSpare
 *
 *    @author Youness Bougrine
 */
public class StrikeTest {
    /**
     * CASE 1 : method numberOfPinsKnockedInFirstRoll : int
     *          Strike(Roll(10))
     *      expected  numberOfPinsKnockedInFirstRoll equal to 10
     */
    @Test
    public void frameOfTypeStrikeInputOneRollNumberOfKnockedPinsTenEpectedOneStrikeWithNumberOfPinsKnockedInFirstRollEqualToTenAndTenForTheFrame(){
        Frame frame = new Strike(new Roll(10));
        assertEquals(frame.numberOfPinsKnockedInFirstRoll(),10);
        assertEquals(frame.numberOfKnockedPins(),10);
    }

    /**
     * CASE 2 : method isStrike : boolean
     *          Strike(Roll(10))
     *      expected   isSStrike return true
     */
    @Test
    public void frameOfTypeStrikeInputOneRollNumberOfKnockedPinsTenEpectedIsStrikeToBeTrue(){
        Frame frame = new Strike(new Roll(10));
        assertEquals(frame.isStrike(),true);
    }

    /**
     * CASE 3 : method isSpare : boolean
     *          Strike(Roll(10))
     *      expected   isSpare return false
     */
    @Test
    public void frameOfTypeStrikeInputOneRollNumberOfKnockedPinsTenEpectedIsSpareToBeFalse(){
        Frame frame = new Strike(new Roll(10));
        assertEquals(frame.isSpare(),false);
    }
}
