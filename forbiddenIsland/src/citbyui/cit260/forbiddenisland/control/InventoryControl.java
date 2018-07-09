/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.forbiddenisland.exceptions.InventoryControlException;

/**
 *
 * @author mcwis
 */
public class InventoryControl {

    public static int getCardsLeft(int player1Cards, int player2Cards) throws InventoryControlException {

        if (player1Cards < 0 || player1Cards > 29) {
            throw new InventoryControlException("Number of cards must be between 0 and 29");
        }
        if (player2Cards < 0 || player2Cards > 29) {
            throw new InventoryControlException("Number of cards must be between 0 and 29");
        }

        int cardsLeft = 30 - (player1Cards + player2Cards);

        return cardsLeft;
    }
}
