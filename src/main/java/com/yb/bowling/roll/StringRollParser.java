package com.yb.bowling.roll;

import com.yb.bowling.exception.ParsingException;

import java.util.ArrayList;
import java.util.List;

/**
 *     StringRollParser provide a parser method given a string input  output a list of Roll
 *
 * @author Youness Bougrine
 *
 */

public class StringRollParser implements RollParser {


    public List<Roll> parse(Object stringRolls) throws ParsingException {
        String inputToParse = (String) stringRolls;
        boolean valid = validateInput(inputToParse);
        if(valid == false)
            throw new ParsingException("Input length not valid");
        ArrayList<Roll> rolls = new ArrayList<Roll>();
        for (int i = 0; i < inputToParse.length(); i++) {
            rolls.add(createRoll(inputToParse, i));
        }
        return rolls;
    }

    //Simple validation
    private boolean validateInput(String inputToParse){
        int length = inputToParse.length();
        String temp = inputToParse;
        int numberOfStrike = length - temp.replace("X", "").length();
        int numberOfChar = length + numberOfStrike;
        if(inputToParse.charAt(length - 3) == 'X'){
            if(inputToParse.charAt(length - 2) == 'X' && inputToParse.charAt(length - 1) == 'X'){
                return (numberOfChar == 24);
            }
            else if(inputToParse.charAt(length - 2) == 'X' || inputToParse.charAt(length - 1) == 'X'){
                return (numberOfChar == 23);
            }
            else {
                return (numberOfChar == 22);
            }
        }else if(inputToParse.charAt(length - 2) == '/'){
            return (numberOfChar == 21);
        }else {
            return (numberOfChar == 20);
        }
    }

    public Roll createRoll(String stringRolls, int i) {
        int numberOfKnockedPins = knockedPinsOf(i, stringRolls);
        return new Roll(numberOfKnockedPins);
    }

    public int knockedPinsOf(int numberOfRoll, String stringRolls) {
        char charToParse = stringRolls.charAt(numberOfRoll);
        if (charToParse == '-') {
            return 0;
        }
        if (charToParse == '/') {
            return 10 - knockedPinsOf(numberOfRoll - 1, stringRolls);
        }
        if (charToParse == 'X') {
            return 10;
        }
        return Character.getNumericValue(charToParse);
    }
}
