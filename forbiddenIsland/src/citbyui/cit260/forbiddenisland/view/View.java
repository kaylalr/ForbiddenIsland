/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import forbiddenisland.ForbiddenIsland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public abstract class View implements ViewInterface {

    protected final BufferedReader keyboard = ForbiddenIsland.getInFile();
    protected final PrintWriter console = ForbiddenIsland.getOutFile();

    public View() {
    }

    @Override
    public void display() {
           
        boolean endOfView = false;

        do {
            String[] inputs = this.getInputs();
            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }

            endOfView = doAction(inputs);

        } while (endOfView != true);

    }

    @Override
    public String getInput(String promptMessage) {
        String inputs = null;
        boolean valid = false;
        
        try {
            // while a valid input has not been retrieved
            while (valid == false) {
                this.console.println(promptMessage);
                
                // get the value enetered from keyboard
                inputs = this.keyboard.readLine();
                // trim and make value entered to upperCase
                inputs = inputs.trim().toUpperCase();
                if (inputs.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "Error: Please re-enter value: ");
                    continue;
                }
                break;
            }
        } catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "Error reading inputs: " + e.getMessage());
        }
        return inputs;
    }


}
