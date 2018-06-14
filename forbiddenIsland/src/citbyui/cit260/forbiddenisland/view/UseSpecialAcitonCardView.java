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
class UseSpecialAcitonCardView {

    void displayUseSpecialAcitonCardView() {
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

            System.out.println("Where would you like to move? Please enter the coordinates:");
            String value = inFile.nextLine().trim().toUpperCase();

            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter valid coordinates: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }

    private boolean doActions(String[] inputs) {
        System.out.println("*** UseSpeicalActionCard doAction() called ***");
        return true;
    }
    
}
