package com.yb.bowling.frame;

import com.yb.bowling.exception.ParsingException;
import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.FrameFactory;
import com.yb.bowling.frame.FrameParser;
import com.yb.bowling.roll.Roll;
import com.yb.bowling.roll.StringRollParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *     FrameParser  Test
 *          1 method tested:
 *                   parse(List<Roll> rolls) : List<Frame>
 *
 * @author Youness Bougrine
 *
 */
public class FrameParserTest {

    List<Roll> rolls;
    StringRollParser rollParser;

    @Before
    public void setUp(){
        rollParser = new StringRollParser();
        rolls = null;
    }

    /**
     * CASE 1 : method parse(List<Roll>) : List<Frame>
     *         input :  11111111111111111111
     *      expected  number of created Frames equal to 10
     *                And for each Frame the number of knocked pins equal to 2
     */
    @Test
    public void CreateFramesFromAllOnesRollsExpectedTenFramesAndForEachNumberOfKnockedPinsEqualTwo(){
        String input = "11111111111111111111";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        FrameParser frameParser = new FrameParser();
        List<Frame> allFrames = frameParser.parse(rolls);
        assertEquals(allFrames.size(),10);
        for(Frame frame : allFrames){
            assertEquals(frame.numberOfKnockedPins(),2);
        }
    }

    /**
     * CASE 2 : method parse(List<Roll>) : List<Frame>
     *         input :  --------------------
     *      expected  number of created Frames equal to 10
     *                And for each Frame the number of knocked pins equal to 0
     */
    @Test
    public void canCreateFramesFromAllMissesRollsExpectedTenFramesAndForEachNumberOfKnockedPinsEqualToZero(){
        String input = "--------------------";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        FrameParser frameParser = new FrameParser();
        List<Frame> allFrames = frameParser.parse(rolls);
        assertEquals(allFrames.size(),10);
        for(Frame frame : allFrames){
            assertEquals(frame.numberOfKnockedPins(),0);
        }
    }

    /**
     * CASE 3 : method parse(List<Roll>) : List<Frame>
     *         input :  XXXXXXXXXXXX
     *      expected  number of created Frames equal to 11
     *                And for each Frame the number of knocked pins equal to 10
     */
    @Test
    public void CreateFramesFromAllStrikeExpectedTwelveFramesAndForEachNumberOfKnockedPinsEqualToTen(){
        String input = "XXXXXXXXXXXX";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        FrameParser frameParser = new FrameParser();
        List<Frame> allFrames = frameParser.parse(rolls);
        assertEquals(allFrames.size(),12);
        for(Frame frame : allFrames){
            assertEquals(frame.numberOfKnockedPins(),10);
        }
    }

    /**
     * CASE 4 : method parse(List<Roll>) : List<Frame>
     *         input :  1/1/1/1/1/1/1/1/1/1/2
     *      expected  number of created Frames equal to 11
     *                And for each Frame the number of knocked pins equal to 10
     *                And the last one equal to 2
     */
    @Test public void CreateFramesFromAllSpareAndLastTwoExpectedElevenFramesAndForEachNumberOfKnockedPinsEqualToTenAndLastEqualToTwo(){
        String input = "1/1/1/1/1/1/1/1/1/1/2";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        FrameParser frameParser = new FrameParser();
        List<Frame> allFrames = frameParser.parse(rolls);
        assertEquals(allFrames.size(),11);
        for(int i=0;i<allFrames.size()-1;i++)
            assertEquals(allFrames.get(i).numberOfKnockedPins(),10);
        assertEquals(allFrames.get(allFrames.size()-1).numberOfKnockedPins(),2);
    }

    /**
     * CASE 5 : method parse(List<Roll>) : List<Frame>
     *         input :  XXXXXXXXXXX2
     *      expected  number of created Frames equal to 12
     *                And for each Frame the number of knocked pins equal to 10
     *                And the last one equal to 2
     */
    @Test public void CreateFramesFromAllStrikeAndLastTwoExpectedTwelveFramesAndForEachNumberOfKnockedPinsEqualToTenAndLastEqualToTwo(){
        String input = "XXXXXXXXXXX2";
        try {
            rolls = rollParser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        FrameParser frameParser = new FrameParser();
        List<Frame> allFrames = frameParser.parse(rolls);
        assertEquals(allFrames.size(),12);
        for(int i=0;i<allFrames.size()-1;i++)
            assertEquals(allFrames.get(i).numberOfKnockedPins(),10);
        assertEquals(allFrames.get(allFrames.size()-1).numberOfKnockedPins(),2);
    }
}
