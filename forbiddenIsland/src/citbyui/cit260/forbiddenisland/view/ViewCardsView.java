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
public class ViewCardsView {

    void displayViewCardsView() {
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
        int p1UnfloodCardsInHand = 2;
        int p2UnfloodCardsInHand = 3;
        int p1HelecopterCards = 3;
        int p2HelecopterCards = 2;
        System.out.println("_________________________________________________________________");
        System.out.println("|  Total - 30 Cards in Game:                                    |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|  Player 1:                                                    |");
        System.out.println("|  You have " + p1UnfloodCardsInHand + " unFlood cards in hand. |");
        System.out.println("|  Your have " + p1HelecopterCards + " helecopter cards in hand.|");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|  Player 2:                                                    |");
        System.out.println("|  You have " + p2UnfloodCardsInHand + " unFlood cards in hand. |");
        System.out.println("|  Your have " + p2HelecopterCards + " helecopter cards in hand.|");
        System.out.println("|_______________________________________________________________|");
        
        boolean valid  = false;
        while (valid == false){
            
            Scanner inFile;
            inFile = new Scanner(System.in);
            
            System.out.println("Press (Q) to return to game menu:");
            String value = inFile.nextLine().trim();
            
            if(value.length() < 1 || value.length() > 1){
                System.out.println("Error: Enter any key to return to game menu: ");
                continue;
            }
            
            inputs[0] = value;
            valid = true;
        }
        
        return inputs;
    }

    private boolean doActions(String[] inputs) {
 
        return true;
    }

}
