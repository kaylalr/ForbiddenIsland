/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

/**
 *
 * @author mcwis
 */
public class InventoryControl {

    public static int getCardsLeft(int player1Cards, int player2Cards) {

        if (player1Cards < 0 || player1Cards > 29) {
            return -1;
        }
        if (player2Cards < 0 || player2Cards > 29) {
            return -1;
        }

        int cardsLeft = 30 - (player1Cards + player2Cards);

        return cardsLeft;
    }
}
