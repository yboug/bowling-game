package com.yb.bowling.frame;

import com.yb.bowling.roll.Roll;

/**
 *     Frame of type Strike isStrike return true
 *
 * @author Youness Bougrine
 *
 */

public class Strike extends Frame {

    public Strike(Roll firstRoll) {
        super(firstRoll);
    }

    public boolean isStrike(){
        return true;
    }
}
