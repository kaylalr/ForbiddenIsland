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
public abstract class View implements ViewInterface {

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

        //System.out.println(promptMessage);
        boolean valid = false;
        while (valid == false) {
            //CREATED SCANNER
            Scanner inFile;
            inFile = new Scanner(System.in);

            System.out.println(promptMessage);
            //System.out.println("Please choose a main menu item: ");
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1) {
                System.out.println("Error: Please re-enter value: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs[0];
    }

}
