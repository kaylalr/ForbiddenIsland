/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author mcwis
 */
public class HelpMenuView extends View{
    
    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("Help Menu\n"
                + "W - How to Win\n"
                + "M - How to Move\n"
                + "S - Special Action Cards\n"
                + "A - Special Abilities\n"
                + "T - Treasure Cards\n"
                + "F - Flooded Tiles\n"
                + "C - Capture Treasure\n"
                + "Y - What to do on Your Turn\n"
                + "I - View All Instructions\n"
                + "Q - Quit\n");

        inputs[0] = this.getInput("Please choose a help menu item: ");
        return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
                System.out.println("Error: Please re-enter value: ");
                return false;
            }
        switch (inputs[0]) {
            case "W":
                howToWin();
                break;
            case "M":
                howToMove();
                break;
            case "S":
                specialActionCards();
                break;
            case "A":
                specialAbilities();
                break;
            case "T":
                treasureCards();
                break;
            case "F":
                floodedTiles();
                break;
            case "C":
                captureTreasure();
                break;
            case "Y":
                toDoOnTurn();
                break;
            case "I":
                System.out.println("____________:ALL INSTRUCTION:____________");
                System.out.println("\n");
                howToWin();
                System.out.println("\n");
                howToMove();
                System.out.println("\n");
                specialActionCards();
                System.out.println("\n");
                specialAbilities();
                System.out.println("\n");
                treasureCards();
                System.out.println("\n");
                floodedTiles();
                System.out.println("\n");
                captureTreasure();
                System.out.println("\n");
                toDoOnTurn();
                break;          
            default:
                System.out.println("Invalid value entered");
                return false;
        }

        return true;
    }

    private void howToWin() {
        System.out.println("*************************How to win instruction:***************************");
        System.out.println("Use your cards to your advantage. You need to use your turns wisely as each \n"
                + "time you play, you will lose 3 turns.(use or lose) It is upt to you to travel and unflood \n"
                + "tiles that treasures are on. Make sure you allocate anough turns to collect all treasures \n"
                + "and make it to the landing pad before you have no more turns left.");
        
    }

    private void howToMove() {
        System.out.println("*************************How to move instruction:***************************");
        System.out.println("Moving around the board is easy. Every turn you are given 3 actions. One thing you \n"
                + "can do with those actions is to move. In the Game Menu, you can select (M). You will then be \n"
                + "presented with four options, move up, down, right, or left. Each time you use a direction, \n"
                + "you use an action.");
    }

    private void specialActionCards() {
        System.out.println("*************************About special action cards:************************");
    }

    private void specialAbilities() {
        System.out.println("*************************About special abilities:***************************");
    }

    private void treasureCards() {
        System.out.println("*************************About treasure cards:******************************");
    }

    private void floodedTiles() {
        System.out.println("*************************About flooded tiles:*******************************");
    }

    private void captureTreasure() {
        System.out.println("*************************How to capture treasure:***************************");
    }

    private void toDoOnTurn() {
        System.out.println("*************************What to do on turn:********************************");
    }

    
}
