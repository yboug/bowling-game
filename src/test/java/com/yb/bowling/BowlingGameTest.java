package com.yb.bowling;

import com.yb.bowling.BowlingGame;
import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.FrameParser;
import com.yb.bowling.roll.Roll;
import com.yb.bowling.roll.RollParser;
import com.yb.bowling.roll.StringRollParser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *     Bowling Game Test
 *
 * @author Youness Bougrine
 *
 */

public class BowlingGameTest {

    RollParser rollParser;
    FrameParser frameParser;
    BowlingGame game;

    @Before
    public void setUp(){
        rollParser = new StringRollParser();
        frameParser = new FrameParser();
        game = new BowlingGame(rollParser,frameParser);
    }
    /**
     * CASE 1
     *     input : XXXXXXXXXXXX (12 strike)  expected score equal to 300
     */

    @Test
    public void allStrikesExpected_300(){
        String input = "XXXXXXXXXXXX";
        assertEquals(game.scoreOfGame(input),300);
    }

    /**
     * CASE 2
     *     input : 1/1/1/1/1/1/1/1/1/1/2 (11 spare and last 2)  expected score equal to 111
     */
    @Test
    public void allSpareAndLast_2_Expected_111(){
        String input = "1/1/1/1/1/1/1/1/1/1/2";
        assertEquals(game.scoreOfGame(input),111);
    }

    /**
     * CASE 3
     *     input : 11111111111111111111 (20 one)  expected score equal to 20
     */
    @Test
    public void allOnesExpected_20(){
        String input = "11111111111111111111";
        assertEquals(game.scoreOfGame(input),20);
    }

    /**
     * CASE 4
     *     input : 9-9-9-9-9-9-9-9-9-9- (9 for first miss second)  expected score equal to 90
     */
    @Test
    public void NineAndMissExpected_90(){
        String input = "9-9-9-9-9-9-9-9-9-9-";
        assertEquals(game.scoreOfGame(input),90);
    }

    /**
     * CASE 5
     *     input : 5/5/5/5/5/5/5/5/5/5/5 (5 for first spare second and last 5)  expected score equal to 150
     */
    @Test
    public void FiveAndSpareWithFinalFiveExpected_150(){
        String input = "5/5/5/5/5/5/5/5/5/5/5";
        assertEquals(game.scoreOfGame(input),150);
    }
}
