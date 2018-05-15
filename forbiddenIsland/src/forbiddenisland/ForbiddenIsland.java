/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forbiddenisland;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Element;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.SpecialAction;
import citbyui.cit260.model.Treasure;
import citbyui.cit260.model.TreasureLocation;
/**
 *
 * @author mcwis
 */
public class ForbiddenIsland {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        /****************************************
         * This is calling on the Actor Class
         */
        
        Actor actor = new Actor();
        actor.setName("Jimmy Dude");
        actor.setCoordinates(0.0);
        
        String actorName  = actor.getName();
        double actorCoordinates = actor.getCoordinates();
        
        System.out.println("Name = " + actorName + ", Coordinates = " + actorCoordinates);
        
        
        /***************************************
         * This is calling on the Element class
         */
        System.out.println(Element.earth.getElement());
        System.out.println(Element.fire.getElement());
        System.out.println(Element.water.getElement());
        System.out.println(Element.wind.getElement());

        /****************************************
         * This is calling on the game class
         */
        Game game = new Game();
        game.setTurns(0.0);
        game.setScore(7.0);
      
        double gameTurns = game.getTurns();
        double gameScore = game.getScore();
        
        System.out.println( "Turns = " + gameTurns + ", Score = " + gameScore);
        
        /*****************************************
         *  This calls on the Location Class
         */
        
        Location location = new Location();
        location.setRow(1.1);
        location.setColumn(7.0);
        
        location.setFlooded(1);
        location.setSunken(7); 
        
        location.setDisplaySymbol("string");
        
        double locationRow = location.getRow();
        double locationColumn = location.getColumn();
        int locationFlooded = location.getFlooded();
        int locationSunken = location.getSunken();
        String locationDisplaySymbol = location.getDisplaySymbol();
        
        System.out.println( "Row = " + locationRow + ", Column = " + locationColumn + ", Flooded = " + locationFlooded + ", Sunken = " + locationSunken + ", Display Symbol = " + locationDisplaySymbol);
        
        /***************************************
         * This is calling on the Map class
         */
        
        Map map = new Map();
        map.setRowCount(1.1);
        map.setColumnCount(7.0);
        
        map.setDescription("descriptionn");

        double mapRowCount = map.getRowCount();
        double mapColumnCount = map.getColumnCount();
        String mapDescription = map.getDescription();
        
        System.out.println( "Row Count = " + mapRowCount + ", Column Count = " + mapColumnCount + ", Description = " + mapDescription);
        
        /***************************************
         * This is calling for the player class
         */
        Player playerOne = new Player();
        playerOne.setName("Billy Bob");
        playerOne.setBestScore(7.0);
      
        String playerOneName = playerOne.getName();
        double playerOneBestScore = playerOne.getBestScore();
        
        System.out.println( "Name = " + playerOneName + ", Best Score = " + playerOneBestScore);
        
        /****************************************
         * Calling on the spacial action class
         */

        System.out.println(SpecialAction.unfloodTile.getspecialAction());
        System.out.println(SpecialAction.helicopter.getspecialAction());
        
        /****************************************
         * This is calling on the Tresure Class
         */
        Treasure treasure = new Treasure();
        treasure.setName("Place");
        treasure.setDescription("Desc");
        treasure.setStatus("Stat");

        String treasureName = treasure.getName();
        String treasureDescription = treasure.getDescription();
        String treasureStatus = treasure.getStatus();
        
        System.out.println( "Name = " + treasureName + ", Description = " + treasureDescription + ", Status = " + treasureStatus);       
        
    }
    
}
