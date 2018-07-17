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
public class CaptureTreasureView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        this.console.println("Would you like to capture the ________ treasure?\n"
                + "Trophies left: #\n"
                + "Y - Yes\n"
                + "N - No\n");

        inputs[0] = this.getInput("Please enter Y or N:");
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
            ErrorView.display(this.getClass().getName(), "Error: Invalid value.");
            return false;
        }
        switch (inputs[0]) {
            case "Y":
                this.console.println("Congrats! You have collected the _______ trophy!");
                break;
            case "N":
                this.console.println("You have decided to leave the trophy...");
                break;
//            case "Q":
//                break;
            default:
                ErrorView.display(this.getClass().getName(), "Error: Try again...");
                return false;
        }
        return true;
    }
}
