/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Card;
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
        
        int earth = 0;
        int fire = 0;
        int water = 0;
        int wind = 0;
        ArrayList<Card> actorCards = actor.getCards();

        for (Card card : actorCards) {
            if (card.getHand() == 1) {
                if (card.getName().equals("earth")) {
                    earth++;
                }
                if (card.getName().equals("fire")) {
                    fire++;
                }
                if (card.getName().equals("water")) {
                    water++;
                }
                if (card.getName().equals("wind")) {
                    wind++;
                }
            }

        }
        
        int row = actor.getCoordinates().x;
        int col = actor.getCoordinates().y;
        String treasureName = locations[row][col].getTreasure().getName();
        if (!locations[row][col].getTreasure().getName().equals("Empty")) {
            if (locations[row][col].getTreasure().getStatus().equals("Captured")) {
                //this.console.println("You have already captured the " + treasureName + " treasure.\n");
                this.console.println("\n\n\n*******************************************************\n"
                    + "*\n\n"
                    + "You have already captured the " + treasureName + " treasure.\n"
                    + "\n*\n"
                    + "*******************************************************\n");
                inputs[0] = "Q";
            } else {
                if (treasureName.equals("Earth Stone") && earth >= 4) {
                    this.console.println("Would you like to capture the " + treasureName + " treasure?\n"
                        + "Y - Yes\n"
                        + "N - No\n");
                    inputs[0] = this.getInput("Please enter Y or N:");
                }
                if (treasureName.equals("Ocean's Chalice") && water >= 4) {
                    this.console.println("Would you like to capture the " + treasureName + " treasure?\n"
                        + "Y - Yes\n"
                        + "N - No\n");
                    inputs[0] = this.getInput("Please enter Y or N:");
                }
                if (treasureName.equals("Crystal of Fire") && fire >= 4) {
                    this.console.println("Would you like to capture the " + treasureName + " treasure?\n"
                        + "Y - Yes\n"
                        + "N - No\n");
                    inputs[0] = this.getInput("Please enter Y or N:");
                }
                if (treasureName.equals("Statue of the Wind") && wind >= 4) {
                    this.console.println("Would you like to capture the " + treasureName + " treasure?\n"
                        + "Y - Yes\n"
                        + "N - No\n");
                    inputs[0] = this.getInput("Please enter Y or N:");
                }
                else {
                    this.console.println("*******************************************************\n"
                            + "You do not have enough " + treasureName + " cards to capture this treasure."
                                    + "*******************************************************\n");
                    inputs[0] = "Q";
                }
                
            }
        } else {
            this.console.println("\n\n\n**********************************************\n"
                    + "*\n"
                    + "       There is not a treasure here.\n"
                    + "*\n"
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
                this.console.println("\n\n\n***************************************************\n" 
                        + "*\n"
                        + "Congrats! You have collected the " + treasureName + " trophy!\n"
                        + "*\n"
                        + "***************************************************\n");
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
