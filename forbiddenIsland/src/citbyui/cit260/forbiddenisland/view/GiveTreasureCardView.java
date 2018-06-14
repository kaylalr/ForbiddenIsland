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
class GiveTreasureCardView {

    void displayGiveTreasureCardView() {
        boolean endOfView = false;

        do {
            String[] inputs = getInputs();

            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endOfView = doActions(inputs);

        } while (endOfView != true);
    }

    private String[] getInputs() {
        String[] inputs = new String[1];
        
        boolean valid = false;
        while (valid == false) {
        //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);
            
            System.out.println("Which card(s) would you like to give?\n"
                    + "E - Earth Stone (#)\n"
                    + "S - Statue of the Wind (#)\n"
                    + "C - Crystal of Fire (#)\n"
                    + "O - Ocean's Chalice (#)\n");
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter valid option: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }

    private boolean doActions(String[] inputs) {
        switch(inputs[0]){
            case "E":
                System.out.println("give Earth Stone");
                break;
            case "S":
                System.out.println("give Statue of the Wind");
                break;
            case "C":
                System.out.println("give Crystal of Fire");
                break;
            case "O":
                System.out.println("give Ocean's Chalice");
                break;
        }
        return true;
    }
    
}
