/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import citbyui.cit260.forbiddenisland.control.GameControl;
import citbyui.cit260.model.Game;
import forbiddenisland.ForbiddenIsland;
import java.util.Scanner;

/**
 *
 * @author mcwis
 */
class MainMenuView {

    void displayMainMenuView() {
        System.out.println("*** displayMainMenuView() called ***");

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
          
        System.out.println("Main Menu");
        System.out.println("N - Start new game");
        System.out.println("R - Restart current game");
        System.out.println("H - Get Help");
        System.out.println("Q - Quit");
        
        boolean valid = false;
        while (valid == false) {
            //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);

            //CALLS FOR NAME  
            System.out.println("Please choose a main menu item: ");
            String value = inFile.nextLine().trim().toUpperCase();
            
            if (value.length() < 1 || value.length() > 1) {
                System.out.println("Error: Please re-enter menu item: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
      }
      
       private boolean doActions(String[] inputs) {
           System.out.println("*** mainMenuView -doActions called ***");
           return true;
       }
}
