package com.yb.bowling.calculator;

import com.yb.bowling.frame.Frame;

import java.util.List;

/**
 *     Calculate the score from a list of Frames
 *
 * @author Youness Bougrine
 *
 */

public class Calculator{

    public final int Nbr_Max = 10;
    public List<Frame> frames;
    public int result = 0;

    public Calculator(List<Frame> frames){
        this.frames = frames;
    }

    /**
     *  Calculate the score of 10 Frames
     *  for each frame
     *      check if strike
     *          result is 10 plus the sum of the next two Rolls knocked pins
     *      check if spare
     *          result is 10 plus the next Roll knocked pins
     *      else
     *          result of then current frame
     *
     * @return score of a bowling game
     *
     * @author Youness Bougrine
     */

    public int score() {
        if(frames != null){
            for(int i=0;i < Nbr_Max ; i++){
                if(frames.get(i).isStrike()){
                    result +=  frames.get(i).numberOfKnockedPins() + bonusStrike(i);
                }
                else if(frames.get(i).isSpare()){
                    result += frames.get(i).numberOfKnockedPins() + bonusSpare(i);
                }
                else {
                    result += frames.get(i).numberOfKnockedPins();
                }
            }
            return result;
        }
        else
                return 0;
    }

    private int bonusSpare(int i) {
        return getNextFrame(i).numberOfPinsKnockedInFirstRoll();
    }

    private int bonusStrike(int i) {
            int bonus = 0;
            if(getNextFrame(i).isStrike())
                bonus = getNextFrame(i).numberOfKnockedPins() + getNextFrame(i+1).numberOfPinsKnockedInFirstRoll();
            else
                bonus = getNextFrame(i).numberOfKnockedPins();
        return bonus;
    }

    private Frame getNextFrame(int i){
        return frames.get(i+1);
    }
}
