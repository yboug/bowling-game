package com.yb.bowling.frame;

import com.yb.bowling.frame.Frame;
import com.yb.bowling.roll.Roll;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *     Frame Test
 *      method:
 *          numberOfPinsKnockedInFirstRoll
 *          numberOfKnockedPins
 *          isStrike
 *          isSpare
 *
 *    @author Youness Bougrine
 */

public class FrameTest {

    /**
     * CASE 1 : method numberOfPinsKnockedInFirstRoll : int
     *          Frame(Roll(1),Roll(1))
     *      expected  numberOfPinsKnockedInFirstRoll equal to one
     *                And number of knocked pins in the frame equal to Two
     *                And isSStrike return false
     *                And isSpare return false
     */
    @Test
    public void frameOfTwoRollsForEachOneNumberOfKnockedPinsOneEpectedOneFrameWithNumberOfPinsKnockedInFirstRollEqualToOne(){
        Frame frame = new Frame(new Roll(1),new Roll(1));
        assertEquals(frame.numberOfPinsKnockedInFirstRoll(),1);
        assertEquals(frame.numberOfKnockedPins(),2);
        assertEquals(frame.isStrike(),false);
        assertEquals(frame.isSpare(),false);

    }

}
