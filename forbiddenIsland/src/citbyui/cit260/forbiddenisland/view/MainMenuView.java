/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.model.Game;
import forbiddenisland.ForbiddenIsland;
import java.util.Scanner;

/**
 *
 * @author mcwis
 */
public class MainMenuView extends View{

    void displayMainMenuView() {
        System.out.println("*** displayMainMenuView() called ***");

        boolean endOfView = false;

        do {
            String[] inputs = this.getInputs();
            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }

            endOfView = doAction(inputs);

        } while (endOfView != true);

    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("Main Menu\n"
                + "N - Start new game\n"
                + "R - Restart current game\n"
                + "H - Get help\n"
                + "Q - Quit\n");

        inputs[0] = this.getInput("\nPlease choose a main menu item: ");
        return inputs;
//        String[] inputs = new String[1];
//
//        System.out.println("Main Menu");
//        System.out.println("N - Start new game");
//        System.out.println("R - Restart current game");
//        System.out.println("H - Get Help");
//        System.out.println("Q - Quit");
//
//        boolean valid = false;
//        while (valid == false) {
//            //CREATED SCANNER  
//            Scanner inFile;
//            inFile = new Scanner(System.in);
//
//            //CALLS FOR NAME  
//            System.out.println("Please choose a main menu item: ");
//            String value = inFile.nextLine().trim().toUpperCase();
//
//            if (value.length() < 1 || value.length() > 1) {
//                System.out.println("Error: Please re-enter menu item: ");
//                continue;
//            }
//            inputs[0] = value;
//            valid = true;
//        }
//        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
                System.out.println("Error: Please re-enter value: ");
                return false;
            }
        switch (inputs[0]) {
            case "N":
                System.out.println("Inputs = N");
                startNewGame();
                break;
            case "R":
                System.out.println("Inputs = R");
                restartNewGame();
                break;
            case "H":
                System.out.println("Inputs = H");
                getHelp();
                break;
            default:
                System.out.println("Invalid value entered");
                return false;
        }

        return true;
    }
    
    private void startNewGame(){
        Game game = GameControl.createNewGame(ForbiddenIsland.getPlayer());
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }
    
    private void restartNewGame(){
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        //startExistingGameView.displayStartExistingGameView();
    }
    
    private void getHelp(){
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    
    
    
}
