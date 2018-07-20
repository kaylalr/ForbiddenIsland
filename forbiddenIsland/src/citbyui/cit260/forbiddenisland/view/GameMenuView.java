/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.control.MapControl;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Location;
import forbiddenisland.ForbiddenIsland;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mcwis
 */
public class GameMenuView extends View {

    public GameMenuView() {
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        MapControl.displayMap();
        this.console.println("\n\nGame Menu\n"
                + "M – Move\n"
                + "U – Unflood a tile\n"
                + "G – Give Treasure Card\n"
                + "C – Capture Treasure\n"
                + "A – Use Special Action Card\n"
                + "V – View Cards\n"
                + "P - Print Treasure Lists\n"
                + "E – End Turn\n"
                + "I – View Instructions\n"
                + "S – Save Game\n"
                + "Q – Quit");

        inputs[0] = this.getInput("\nPlease choose a game menu item: ");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
//        ArrayList<Actor> currentActors = ForbiddenIsland.getPlayer().getActors();
//        Actor actorOne = currentActors.get(0);
//        if (actorOne.getName().equals("Pilot") || actorOne.getName().equals("Explorer")) {
//            if (ForbiddenIsland.getPlayer().getActors().get(0).getTurns() == 0) {
//                inputs[0] = "Q";
//            }
//        }
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        switch (inputs[0]) {
            case "M":
                MoveMenuView moveMenuView = new MoveMenuView();
                moveMenuView.display();
                break;
            case "U":
                UnfloodTileView unfloodTileView = new UnfloodTileView();
                unfloodTileView.display();
                break;
            case "G":
                GiveTreasureCardView giveTreasureCardView = new GiveTreasureCardView();
                giveTreasureCardView.display();
                break;
            case "C":
                CaptureTreasureView captureTreasureView = new CaptureTreasureView();
                captureTreasureView.display();
                break;
            case "A":
                UseSpecialAcitonCardView useSpecialAcitonCardView = new UseSpecialAcitonCardView();
                useSpecialAcitonCardView.display();
                break;
            case "V":
                ViewCardsView viewCardsView = new ViewCardsView();
                viewCardsView.display();
                break;
            case "P":
                PrintTreasureView printTreasureView = new PrintTreasureView();
                printTreasureView.display();
            case "E":
                GameControl.endTurn();
                break;
            case "I":
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.display();
                break;
            case "S":
                this.saveGame();
                break;

        }
        
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        Actor actor2 = currActors.get(1);
        
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (locations[i][j].getLocationType().equals("landingPad") && actor.getCoordinates().x == i && actor.getCoordinates().y == j && actor2.getCoordinates().x == i && actor2.getCoordinates().y == j) {
//                    EndOfView endOfView = new EndOfView();
//                    endOfView.display();
//                    System.out.println("YOU WIN!");
//                    return true;
//                }
//            }
//        }

            Location landingPad1 = new Location();
            boolean landingPad = false;
            boolean water = false;
            boolean wind = false;
            boolean earth = false;
            boolean fire = false;
            boolean actorOne = false;
            boolean actorTwo = false;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (locations[i][j].getLocationType().equals("landingPad")) {
                       landingPad1 = locations[i][j];
                       landingPad1.setRow(i);
                       landingPad1.setColumn(j);
                        landingPad = true;
                    }
                    if (locations[i][j].getTreasure().getName().equals("water")) {
                        if (locations[i][j].getTreasure().getStatus().equals("captured")) {
                            water = true;
                        }
                    }
                    if (locations[i][j].getTreasure().getName().equals("wind")) {
                        if (locations[i][j].getTreasure().getStatus().equals("captured")) {
                            wind = true;
                        }
                    }
                    if (locations[i][j].getTreasure().getName().equals("earth")) {
                        if (locations[i][j].getTreasure().getStatus().equals("captured")) {
                           earth = true;
                        }
                    }
                    if (locations[i][j].getTreasure().getName().equals("fire")) {
                        if (locations[i][j].getTreasure().getStatus().equals("captured")) {
                            fire = true;
                        }
                    }
                    
                }
            }
            if (actor.getCoordinates().x == landingPad1.getRow() && actor.getCoordinates().y == landingPad1.getColumn()) {
                        actorOne = true;
                    }
            if (actor2.getCoordinates().x == landingPad1.getRow() && actor2.getCoordinates().y == landingPad1.getColumn()) {
                        actorTwo = true;
                    }
        
            if (landingPad == true && water == true && wind == true && earth == true && fire == true && actorOne == true && actorTwo == true) {
                    EndOfView endOfView = new EndOfView();
                    endOfView.display();
                    return true;
            }
            
        int currTurns = actor.getTurns();
        if (currTurns > 2) {
            this.console.println("\n************************************\n"
                    + "*        Your turn is over.        *"
                    + "************************************\n");
            GameControl.endTurn();
        }
        return false;
    }

    private void saveGame() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
    }

}
