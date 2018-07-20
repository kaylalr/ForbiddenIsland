/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.view;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mcwis
 */
public class ViewCardsView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        int totalUnfloodCards = 5;

        Random rn = new Random();
        int uAnswer = rn.nextInt(totalUnfloodCards) + 1;
        this.console.println(uAnswer);

        int p1UnfloodCardsInHand = 100;
        
        while(p1UnfloodCardsInHand > 100)
        
        if (p1UnfloodCardsInHand > 5){
            p1UnfloodCardsInHand = uAnswer;
        }
        
        
        int p2UnfloodCardsInHand = 1;
        if (uAnswer == 1) {
            p2UnfloodCardsInHand = 4;
        }
        if (uAnswer == 2) {
            p2UnfloodCardsInHand = 3;
        }
        if (uAnswer == 3) {
            p2UnfloodCardsInHand = 2;
        }
        if (uAnswer == 4) {
            p2UnfloodCardsInHand = 1;
        }
        if (uAnswer == 5) {
            p2UnfloodCardsInHand = 0;
        } else {
            ErrorView.display(this.getClass().getName(), "Number cannot be null");
        }

        int totalHelecopterCards = 5;
        int hAnswer = rn.nextInt(totalUnfloodCards) + 1;
        this.console.println(hAnswer);

        int p1HelecopterCards = hAnswer;
        int p2HelecopterCards = 1;

        if (hAnswer == 1) {
            p2HelecopterCards = 4;
        }
        if (hAnswer == 2) {
            p2HelecopterCards = 3;
        }
        if (hAnswer == 3) {
            p2HelecopterCards = 2;
        }
        if (hAnswer == 4) {
            p2HelecopterCards = 1;
        }
        if (hAnswer == 5) {
            p2HelecopterCards = 0;
        } else {
            ErrorView.display(this.getClass().getName(), "Number cannot be null");
        }

        this.console.println("_________________________________________________________________");
        this.console.println("|  Total - 30 Cards in Game:                                    |");
        this.console.println("|_______________________________________________________________|");
        this.console.println("|  Player 1:                                                    |");
        this.console.println("|  You have " + p1UnfloodCardsInHand + " unFlood cards in hand. |");
        this.console.println("|  Your have " + p1HelecopterCards + " helecopter cards in hand.|");
        this.console.println("|_______________________________________________________________|");
        this.console.println("|  Player 2:                                                    |");
        this.console.println("|  You have " + p2UnfloodCardsInHand + " unFlood cards in hand. |");
        this.console.println("|  Your have " + p2HelecopterCards + " helecopter cards in hand.|");
        this.console.println("|_______________________________________________________________|");
        inputs[0] = this.getInput("Press Q to return:");

        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {

        return true;
    }

}
