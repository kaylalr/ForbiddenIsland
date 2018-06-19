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

    void displayHelpMenuView() {
        boolean endOfView = false;
        
        do{
            String[] inputs = getInputs();
            
            if(inputs == null || inputs[0].toUpperCase().equals("Q")){
                return;
            }
            endOfView = doActions(inputs);
            
        }while(endOfView != true);
        
    }
    
    private String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("Help Menu");
        System.out.println("W - How to Win");
        System.out.println("M - How to Move");
        System.out.println("S - Special Action Cards");
        System.out.println("A - Special Abilities");
        System.out.println("T - Treasure Cards");
        System.out.println("F - Flooded Tiles");
        System.out.println("C - Capture Treasure");
        System.out.println("Y - What to do on Your Turn");
        System.out.println("I - View All Instructions");
        System.out.println("Q - Quit");

        boolean valid = false;
        while (valid == false) {
            //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);

            //CALLS FOR NAME  
            System.out.println("Please choose a main menu item: ");
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter menu item: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }
    
    private boolean doActions(String[] inputs) {
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
