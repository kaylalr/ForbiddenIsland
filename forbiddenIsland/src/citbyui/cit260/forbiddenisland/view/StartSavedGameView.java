/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import forbiddenisland.ForbiddenIsland;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */

public class StartSavedGameView extends View{
    
        @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("What file would you like to load?");
        
        return inputs;
    }
    
        @Override
    public boolean doAction(String[] inputs) {
        String filePath = inputs[0];
        try{
            GameControl.getGame(filePath);
        }
        catch (GameControlException ex){
            ErrorView.display(this.getClass().getName(),"Game = Null, invalid");
            return false;
        }   catch (IOException ex) {
                Logger.getLogger(StartSavedGameView.class.getName()).log(Level.SEVERE, null, ex);
            }
           GameMenuView gameMenuView = new GameMenuView();
           gameMenuView.display();
           return true;
    }
    
}
