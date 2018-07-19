/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kayla
 */
public class CaptureTreasureView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        int row = actor.getCoordinates().x;
        int col = actor.getCoordinates().y;
        String treasureName = locations[row][col].getTreasure().getName();
        if (!locations[row][col].getTreasure().getName().equals("Empty")) {
            if (locations[row][col].getTreasure().getStatus().equals("Captured")) {
                this.console.println("You have already captured the " + treasureName + " treasure.\n");
                inputs[0] = "Q";
            } else {
                this.console.println("Would you like to capture the " + treasureName + " treasure?\n"
                        //                    + "Treasures left: #\n"
                        + "Y - Yes\n"
                        + "N - No\n");
                inputs[0] = this.getInput("Please enter Y or N:");
            }
        } else {
            this.console.println("\n**********************************************\n"
                    + "       There is not a treasure here.\n"
                    + "**********************************************\n");
            inputs[0] = "Q";
        }

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        int row = actor.getCoordinates().x;
        int col = actor.getCoordinates().y;
        String treasureName = locations[row][col].getTreasure().getName();
        switch (inputs[0]) {
            case "Y":
                locations[row][col].getTreasure().setStatus("Captured");
                this.console.println("Congrats! You have collected the " + treasureName + " trophy!");
                break;
            case "N":
                this.console.println("You have decided to leave the trophy...");
                break;
            case "Q":
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Error: Try again...");
                return false;
        }
        return true;
    }
}
