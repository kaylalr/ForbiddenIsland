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
public class MoveMenuView extends View{

    void displayMoveMenuView() {
        boolean endOfView = false;

        do {
            String[] inputs = getInputs();

            if (inputs == null || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            endOfView = doAction(inputs);

        } while (endOfView != true);
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        boolean valid = false;
        while (valid == false) {
        //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);

            System.out.println("\nWhere would you like to move?\n"
                    + "W - move up\n"
                    + "A - move left\n"
                    + "S - move down\n"
                    + "D - move right\n");
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

    @Override
    public boolean doAction(String[] inputs) {
        switch(inputs[0]){
            case "W":
                System.out.println("Move Up");
                break;
            case "A":
                System.out.println("Move Left");
                break;
            case "S":
                System.out.println("Move Down");
                break;
            case "D":
                System.out.println("Move Right");
                break;
        }
        return true;
    }
    
}
