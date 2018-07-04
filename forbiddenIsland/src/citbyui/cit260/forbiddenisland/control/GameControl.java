/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import static citbyui.cit260.forbiddenisland.control.MapControl.createMap;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Treasure;
import citbyui.cit260.model.TreasureType;
import forbiddenisland.ForbiddenIsland;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author mcwis
 */
public class GameControl {

    public static int getTurnsLeft(int player1Turns, int player2Turns) {
        if (player1Turns < 0 || player1Turns > 20) {
            return -1;
        }

        if (player2Turns < 0 || player2Turns > 20) {
            return -1;
        }
        int turnsLeft = 40 - (player1Turns + player2Turns);
        return turnsLeft;

    }

    public static int getActionsLeft(int playerTurns) {
        if (playerTurns < 15 || playerTurns > 20) {
            return -1;
        }

        int ActionsLeft = (20 - playerTurns) * 3;
        return ActionsLeft;
    }

    public static Player savePlayer(String playerName) {

        if (playerName == null || playerName.length() < 1) {
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

        if (player == null) {
            return -1;
        }

        Game game = new Game();

        game.setPlayer(player);

        ForbiddenIsland.setCurrentGame(game);

        //ITEMS
        ArrayList<Actor> actors = createActors();
        player.setActors(actors);

        //Creat all other list (questions)
        Treasure[] treasures = createTreasure();
        
        Map map = createMap(game, 5, 5, actors, treasures);
        if (map == null) {
            return -2;
        }
        game.setMap(map);

        return 1;
    }

    public static ArrayList<Actor> createActors() {
        ArrayList<Actor> actor = new ArrayList<Actor>();

        actor.add(ActorType.Pilot.ordinal(),new Actor("Pilot", new Point(0, 0), "Helicopter"));
        actor.add(ActorType.Explorer.ordinal(),new Actor("Explorer", new Point(0, 0), "Diagonal Movements"));

        return actor;
    }

    private static Treasure[] createTreasure() {
        Treasure[] treasures = new Treasure[TreasureType.values().length];
        // create earth treasure
        Treasure earthTreasure = new Treasure();
        earthTreasure.setName("Earth Stone");
        earthTreasure.setDescription("Earth Description");
        earthTreasure.setStatus("Uncaputred");
        treasures[TreasureType.Earth.ordinal()] = earthTreasure;
        // create wind treasure
        Treasure windTreasure = new Treasure();
        windTreasure.setName("Statue of the Wind");
        windTreasure.setDescription("Wind Description");
        windTreasure.setStatus("Uncaputred");
        treasures[TreasureType.Wind.ordinal()] = windTreasure;
        // create fire treasure
        Treasure fireTreasure = new Treasure();
        fireTreasure.setName("Crystal of Fire");
        fireTreasure.setDescription("Fire Description");
        fireTreasure.setStatus("Uncaputred");
        treasures[TreasureType.Fire.ordinal()] = fireTreasure;
        // create water treasure
        Treasure waterTreasure = new Treasure();
        waterTreasure.setName("Ocean's Chalice");
        waterTreasure.setDescription("Water Description");
        waterTreasure.setStatus("Uncaputred");
        treasures[TreasureType.Water.ordinal()] = waterTreasure;
        
        // create water treasure
        Treasure emptyTreasure = new Treasure();
        emptyTreasure.setName("Empty");
        emptyTreasure.setDescription("No Treasure here");
        emptyTreasure.setStatus("Cannot capture");
        treasures[TreasureType.Empty.ordinal()] = emptyTreasure;

        return treasures;
    }
    
    }
