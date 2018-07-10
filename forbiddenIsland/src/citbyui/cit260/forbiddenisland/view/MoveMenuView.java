/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.MapControl;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DD
 */
public class MoveMenuView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[2];
        // test code
        int turn = (int) Math.ceil(Math.random() * 2);
        if (turn == 1) {
            inputs[0] = this.getInput("\nWhere would you like to move?\n"
                    + "W - move up\n"
                    + "A - move left\n"
                    + "S - move down\n"
                    + "D - move right\n"
                    + "Q - up and to the left\n"
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
        if (inputs[0].length() > 12) {
            System.out.println("Error: Please re-enter name: ");
            return false;
        }

        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);

        int newRow = actor.getCoordinates().x;
        int newColumn = actor.getCoordinates().y;

        switch (inputs[0]) {
            case "W":
                System.out.println("Move Up");
                Location newLoc = MapControl.moveActor(actor, newRow - 1, newColumn);
                break;
            case "A":
                System.out.println("Move Left");
                Location newLoc = MapControl.moveActor(actor, newRow, newColumn - 1);
                break;
            case "S":
                System.out.println("Move Down");
                Location newLoc = MapControl.moveActor(actor, newRow + 1, newColumn);
                break;
            case "D":
                System.out.println("Move Right");
                Location newLoc = MapControl.moveActor(actor, newRow, newColumn + 1);
                break;
            case "Q":
                System.out.println("move up and to the left");
                Location newLoc = MapControl.moveActor(actor, newRow - 1, newColumn - 1);
                break;
            case "E":
                System.out.println("Move up and to the right");
                Location newLoc = MapControl.moveActor(actor, newRow - 1, newColumn + 1);
                break;
            case "Z":
                System.out.println("Move down and to the left");
                Location newLoc = MapControl.moveActor(actor, newRow + 1, newColumn - 1);
                break;
            case "C":
                System.out.println("Move down and to the right");
                Location newLoc = MapControl.moveActor(actor, newRow + 1, newColumn + 1);
                break;
            case "F":
                System.out.println("Where would you like to fly?");
                inputs[0] = this.getInput("Please enter row:");
                inputs[1] = this.getInput("Please enter column:");
                System.out.println("\nYou have moved to " + inputs[0] + "," + inputs[1]);
                break;
            default:
                System.out.println("Please enter a valid input.");
                return false;
        }
        return true;
    }

}
