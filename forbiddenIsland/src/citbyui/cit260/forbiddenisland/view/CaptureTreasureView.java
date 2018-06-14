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

            System.out.println("How many trophies are left: ");
            System.out.println("Please enter Y or N: ");
            System.out.println("Y - Yes: ");
            System.out.println("N - No: ");
            System.out.println("Q - return to previous menu");
            String value = inFile.nextLine().trim().toUpperCase();

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
        switch (inputs[0]){
            case "Y":
                System.out.println("Congrats! You have collected the _______ trophy!");
                break;
            case "N":
                System.out.println("You have decided to leave the trophy...");
                break;
//            case "Q":
//                break;
            default:
                System.out.println("Error: Try again...");
                return false;
        }
        return true;
    }
}
