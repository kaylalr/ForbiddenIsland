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
public class ViewCardsView extends View {

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        int p1UnfloodCardsInHand = 2;
        int p2UnfloodCardsInHand = 3;
        int p1HelecopterCards = 3;
        int p2HelecopterCards = 2;
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
