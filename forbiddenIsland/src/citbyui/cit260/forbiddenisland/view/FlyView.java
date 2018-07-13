/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.MapControl;
import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DD
 */
public class FlyView extends View{

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        inputs[0] = this.getInput("Please enter row:");
        inputs[1] = this.getInput("Please enter column:");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        try {
            ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
            Actor actor = currActors.get(0);
            int newRow = parseInt(inputs[0]);
            int newColumn = parseInt(inputs[1]);
            if (newRow < 1 || newRow > 5 || newColumn < 1 || newColumn > 5){
                System.out.println("Error: invalid input.");
                return false;
            }
            //System.out.println("You have chosen Row - " + inputs[0] + ", and Column - " + inputs[1]);
            Location newLoc = MapControl.moveActor(actor, newRow - 1, newColumn - 1);
            
//        if (inputs[0].length() < 1 || inputs[1].length() < 1) {
//            System.out.println("Error, please enter a valid input.");
//        }
//        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
//        Actor actor = currActors.get(0);
//        int newRow = inputs[0];
//        return true;
        } catch (MapControlException ex) {
            Logger.getLogger(FlyView.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;

    }
    
}
