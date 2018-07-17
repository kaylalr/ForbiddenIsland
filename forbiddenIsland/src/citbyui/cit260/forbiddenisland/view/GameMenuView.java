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

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        MapControl.displayMap();
        System.out.println("\nGame Menu\n"
                + "M – Move\n"
                + "U – Unflood a tile\n"
                + "G – Give Treasure Card\n"
                + "C – Capture Treasure\n"
                + "A – Use Special Action Card\n"
                + "V – View Cards\n"
                + "E – End Turn\n"
                + "I – View Instructions\n"
                + "S – Save Game\n"
                + "Q – Quit");

        inputs[0] = this.getInput("\nPlease choose a main menu item: ");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
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
            case "E":
                GameControl.endTurn();
                break;
            case "I":
                HelpMenuView helpMenuView = new HelpMenuView();
                helpMenuView.display();
                break;
            case "S":

                break;

        }
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        int currTurns = actor.getTurns();
            if (currTurns > 2) {
                System.out.println("\n************************************\n"
                        + "*        Your turn is over.        *"
                        + "************************************\n");
                GameControl.endTurn();
            }
        return false;
    }
}
