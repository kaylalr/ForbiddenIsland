/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author Kayla
 */
public class GiveTreasureCardView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        inputs[0] = this.getInput("Which card(s) would you like to give?\n"
                + "E - Earth Stone #\n"
                + "S - Statue of the Wind\n"
                + "C - Crystal of Fire #\n"
                + "O - Ocean's Chalice #\n");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        switch (inputs[0]) {
            case "E":
                this.console.println("You have chosen to give the Earth Stone.");

                break;
            case "S":
                this.console.println("You have chosen to give the Statue of the Wind.");
                break;
            case "C":
                this.console.println("You have chosen to give the Crystal of Fire.");
                break;
            case "O":
                this.console.println("You have chosen to give the Ocean's Chalice.");
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid input");
                break;
        }
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        return true;
    }

}
