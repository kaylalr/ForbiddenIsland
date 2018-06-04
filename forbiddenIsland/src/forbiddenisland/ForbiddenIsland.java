/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forbiddenisland;
import citbyui.cit260.forbiddenisland.view.StartProgramView;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.Card;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Player;
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
        
        Actor actor = new Actor("Jimmy Dude", 0.3, "Special Ability");        
        System.out.println(actor.toString());
        
        
        /***************************************
         * This is calling on the Element class
         */
        // This works, but I don't know if it's how Brother Jackson wants us to do it.
        for (Card c: Card.values()) {
            System.out.println(c);
        }
//        System.out.println(Card.earth.getCardType());
//        System.out.println(Card.earth.getDescription());
//        System.out.println(Card.fire.getCardType());
//        System.out.println(Card.fire.getDescription());
//        System.out.println(Card.water.getCardType());
//        System.out.println(Card.water.getDescription());
//        System.out.println(Card.wind.getCardType());
//        System.out.println(Card.wind.getDescription()); 
//        System.out.println(Card.unfloodTile.getCardType());
//        System.out.println(Card.unfloodTile.getDescription());         
//        System.out.println(Card.helicopter.getCardType());
//        System.out.println(Card.helicopter.getDescription()); 
        /****************************************
         * This is calling on the game class
         */
        Game game = new Game(0.0, 7.0);        
        System.out.println(game.toString());
        
        /*****************************************
         *  This calls on the Location Class
         */
        
        Location location = new Location(1.1, 7.0, 1, 7, "Symbol");        
        System.out.println(location.toString());
        
        /***************************************
         * This is calling on the Map class
         */
        
        Map map = new Map(1.1, 7.0, "description");
        System.out.println(map.toString());
        
        /***************************************
         * This is calling for the player class
         */
        Player playerOne = new Player("Billy Bob", 7.00);      
        System.out.println(playerOne.toString());
        
        
        /****************************************
         * This is calling on the Tresure Class
         */
        Treasure treasure = new Treasure("Place", "Desc", "Stat");
        System.out.println( treasure.toString());   
        
        
        StartProgramView programView = new StartProgramView();
        programView.displayStartProgramView();
            
    }
    
}
