package com.yb.bowling;

import com.yb.bowling.calculator.Calculator;
import com.yb.bowling.exception.ParsingException;
import com.yb.bowling.roll.Roll;
import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.FrameParser;
import com.yb.bowling.roll.RollParser;

import java.util.ArrayList;
import java.util.List;

/**
 *     Bowling Game given a Roll parser and Frame parser  provide the score of game from a String input
 *
 * @author Youness Bougrine
 *
 */

public class BowlingGame {

    private final RollParser rollParser;
    private final FrameParser frameParser;

    public BowlingGame(RollParser rollParser, FrameParser frameParser) {
        this.rollParser = rollParser;
        this.frameParser = frameParser;
    }

    public int scoreOfGame(Object input){
        List<Roll> parsedRoll = null;
        try {
            parsedRoll = rollParser.parse(input);
        } catch (ParsingException e) {
            e.printStackTrace();
        }
        List<Frame> parsedFrame = frameParser.parse(parsedRoll);
        Calculator calc = new Calculator(parsedFrame);
        int score = calc.score();
        return score;
    }

}
