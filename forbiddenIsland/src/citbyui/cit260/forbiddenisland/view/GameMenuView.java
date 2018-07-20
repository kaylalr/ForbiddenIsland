/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.forbiddenisland.control.MapControl;
import citbyui.cit260.model.Actor;
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
