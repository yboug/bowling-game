package com.yb.bowling.frame;

import com.yb.bowling.roll.Roll;

/**
 *     Frame of type Spare isSpare return true
 *
 * @author Youness Bougrine
 *
 */

public class Spare extends Frame{

    public Spare(Roll firstRoll, Roll secondRoll) {
        super(firstRoll, secondRoll);
    }

    public boolean isSpare(){
        return true;
    }
}
