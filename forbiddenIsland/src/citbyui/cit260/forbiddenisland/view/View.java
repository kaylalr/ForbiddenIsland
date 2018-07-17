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
        String[] inputs = new String[1];
        String selection = null;

        System.out.println(promptMessage);
        boolean valid = false;
        try {
            while (valid == false) {

                //CREATED SCANNER
//               Scanner inFile;
//            inFile = new Scanner(System.in);
                selection = this.keyboard.readLine();

                selection = selection.trim().toUpperCase();
                System.out.println(promptMessage);
                //System.out.println("Please choose a main menu item: ");
               //String value = inFile.nextLine().trim().toUpperCase();

                if (selection.length() < 1) {
                    System.out.println("Error: Please re-enter value: ");
                    continue;
                }
                //inputs[0] = value;
                break;
            }
        } catch (IOException e) {
            System.out.println("Error reading inputs: " + e.getMessage());
        }
        return selection;
    }

}
