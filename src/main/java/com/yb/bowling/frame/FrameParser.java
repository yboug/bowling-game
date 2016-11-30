package com.yb.bowling.frame;

import com.yb.bowling.roll.Roll;

import java.util.ArrayList;
import java.util.List;

/**
 *     Frame parser given an input of Rolls output a list of Frames
 *
 * @author Youness Bougrine
 *
 */

public class FrameParser {

    public List<Frame> parse(List<Roll> rolls) {
        int nbrOfRoll=0;
        ArrayList<Frame> frames = new ArrayList<Frame>();
        FrameFactory factory = new FrameFactory();
        while (nbrOfRoll < rolls.size()){
            Frame currentFrame =factory.getFrame(rolls,nbrOfRoll);
            if(currentFrame.isStrike()){
                nbrOfRoll++;
            }
            else{
                nbrOfRoll = nbrOfRoll + 2;
            }
            frames.add(currentFrame);
        }

        return frames;
    }

}
