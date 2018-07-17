/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author mcwis
 */
public class HelpMenuView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        this.console.println("Help Menu\n"
                + "W - How to Win\n"
                + "M - How to Move\n"
                + "S - Special Action Cards\n"
                + "A - Special Abilities\n"
                + "T - Treasure Cards\n"
                + "F - Flooded Tiles\n"
                + "C - Capture Treasure\n"
                + "Y - What to do on Your Turn\n"
                + "I - View All Instructions\n"
                + "Q - Quit\n");

        inputs[0] = this.getInput("Please choose a help menu item: ");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        switch (inputs[0]) {
            case "W":
                howToWin();
                break;
            case "M":
                howToMove();
                break;
            case "S":
                specialActionCards();
                break;
            case "A":
                specialAbilities();
                break;
            case "T":
                treasureCards();
                break;
            case "F":
                floodedTiles();
                break;
            case "C":
                captureTreasure();
                break;
            case "Y":
                toDoOnTurn();
                break;
            case "I":
                this.console.println("____________:ALL INSTRUCTION:____________");
                this.console.println("\n");
                howToWin();
                this.console.println("\n");
                howToMove();
                this.console.println("\n");
                specialActionCards();
                this.console.println("\n");
                specialAbilities();
                this.console.println("\n");
                treasureCards();
                this.console.println("\n");
                floodedTiles();
                this.console.println("\n");
                captureTreasure();
                this.console.println("\n");
                toDoOnTurn();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid value.");
                return false;
        }

        return true;
    }

    private void howToWin() {
        this.console.println("*************************How to win instruction:***************************");
        this.console.println("Use your cards to your advantage. You need to use your turns wisely as each\n"
                + "time you play, you will lose 3 turns.(use or lose) It is upt to you to\n"
                + "travel and unflood tiles that treasures are on. Make sure you allocate\n"
                + "anough turns to collect all treasures and make it to the landing pad before\n"
                + "you have no more turns left.");

    }

    private void howToMove() {
        this.console.println("*************************How to move instruction:***************************");
        this.console.println("Moving around the board is easy. Every turn you are given 3 actions. One \n"
                + "thing you can do with those actions is to move. In the Game Menu, you can\n"
                + "select (M). You will then be presented with four options, move up, down,\n"
                + "right, or left. Each time you use a direction, you use an action.");
    }

    private void specialActionCards() {
        this.console.println("*************************About special action cards:************************");
        this.console.println("Special action cards allow you to abilities your individual character would\n"
                + "not normally have. Some of these actions would be like using a helicopter or \n"
                + "moving to any location on the board.");
    }

    private void specialAbilities() {
        this.console.println("*************************About special abilities:***************************");
        this.console.println("Pilot: Can move to any space on the board once a turn.\n"
                + "Explorer: Can move diagonally");
    }

    private void treasureCards() {
        this.console.println("*************************About treasure cards:******************************");
        this.console.println("Treasure cards can be passed along to other players, but will count as a \n"
                + "play.");
    }

    private void floodedTiles() {
        this.console.println("*************************About flooded tiles:*******************************");
        this.console.println("Flooded tiles can be unflooded. Once a tile is sunken, there is no chance of\n"
                + "saving the tile. A player will be forced to go for another treasure if the\n"
                + "one that sunk was holding a treasure.");
    }

    private void captureTreasure() {
        this.console.println("*************************How to capture treasure:***************************");
        this.console.println("To capture treasure, in the Game Menu select (capture treasure). The menu\n"
                + "will prompt you to say either collect it or not. Remember that there are\n"
                + "two of each treasure on the board and you need to collect one of each before\n"
                + "the tiles and or you run out of turns.");
    }

    private void toDoOnTurn() {
        this.console.println("**********************What to do on your turn:******************************");
        this.console.println("On your turn you have several options. Within 3 movements you can collect\n"
                + "treasure, unflood tiles, fly to a location, and most importantly you can \n"
                + "move. Each of these turn uses is essencial and will be used by each player\n"
                + "to succesfully capture all treasures before all turns are used up and the \n"
                + "game is over.");
    }

}
