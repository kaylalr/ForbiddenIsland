/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.model.Game;
import forbiddenisland.ForbiddenIsland;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class MainMenuView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        this.console.println("Main Menu\n"
                + "N - Start new game\n"
                + "R - Restart current game\n"
                + "L - Load saved game\n"
                + "H - Get help\n"
                + "Q - Quit\n");

        inputs[0] = this.getInput("\nPlease choose a main menu item: ");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        try {
            if (inputs[0].length() > 1) {
                ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
                return false;
            }
            switch (inputs[0]) {
                case "N":
                    //this.console.println("Inputs = N");
                    this.startNewGame();
                    break;
                case "R":
                    //this.console.println("Inputs = R");
                    this.restartNewGame();
                    break;
                    
                case "L": 
                    //this.console.println("Inputs = L");
                    this.startSavedGame();
                    break;
                case "H":
                    //this.console.println("Inputs = H");
                    this.getHelp();
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "Invalid value entered");
                    return false;
            }

        } catch (GameControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void startNewGame() throws GameControlException, MapControlException {
        int game = GameControl.createNewGame(ForbiddenIsland.getPlayer());

        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void restartNewGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        //startExistingGameView.displayStartExistingGameView();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    private void startSavedGame () {
        StartSavedGameView startSavedGameView = new StartSavedGameView();
        startSavedGameView.display();
    }

}
