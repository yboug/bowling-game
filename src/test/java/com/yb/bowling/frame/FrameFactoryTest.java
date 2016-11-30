package com.yb.bowling.frame;

import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.FrameFactory;
import com.yb.bowling.roll.Roll;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *     FrameFactory
 *          1 method tested:
 *                   getFrame(List<Roll> rolls, int i) : Frame
 *
 * @author Youness Bougrine
 *
 */
public class FrameFactoryTest {

    FrameFactory factory;

    @Before
    public void setUp(){
        factory = new FrameFactory();
    }

    /**
     * CASE 1 : method getFrame(List<Roll> rolls, int indice): Frame
     *      rolls : List of two Rolls for each one number of knocked pins equal two 1
     *      indice : 0
     *      expected  one regular Frame with 2 knocked Pins
     */
    @Test
    public void givenTwoRollOfOneKnockedPinsEachExpectedOneFrameWithTwoRollsAndNumberOfKnockedPinsEqualTwo(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(1));
        rolls.add(new Roll(1));
        Frame frame = factory.getFrame(rolls,0);
        assertEquals(frame.isSpare(),false);
        assertEquals(frame.isStrike(),false);
        assertEquals(frame.numberOfKnockedPins(),2);

    }

    /**
     * CASE 2 : method getFrame(List<Roll> rolls, int indice): Frame
     *      rolls : List of one Roll, Strike
     *      indice : 0
     *      expected  a Frame of type Strike and number of knocked pins equal to 10
     */
    @Test
    public void givenOneRollOfTenKnockedPinsExpectedOneFrameWithTwoRollsAndNumberOfKnockedPinsEqualToTen(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(10));
        Frame frame = factory.getFrame(rolls,0);
        assertEquals(frame.isStrike(),true);
        assertEquals(frame.numberOfKnockedPins(),10);

    }

    /**
     * CASE 3 : method getFrame(List<Roll> rolls, int indice): Frame
     *      rolls : List of two Roll, first one 1 knocked Pinns and second Spare
     *      indice : 0
     *      expected  a Frame of type Spare and number of knocked pins equal to 10
     */
    @Test
    public void givenTwoRollsOfOneAndSpareExpectedOneFrameWithTwoRollsAndNumberOfKnockedPinsEqualToTen(){
        List<Roll> rolls = new ArrayList<Roll>();
        rolls.add(new Roll(1));
        rolls.add(new Roll(9));
        Frame frame = factory.getFrame(rolls,0);
        assertEquals(frame.isSpare(),true);
        assertEquals(frame.numberOfKnockedPins(),10);
    }
}
