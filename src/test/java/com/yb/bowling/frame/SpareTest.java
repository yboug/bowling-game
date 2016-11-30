package com.yb.bowling.frame;

import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.Spare;
import com.yb.bowling.roll.Roll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *     Spare Test
 *      method:
 *          numberOfPinsKnockedInFirstRoll
 *          numberOfKnockedPins
 *          isSpare
 *          isStrike
 *
 *    @author Youness Bougrine
 */
public class SpareTest {
    /**
     * CASE 1 : method numberOfPinsKnockedInFirstRoll : int
     *          Spare(Roll(1),Roll(9))
     *      expected  numberOfPinsKnockedInFirstRoll equal to 10
     */
    @Test
    public void frameOfTypeSpareInputTwoRollNumberOfKnockedPinsOneAndNineEpectedOneSpareWithNumberOfPinsKnockedInFirstRollEqualToOneAndTenForTheFrame(){
        Frame frame = new Spare(new Roll(1),new Roll(9));
        assertEquals(frame.numberOfPinsKnockedInFirstRoll(),1);
        assertEquals(frame.numberOfKnockedPins(),10);
    }

    /**
     * CASE 2 : method isSpare : boolean
     *          Spare(Roll(1),Roll(9))
     *      expected   isSpare return true
     */
    @Test
    public void frameOfTypeSpareInputTwoRollNumberOfKnockedPinsOneAndNineEpectedIsSpareToBeTrue(){
        Frame frame = new Spare(new Roll(1),new Roll(9));
        assertEquals(frame.isSpare(),true);
    }

    /**
     * CASE 3 : method isSpare : boolean
     *          Spare(Roll(1),Roll(9))
     *      expected   isStrike return false
     */
    @Test
    public void frameOfTypeSpareInputOneRollNumberOfKnockedPinsTenEpectedIsSpareToBeFalse(){
        Frame frame = new Spare(new Roll(1),new Roll(9));
        assertEquals(frame.isStrike(),false);
    }
}
