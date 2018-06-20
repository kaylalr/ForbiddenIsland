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
public class CaptureTreasureView extends View{

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        System.out.println("Would you like to capture the ________ treasure?\n"
                + "Trophies left: #\n"
                + "Y - Yes\n"
                + "N - No\n");

        inputs[0] = this.getInput("Please enter Y or N:");
        return inputs;
//        String[] inputs = new String[1];
//        System.out.println("Would you like to capture the _______ treasure? ");
//
//        boolean valid = false;
//        while (valid == false) {
//
//            Scanner inFile;
//            inFile = new Scanner(System.in);
//
//            System.out.println("How many trophies are left: ");
//            System.out.println("Please enter Y or N: ");
//            System.out.println("Y - Yes: ");
//            System.out.println("N - No: ");
//            System.out.println("Q - return to previous menu");
//            String value = inFile.nextLine().trim().toUpperCase();
//
//            if (value.length() < 1 || value.length() > 1) {
//                System.out.println("Error: Please enter either Y or N: ");
//                continue;
//            }
//
//            inputs[0] = value;
//            valid = true;
//        }
//        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        if (inputs[0].length() > 1) {
                System.out.println("Error: Please re-enter value: ");
                return false;
            }
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
