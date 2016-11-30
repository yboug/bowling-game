package com.yb.bowling.frame;

import com.yb.bowling.roll.Roll;

import java.util.List;

/**
 *     Frame Factory
 *
 * @author Youness Bougrine
 *
 */
public class FrameFactory {

    public Frame getFrame(List<Roll> rolls, int i) {
        Roll firstRoll = rolls.get(i);
        if(firstRoll.getNumberOfKnockedPins() == 10){
            return new Strike(rolls.get(i));
        }
        Roll secondRoll;
        if(i+1 < rolls.size()){
            secondRoll = rolls.get(i+1);
            if(firstRoll.getNumberOfKnockedPins() + secondRoll.getNumberOfKnockedPins() == 10){
                return new Spare(rolls.get(i),rolls.get(i+1));
            }
        }
        else{
            secondRoll = new Roll();
        }

        return new Frame(firstRoll,secondRoll);
    }
}
