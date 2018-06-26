/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.model.Game;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.Actor;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;

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

    public static Player savePlayer(String playerName) {
        
        if (playerName == null || playerName.length() < 1){
            return null;
        }
        
        Player player = new Player();
        ForbiddenIsland.setPlayer(player);
        
        return new Player();
    }

    public static int createNewGame(Player player) {
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        
        
        
        if(player == null){
            return -1;
        }
        
        Game game = new Game();
        
        game.setPlayer(player);
        
        ForbiddenIsland.setCurrentGame(game); 
        player.setActors(actors);
        
        
        
        
        return 1;
    }


}
