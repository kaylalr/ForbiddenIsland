/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.MapControl;
import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DD
 */
public class MoveMenuView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        // test code
        //int turn = (int) Math.ceil(Math.random() * 2);
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        this.console.println(currActors.get(0)+"\n");
        this.console.println(currActors.get(1));
        if (actor.getName().equals("Explorer")) {
            inputs[0] = this.getInput("\nWhere would you like to move?\n"
                    + "W - move up\n"
                    + "A - move left\n"
                    + "S - move down\n"
                    + "D - move right\n"
                    + "1 - up and to the left\n"
                    + "E - up and to the right\n"
                    + "Z - down and to the left\n"
                    + "C - down and to the right\n");
        } else {
            inputs[0] = this.getInput("\nWhere would you like to move?\n"
                    + "W - move up\n"
                    + "A - move left\n"
                    + "S - move down\n"
                    + "D - move right\n"
                    + "F - Fly\n");
        }
        return inputs;
        // end test code
        // origional code
//        inputs[0] = this.getInput("\nWhere would you like to move?\n"
//                    + "W - move up\n"
//                    + "A - move left\n"
//                    + "S - move down\n"
//                    + "D - move right\n"
//                    + "F - Fly\n");
//        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        try {
            if (inputs[0].length() > 12) {
                ErrorView.display(this.getClass().getName(), "Error: Invalid Name.");
                return false;
            }
            
            ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
            Actor actor = currActors.get(0);
            int currTurns = actor.getTurns();
            if (currTurns > 3) {
                ErrorView.display(this.getClass().getName(), "Error: No Turns Left. END TURN.");
                return true;
            }
            
            int newRow = actor.getCoordinates().x;
            int newColumn = actor.getCoordinates().y;
            
            switch (inputs[0]) {
                case "W":
                    this.console.println("Move Up");
                    newRow += -1;
                    Location newLoc = MapControl.moveActor(actor, newRow, newColumn);
                    break;
                case "A":
                    this.console.println("Move Left");
                    newLoc = MapControl.moveActor(actor, newRow, newColumn - 1);
                    break;
                case "S":
                    this.console.println("Move Down");
                    newLoc = MapControl.moveActor(actor, newRow + 1, newColumn);
                    break;
                case "D":
                    this.console.println("Move Right");
                    newLoc = MapControl.moveActor(actor, newRow, newColumn + 1);
                    break;
                case "1":
                    this.console.println("move up and to the left");
                    newLoc = MapControl.moveActor(actor, newRow - 1, newColumn - 1);
                    break;
                case "E":
                    this.console.println("Move up and to the right");
                    newLoc = MapControl.moveActor(actor, newRow - 1, newColumn + 1);
                    break;
                case "Z":
                    this.console.println("Move down and to the left");
                    newLoc = MapControl.moveActor(actor, newRow + 1, newColumn - 1);
                    break;
                case "C":
                    this.console.println("Move down and to the right");
                    newLoc = MapControl.moveActor(actor, newRow + 1, newColumn + 1);
                    break;
                case "F":
                    this.console.println("Where would you like to fly?");
                    FlyView flyView = new FlyView();
                    flyView.display();
                    //System.out.println("\nYou have moved to " + inputs[0] + "," + inputs[1]);
//                    if (currTurns < 4) {
//                        int newTurns = currTurns++;
//                        actor.setTurns(newTurns);
//                    }
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "Please enter a valid input.");
                    return false;
            }
            
        } catch (MapControlException ex) {
            Logger.getLogger(MoveMenuView.class.getName()).log(Level.SEVERE, null, ex);
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return true;
    }

}
