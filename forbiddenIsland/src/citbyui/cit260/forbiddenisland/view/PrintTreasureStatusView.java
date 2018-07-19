/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DD
 */
class PrintTreasureStatusView extends View{

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("Name this file with .txt after");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
                try {
                    //GameControl.saveGame(game);
                    GameControl.printTreasureStatus(locations, filePath);
                }
                catch (GameControlException ex) {
                    Logger.getLogger(SaveGameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SaveGameView.class.getName()).log(Level.SEVERE, null, ex);
                }

        this.console.println("Success: File Saved!"); 
        return true;
    }
    
}
