package com.yb.bowling.roll;

import com.yb.bowling.exception.ParsingException;
import com.yb.bowling.roll.Roll;
import com.yb.bowling.roll.RollParser;
import com.yb.bowling.roll.StringRollParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *     StringRollParserTest
 *          3 method tested:
 *              knockedPinsOf
 *              createRoll
 *              parse
 *
 * @author Youness Bougrine
 *
 */
public class StringRollParserTest {

    StringRollParser parser;

    @Before
    public void setUp(){
        parser = new StringRollParser();
    }

    /**
     * CASE 1 : method knockedPinsof(indice,inputString):int
     *      inputString : 1
     *      indice : 0
     *      expected  number of knocked pins  equal to 1
     */
    @Test
    public void InputOneExpectedNumberOfKnokedPinsEqualToOne(){
        String input = "1";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,1);
    }

    /**
     * CASE 2 : method knockedPinsof(indice,inputString):int
     *      inputString : -
     *      indice : 0
     *      expected  number of knocked pins  equal to 0
     */
    @Test
    public void InputMisseExpectedNumberOfKnokedPinsEqualToZero(){
        String input = "-";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,0);
    }

    /**
     * CASE 3 : method knockedPinsof(indice,inputString):int
     *      inputString : X
     *      indice : 0
     *      expected  number of knocked pins  equal to 10
     */
    @Test
    public void InputStrikeExpectedNumberOfKnokedPinsEqualToTen(){
        String input = "X";
        int result = parser.knockedPinsOf(0,input);
        assertEquals(result,10);
    }

    /**
     * CASE 4 : method knockedPinsof(indice,inputString):int
     *      inputString : 1/
     *      indice : 0 and 1
     *      expected  number of knocked pins  equal to 1 for the firstRooll and equal to 9 for the secondRoll
     */
    @Test
    public void InputSpareExpectedNumberOfKnokedPinsEqualToTen(){
        String input = "1/";
        int resultOfFirstRoll = parser.knockedPinsOf(0,input);
        assertEquals(resultOfFirstRoll,1);
        int resultOfSecondRoll = parser.knockedPinsOf(1,input);
        assertEquals(resultOfSecondRoll,9);
    }

    /**
     * CASE 5 : method createRoll(String stringRolls, int indice):Roll
     *      inputString : 1
     *      indice : 0
     *      expected  number of knocked pins of the created Roll equal to 1
     */
    @Test
    public void InputOneExpectedCreateOneRollWithNumberOfKnokedPinsEqualToOne(){
        String input = "1";
        Roll roll = parser.createRoll(input,0);
        assertEquals(roll.getNumberOfKnockedPins(),1);
    }

    /**
     * CASE 6 : method createRoll(String stringRolls, int indice):Roll
     *      inputString : X
     *      indice : 0
     *      expected  number of knocked pins of the created Roll equal to 10
     */
    @Test
    public void InputStrikeExpectedCreateOneRollWithNumberOfKnokedPinsEqualToTen(){
        String input = "X";
        Roll roll = parser.createRoll(input,0);
        assertEquals(roll.getNumberOfKnockedPins(),10);
    }

    /**
     * CASE 7 : method createRoll(String stringRolls, int indice):Roll
     *      inputString : 1/
     *      indice : 0 and 1
     *      expected  number of knocked pins of the first created Roll equal to 1 and 9 for the second Roll
     */
    @Test
    public void InputSpareExpectedCreateOneRollWithNumberOfKnokedPinsEqualTo9(){
        String input = "1/";
        Roll firstRoll = parser.createRoll(input,0);
        assertEquals(firstRoll.getNumberOfKnockedPins(),1);
        Roll secondRoll = parser.createRoll(input,1);
        assertEquals(secondRoll.getNumberOfKnockedPins(),9);
    }



    /**
     * CASE 8 : method  parse(Object stringRolls):List<Roll>
     *     input : 11111111111111111111 (20 one)
     *     expected 20 Rolls for each one the number of knocked pins is equal to 1
     */
    @Test
    public void ParseAllOnesInputExpected_20_RolesWithValue_1(){
        String input = "11111111111111111111";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),1);
    }

    /**
     *  CASE 9 : method  parse(Object stringRolls):List<Roll>
     *     input : -------------------- (20 misses)
     *     expected 20 Rolls for each one the number of knocked pins is equal to 0
     */
    @Test
    public void ParseAllMissesRollsExpected_20_RolesWithValue_0(){
        String input = "--------------------";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),0);
    }

    /**
     *  CASE 10 : method  parse(Object stringRolls):List<Roll>
     *     input : XXXXXXXXXX (12 strikes)
     *     expected 12 Rolls for each one the number of knocked pins is equal to 10
     */
    @Test
    public void ParseAllStrikesExpected_10_RolesWithValue_10(){
        String input = "XXXXXXXXXXXX";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),12);
        for(Roll r : rolls)
            assertEquals(r.getNumberOfKnockedPins(),10);
    }

    /**
     * CASE 11 : method  parse(Object stringRolls):List<Roll>
     *     input : 1/1/1/1/1/1/1/1/1/1/ (one and spare)  expected 20 Rolls for each one the number of first Roll knocked pins is equal to 1
     *     and the number of second Roll knocked pins is equal to 9
     */
    @Test
    public void ParseSpareExpected_20_RolesWithValue_1_forFirstsAnd_9_forTheSeconds(){
        String input = "1/1/1/1/1/1/1/1/1/1/";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
        } catch (ParsingException e) {
            Assert.fail();
        }
        assertEquals(rolls.size(),20);
        for(int i=0;i < rolls.size();i=i+2){
            assertEquals(rolls.get(i).getNumberOfKnockedPins(),1);
            assertEquals(rolls.get(i+1).getNumberOfKnockedPins(),9);
        }
    }

    /**
     * CASE 12 : method  parse(Object stringRolls):List<Roll>
     *     Fail input Last roll missed : 1/1/1/1/1/1/1/1/1/1
     *     Expected ParsingException
     */
    @Test
    public void ParseFailInputLastRollMissedeExpected_Exception(){
        String input = "1/1/1/1/1/1/1/1/1/1";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }

    /**
     * CASE 12 : Exception Test
     *     Fail input 11 Strike : XXXXXXXXXXX
     *     Expected ParsingException
     */
    @Test
    public void ParseFailInputElevenStrikeExpected_Exception(){
        String input = "XXXXXXXXXXX";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }

    /**
     * CASE 13 : Exception Test
     *     Fail input 11 Strike and two last Spare: XXXXXXXXXXX//
     *     Expected ParsingException
     */
    @Test
    public void ParseFailInputElevenStrikeAndTwoLastSpareExpected_Exception(){
        String input = "XXXXXXXXXXX//";
        List<Roll> rolls = null;
        try {
            rolls = parser.parse(input);
            Assert.fail();
        } catch (ParsingException e) {
            assertEquals(e.getMessage(),"Input length not valid");
        }
    }
}
