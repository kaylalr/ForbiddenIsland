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
public class StartProgramView {

    public StartProgramView() {
    }

    public void displayStartProgramView() {

        //return name;
        boolean endOfView = false;

        do {
            String[] inputs = this.getInputs();
            if (inputs == null || inputs[0].toUpperCase().equals('Q')) {
                return;
            } 
            
            endOfView = doActions(inputs);         

        } while (endOfView != true);

//        doActions(name);
    }

    private String[] getInputs() {

        String[] inputs = new String[1];
//      inputs[0] = "textInput";

        //DISPLAYS BANNER PAGE
        System.out.println("***************************************************************************");
        System.out.println("*  You are stuck on an island and the only way off is to collect all      *\n"
                + "*  the treasure and fly away.  But it’s not as easy as it sounds.  As     *\n"
                + "*  you are collecting the treasure, the island is being flooded!  You     *\n"
                + "*  need to hurry! Collect all the treasure as fast as you can and leave   *\n"
                + "*  before you become stuck, with no escape.                               *");
        System.out.println("***************************************************************************");
        System.out.println("\n");

        boolean valid = false;

        while (valid == false) {
            //CREATED SCANNER  
            Scanner inFile;
            inFile = new Scanner(System.in);

            //CALLS FOR NAME  
            System.out.println("What is your name: ");
            String value = inFile.nextLine().trim();
            
            if (value.length() < 1 || value.length() > 12) {
                System.out.println("Error: Please re-enter a valid name: ");
                continue;
            }
            inputs[0] = value;
            valid = true;
        }
        return inputs;
    }

    private boolean doActions(String[] inputs) {

//      //DISPLAY WELCOME MESSAGE
//        System.out.println("\n");
//        System.out.println("Welcome to the game " + name + "! We hope you have a lot of fun!"); 
//        System.out.println("\n");
//        
//      //DISPLAY MAIN MENU
//        System.out.println("Choose a Start option: ");
//        System.out.println("N - Start new game");
//        System.out.println("R - Restart current game");
//        System.out.println("I - View instructions");
//        System.out.println("E - Exit");
//      //CREATES AN INPUT STRING    
//        String[] inputs = this.getInputs();
//      
//      //PRINTS OUT INPUT CHOICE
//        System.out.println(inputs[0]);
//            
//        return true;
        System.out.println("**** doAction() called ***");
        System.out.println("\tinputs = " + inputs[0]);

        return true;
    }

}
