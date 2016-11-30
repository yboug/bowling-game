package com.yb.bowling;

import com.yb.bowling.frame.FrameParser;
import com.yb.bowling.roll.StringRollParser;

import java.util.Scanner;

/**
 *     Bowling Game Main
 *
 * @author Youness Bougrine
 *
 */
public class BowlingLauncher {

    public static void main (String[] args){

        StringRollParser rollParser = new StringRollParser();
        FrameParser frameParser = new FrameParser();
        BowlingGame game = new BowlingGame(rollParser,frameParser);
        String str = "";
        Scanner sc = new Scanner(System.in);

            System.out.println("Veuillez saisir Bowling input : pour quiter tapper q ");
            str = sc.nextLine();
            System.out.println(game.scoreOfGame(str));


    }
}
