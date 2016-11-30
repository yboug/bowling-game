package com.yb.bowling.roll;

import com.yb.bowling.exception.ParsingException;

import java.text.ParseException;
import java.util.List;

/**
 *     Roll parser given an input object output a list of Roll
 *
 *              Design pattern Strategy
 *
 * @author Youness Bougrine
 *
 */

public interface RollParser {
    List<Roll> parse(Object rolls) throws ParsingException;
}
