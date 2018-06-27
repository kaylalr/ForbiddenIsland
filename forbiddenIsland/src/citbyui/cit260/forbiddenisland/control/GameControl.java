/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.model.Game;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Treasure;
import forbiddenisland.ForbiddenIsland;
import java.awt.Point;
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
//        
//        ArrayList<Player> players = new ArrayList<Player>();
//        ArrayList<Actor> actors = new ArrayList<Actor>();
        
        if(player == null){
            return -1;
        }
        
        Game game = new Game();
        
        game.setPlayer(player);
        
        ForbiddenIsland.setCurrentGame(game); 
        
        
        //ITEMS
        ArrayList<Actor> actors = createActors();
        player.setActors(actors);
        
        //Creat all other list (questions)
        
        Treasure[] treasure = createTreasure();
        
        
        
        return 1;
    }

    public static ArrayList<Actor> createActors() {
        ArrayList<Actor> actor = new ArrayList<Actor>();
        
        actor.add(new Actor("Pilot", new Point(0,0) , "Helicopter"));
        actor.add(new Actor ("Explorer", new Point(0,0) , "Diagonal Movements"));
          
        return actor;
    }

    private static Treasure[] createTreasure() {
        Treasure[] treasure = new Treasure[4];
//        treasure("Earth Stone", "Earth Description", "Uncaptured");
//        treasure("Statue of the Wind", "Wind Discription", "uncaptured");
//        treasure("Crytal of Fire", "Fire Decription", "Uncaptured");
//        treasure("Oceans Chalice", "Ocean Description", "uncaptured");
//          treasure.setName("Earth Stone");
        return treasure;
    }


}
