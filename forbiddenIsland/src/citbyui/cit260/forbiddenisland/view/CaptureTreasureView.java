/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Scanner;

/**
 *
 * @author DD
 */
class CaptureTreasureView {

    void displayCaptureTreasureView() {
        boolean endOfView = false;

        do {
            String[] inputs = this.getInputs();
            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }

            endOfView = doActions(inputs);

        } while (endOfView != true);
    }

    private String[] getInputs() {
        String[] inputs = new String[1];
        System.out.println("Would you like to capture the _______ treasure? ");

        boolean valid = false;
        while (valid == false) {

            Scanner inFile;
            inFile = new Scanner(System.in);

            System.out.println("Please enter Y or N: ");
            System.out.println("Y - Yes: ");
            System.out.println("N - No: ");
            String value = inFile.nextLine().trim();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please enter either Y or N: ");
                continue;
            }


            inputs[0] = value;
            valid = true;
        }

        return inputs;
    }

    private boolean doActions(String[] inputs) {
        System.out.println("You have selected - " + inputs[0]);

        return true;
    }

}
