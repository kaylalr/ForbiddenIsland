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
public class GameControl {

    
    public static int getTurnsLeft(int player1Turns, int player2Turns){
       	if (player1Turns < 0 || player1Turns > 20){
		return -1;
        }

	if (player2Turns < 0 || player2Turns > 20){
		return -1;
        }
	int turnsLeft = 40 - (player1Turns + player2Turns);
	return turnsLeft;
 
    }
    
    public static int getActionsLeft(int playerTurns) {
		if (playerTurns < 15 || playerTurns > 20) {
			return -1;
                }

		int ActionsLeft = (20 - playerTurns)*3;
		return ActionsLeft;
    }


}
