/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author Kayla
 */
public class GiveTreasureCardView extends View{

//    void displayGiveTreasureCardView() {
//        boolean endOfView = false;
//        // test code
//        boolean player1 = false;
//        boolean player2 = false;
//        int totalEarth;
//        int totalWind;
//        int totalFire;
//        int totalWater;
//        int p1Earth;
//        int p2Earth;
//        int p1Wind;
//        int p2Wind;
//        int p1Fire;
//        int p2Fire;
//        int p1Water;
//        int p2Water;
//
//        // set player:
//        int player = (int) (Math.random() * 2);
//        if (player == 1) {
//            player1 = true;
//        } else {
//            player2 = true;
//        }
//        // make the cards:
//
//        do {
//            p1Earth = (int) Math.round(Math.random() * 5);
//            p2Earth = (int) Math.round(Math.random() * 5);
//            totalEarth = p1Earth + p2Earth;
//        } while (totalEarth > 5);
//        do {
//            p1Wind = (int) Math.round(Math.random() * 5);
//            p2Wind = (int) Math.round(Math.random() * 5);
//            totalWind = p1Wind + p2Wind;
//        } while (totalWind > 5);
//        do {
//            p1Fire = (int) Math.round(Math.random() * 5);
//            p2Fire = (int) Math.round(Math.random() * 5);
//            totalFire = p1Fire + p2Fire;
//        } while (totalFire > 5);
//        do {
//            p1Water = (int) Math.round(Math.random() * 5);
//            p2Water = (int) Math.round(Math.random() * 5);
//            totalWater = p1Water + p2Water;
//        } while (totalWater > 5);
//        // end test code
//        do {
//            String[] inputs = getInputs(player1, player2, totalEarth, totalWind, totalFire, totalWater, p1Earth, p2Earth, p1Wind, p2Wind, p1Fire, p2Fire, p1Water, p2Water);
//
//            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
//                return;
//            }
//            endOfView = doAction(inputs)
//            //endOfView = doAction(inputs, player1, player2, totalEarth, totalWind, totalFire, totalWater, p1Earth, p2Earth, p1Wind, p2Wind, p1Fire, p2Fire, p1Water, p2Water);
//
//        } while (endOfView != true);
//    }

    @Override
    public String[] getInputs() {
        //(boolean player1, boolean player2, int totalEarth, int totalWind, int totalFire, int totalWater, int p1Earth, int p2Earth, int p1Wind, int p2Wind, int p1Fire, int p2Fire, int p1Water, int p2Water) {
        // test code

        // end test code
//        String[] inputs = new String[1];
//
//        boolean valid = false;
//        while (valid == false) {
//            //CREATED SCANNER  
//            Scanner inFile;
//            inFile = new Scanner(System.in);
//            if (player1 == true) {
//                System.out.println("Player 1");
//                System.out.println("Which card(s) would you like to give?\n"
//                        + "E - Earth Stone (" + p1Earth + ")\n"
//                        + "S - Statue of the Wind (" + p1Wind + ")\n"
//                        + "C - Crystal of Fire (" + p1Fire + ")\n"
//                        + "O - Ocean's Chalice (" + p1Water + ")\n");
//                //System.out.println("  Earth: " + p2Earth + "  Wind: " + p2Wind + "  Fire: " + p2Fire + "  Water: " + p2Water);
//            } else {
//                System.out.println("Player 2");
//                System.out.println("Which card(s) would you like to give?\n"
//                        + "E - Earth Stone (" + p2Earth + ")\n"
//                        + "S - Statue of the Wind (" + p2Wind + ")\n"
//                        + "C - Crystal of Fire (" + p2Fire + ")\n"
//                        + "O - Ocean's Chalice (" + p2Water + ")\n");
//                //System.out.println("  Earth: " + p1Earth + "  Wind: " + p1Wind + "  Fire: " + p1Fire + "  Water: " + p1Water);
//            }
//            String value = inFile.nextLine().trim().toUpperCase();
//
//            if (value.length() < 1 || value.length() > 1) {
//                System.out.println("Error: Please re-enter valid option: ");
//                continue;
//            }
//            inputs[0] = value;
//            valid = true;
//        }
//        return inputs;
        String[] inputs = new String[1];
//      inputs[0] = "textInput";

        //DISPLAYS BANNER PAGE
        System.out.println("***************************************************************************");
        System.out.println("*  You are stuck on an island and the only way off is to collect all      *\n"
                + "*  the treasure and fly away.  But it’s not as easy as it sounds.  As     *\n"
                + "*  you are collecting the treasure, the island is being flooded!  You     *\n"
                + "*  need to hurry! Collect all the treasure as fast as you can and leave   *\n"
                + "*  before you become stuck, with no escape.                               *");
        System.out.println("***************************************************************************");

        inputs[0] = this.getInput("What is your name?");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        //(String[] inputs, boolean player1, boolean player2, int totalEarth, int totalWind, int totalFire, int totalWater, int p1Earth, int p2Earth, int p1Wind, int p2Wind, int p1Fire, int p2Fire, int p1Water, int p2Water) {
//        switch (inputs[0]) {
//            case "E":
//                if (player2 == true) {
//                    if (p2Earth == 0) {
//                        System.out.println("You do not have any Earth Stone Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                if (player1 == true) {
//                    if (p1Earth == 0) {
//                        System.out.println("You do not have any Earth Stone Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                System.out.println("give Earth Stone");
//                break;
//            case "S":
//                if (player2 == true) {
//                    if (p2Wind == 0) {
//                        System.out.println("You do not have any Statue of the Wind Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                if (player1 == true) {
//                    if (p1Wind == 0) {
//                        System.out.println("You do not have any Statue of the Wind Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                System.out.println("give Statue of the Wind");
//                break;
//            case "C":
//                if (player2 == true) {
//                    if (p2Fire == 0) {
//                        System.out.println("You do not have any Crystal of Fire Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                if (player1 == true) {
//                    if (p1Fire == 0) {
//                        System.out.println("You do not have any Crystal of Fire Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                System.out.println("give Crystal of Fire");
//                break;
//            case "O":
//                if (player2 == true) {
//                    if (p2Water == 0) {
//                        System.out.println("You do not have any Ocean's Chalice Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                if (player1 == true) {
//                    if (p1Water == 0) {
//                        System.out.println("You do not have any Ocean's Chalice Cards. Please choose a different card.");
//                        return false;
//                    }
//                }
//                System.out.println("give Ocean's Chalice");
//                break;
//            default:
//                return false;
//        }
        System.out.println("*** doAction() called ***");
        return true;
    }

}
