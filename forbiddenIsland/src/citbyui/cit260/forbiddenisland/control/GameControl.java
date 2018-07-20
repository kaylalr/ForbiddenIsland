/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import static citbyui.cit260.forbiddenisland.control.MapControl.createMap;
import citbyui.cit260.forbiddenisland.exceptions.GameControlException;
import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Player;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Card;
import citbyui.cit260.model.CardType;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Treasure;
import citbyui.cit260.model.TreasureType;
import forbiddenisland.ForbiddenIsland;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class GameControl {

    public static int getTurnsLeft(int player1Turns, int player2Turns) throws GameControlException {
        if (player1Turns < 0 || player1Turns > 20) {
            throw new GameControlException("Turns left needs to be between 0 and 20");
        }

        if (player2Turns < 0 || player2Turns > 20) {
            throw new GameControlException("Turns left needs to be between 0 and 20");
        }
        int turnsLeft = 40 - (player1Turns + player2Turns);
        return turnsLeft;

    }

    public static int getActionsLeft(int playerTurns) throws GameControlException {
        if (playerTurns < 15 || playerTurns > 20) {
            throw new GameControlException("Player turns needs to be between 15 and 20.");
        }

        int ActionsLeft = (20 - playerTurns) * 3;
        return ActionsLeft;
    }

    public static Player savePlayer(String playerName) throws GameControlException {

        if (playerName == null || playerName.length() < 1) {
            throw new GameControlException("Name cant be NULL");
        }

        Player player = new Player();
        ForbiddenIsland.setPlayer(player);

        return new Player();
    }

    public static int createNewGame(Player player) throws GameControlException, MapControlException {
//        
//        ArrayList<Player> players = new ArrayList<Player>();
//        ArrayList<Actor> actors = new ArrayList<Actor>();

        if (player == null) {
            throw new GameControlException("Player cant be NULL");
        }

        Game game = new Game();

        game.setPlayer(player);
        game.setTurns(0);

        ForbiddenIsland.setCurrentGame(game);

        //ITEMS
        ArrayList<Actor> actors = createActors();
        player.setActors(actors);

        //Creat all other list (questions)
        Treasure[] treasures = createTreasure();

        Map map = createMap(game, 5, 5, actors, treasures);
        if (map == null) {
            throw new GameControlException("Map cant be NULL");
        }
        game.setMap(map);
        
        GameControl.makeCards();
                
        return 1;
    }

    public static ArrayList<Actor> createActors() {
        ArrayList<Actor> actor = new ArrayList<Actor>();

        actor.add(ActorType.Pilot.ordinal(), new Actor("Pilot", new Point(0, 0), "Helicopter"));
        actor.add(ActorType.Explorer.ordinal(), new Actor("Explorer", new Point(0, 0), "Diagonal Movements"));

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

    public static boolean endTurn() {
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor1 = currActors.get(0);
        Actor actor2 = currActors.get(1);
        int incTurns = actor1.getTurns();
        int currTotalTurns = (int)ForbiddenIsland.getCurrentGame().getTurns();
        ForbiddenIsland.getCurrentGame().setTurns(incTurns+currTotalTurns);
        
        ArrayList<Actor> currentActors = ForbiddenIsland.getPlayer().getActors();
        Actor actorOne = currActors.get(0);
        //Actor actorTwo = currActors.get(1);
        if (actorOne.getName().equals("Pilot")){
            ForbiddenIsland.getPlayer().getActors().get(0).setTurns(20 - incTurns);
            System.out.println("PLAYER ONE TURNS LEFT: " +ForbiddenIsland.getPlayer().getActors().get(0).getTurns());
        }
        if (actorOne.getName().equals("Explorer")){
            ForbiddenIsland.getPlayer().getActors().get(0).setTurns(20 - incTurns);
            System.out.println("PLAYER TWO TURNS LEFT: " +ForbiddenIsland.getPlayer().getActors().get(0).getTurns());
        }
        ArrayList<Actor> newActors = new ArrayList();
        newActors.add(0, actor2);
        newActors.add(1, actor1);
        ForbiddenIsland.getPlayer().setActors(newActors);
        newActors.get(0).setTurns(0);
        //System.out.println("You have used " + ForbiddenIsland.getCurrentGame().getTurns()); 
        
        
        //ForbiddenIsland.getPlayer().getActors().get(0).setTurns(20 - incTurns);
        //ForbiddenIsland.getPlayer().getActors().get(1).setTurns();
        //System.out.println("PLAYER ONE TURNS LEFT: " +ForbiddenIsland.getPlayer().getActors().get(0).getTurns());
        
       // Map floodedMap = ForbiddenIsland.getCurrentGame().getMap().getFloodLocations();
        //Map floodedMap = 
       // Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        
        MapControl.floodTiles();
        return true;
    }

    public static void saveGame(Game game, String filePath) throws GameControlException, FileNotFoundException, IOException {
        System.out.println("--- saveGame() in gameControl class ---");

        if (game == null || filePath == null) {
            if (game == null) {
                throw new GameControlException("Game cant be Null");
            }
            if (filePath == null) {
                throw new GameControlException("filePath cant be Null");
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fos);
            output.writeObject(game);
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
//        FileOutputStream filePath = new FileOutputStream(); 
//        ObjectOutputStream objectStream = new FileOutputStream;

    }

    public static void printTreasureLocations(Location[][] locations, String filePath) throws GameControlException, FileNotFoundException, IOException {
        FileWriter outFile = null;

        if (locations == null || filePath == null) {
            if (locations == null) {
                throw new GameControlException("Game cant be Null");
            }
            if (filePath == null) {
                throw new GameControlException("filePath cant be Null");
            }
        }

//                    try (FileWriter fw = new FileWriter(filePath)) {
//                        ObjectOutputStream output = new ObjectOutputStream(fw);
//                        int a = i+1;
//                        int b = j+1;
//                        output.writeObject(a + ", " + b);
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n   Treasure Location Report            ");
            out.printf("%n%-20s%10s", "Treasure Type", "Location\n");
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {

                    //if (locations[i][j].getTreasure() != locations[i][j].getTreasure(TreasureType.Empty.ordinal()) {
                    //if (locations[i][j].getTreasure(TreasureType.Empty.ordinal())) {
                    if (!locations[i][j].getTreasure().getName().equals("Empty")) {
                        outFile = new FileWriter(filePath);
                        int a = i + 1;
                        int b = j + 1;
                        outFile.write(a + ", " + b + "\n");
                        out.printf("%n%-20s%10s", locations[i][j].getTreasure().getName(), a + ", " + b);
                        //out.printf("%n%-20s%6d", locations[i][j].getTreasure(), a + ", " + b);
                    }
                }
            }
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
//        FileOutputStream filePath = new FileOutputStream(); 
//        ObjectOutputStream objectStream = new FileOutputStream;

    }

    public static void printTreasureStatus(Location[][] locations, String filePath) throws GameControlException, FileNotFoundException, IOException {
        FileWriter outFile = null;

        if (locations == null || filePath == null) {
            if (locations == null) {
                throw new GameControlException("Game cant be Null");
            }
            if (filePath == null) {
                throw new GameControlException("filePath cant be Null");
            }
        }

//                    try (FileWriter fw = new FileWriter(filePath)) {
//                        ObjectOutputStream output = new ObjectOutputStream(fw);
//                        int a = i+1;
//                        int b = j+1;
//                        output.writeObject(a + ", " + b);
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n   Treasure Location Report            ");
            out.printf("%n%-20s%10s", "Treasure Type", "Status");
            out.printf("%n%-20s%10s", "-------------", "------");
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {

                    //if (locations[i][j].getTreasure() != locations[i][j].getTreasure(TreasureType.Empty.ordinal()) {
                    //if (locations[i][j].getTreasure(TreasureType.Empty.ordinal())) {
                    if (!locations[i][j].getTreasure().getName().equals("Empty")) {
                        outFile = new FileWriter(filePath);
                        out.printf("%n%-20s%10s", locations[i][j].getTreasure().getName(), locations[i][j].getTreasure().getStatus());
                        //out.printf("%n%-20s%6d", locations[i][j].getTreasure(), a + ", " + b);
                    }
                }
            }
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
//        FileOutputStream filePath = new FileOutputStream(); 
//        ObjectOutputStream objectStream = new FileOutputStream;

    }

    public static Game getGame(String filePath) throws GameControlException, IOException {
        System.out.println("--- getGame in control class ---");
        if (filePath == null) {
            throw new GameControlException("Game cannot be null");
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {
            Game game = (Game) input.readObject();
            ForbiddenIsland.setCurrentGame(game);
            ForbiddenIsland.setPlayer(game.getPlayer());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameControl.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(GameControl.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GameControl.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

        try (FileInputStream fos = new FileInputStream(filePath)) {

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameControl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        //output.writeObject(game);
        return null;

    }

    public static ArrayList<Card> makeCards() {
        
        Card[] allCards = new Card[30];
        ArrayList<Card> cards = new ArrayList();
        
        
        Card earth = new Card();
        earth.setDescription(CardType.earth.getDescription());
        earth.setName(CardType.earth.getCardName());
        earth.setType(CardType.earth.getCardType());
        earth.setHand(1);
        cards.add(earth);
            try {
                Card earth1 = (Card) earth.clone();
                Card earth2 = (Card) earth.clone();
                Card earth3 = (Card) earth.clone();
                Card earth4 = (Card) earth.clone();
                cards.add(earth1);
                cards.add(earth2);
                cards.add(earth3);
                cards.add(earth4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Card fire = new Card();
        fire.setDescription(CardType.fire.getDescription());
        fire.setName(CardType.fire.getCardName());
        fire.setType(CardType.fire.getCardType());
        fire.setHand(1);
        cards.add(fire);
            try {
                Card fire1 = (Card) fire.clone();
                Card fire2 = (Card) fire.clone();
                Card fire3 = (Card) fire.clone();
                Card fire4 = (Card) fire.clone();
                cards.add(fire1);
                cards.add(fire2);
                cards.add(fire3);
                cards.add(fire4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Card water = new Card();
        water.setDescription(CardType.water.getDescription());
        water.setName(CardType.water.getCardName());
        water.setType(CardType.water.getCardType());
        water.setHand(1);
        cards.add(water);
            try {
                Card water1 = (Card) water.clone();
                Card water2 = (Card) water.clone();
                Card water3 = (Card) water.clone();
                Card water4 = (Card) water.clone();
                cards.add(water1);
                cards.add(water2);
                cards.add(water3);
                cards.add(water4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Card wind = new Card();
        wind.setDescription(CardType.wind.getDescription());
        wind.setName(CardType.wind.getCardName());
        wind.setType(CardType.wind.getCardType());
        wind.setHand(1);
        cards.add(wind);
            try {
                Card wind1 = (Card) wind.clone();
                Card wind2 = (Card) wind.clone();
                Card wind3 = (Card) wind.clone();
                Card wind4 = (Card) wind.clone();
                cards.add(wind1);
                cards.add(wind2);
                cards.add(wind3);
                cards.add(wind4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Card unfloodTile = new Card();
        unfloodTile.setDescription(CardType.unfloodTile.getDescription());
        unfloodTile.setName(CardType.unfloodTile.getCardName());
        unfloodTile.setType(CardType.unfloodTile.getCardType());
        unfloodTile.setHand(1);
        cards.add(unfloodTile);
            try {
                Card unfloodTile1 = (Card) unfloodTile.clone();
                Card unfloodTile2 = (Card) unfloodTile.clone();
                Card unfloodTile3 = (Card) unfloodTile.clone();
                Card unfloodTile4 = (Card) unfloodTile.clone();
                cards.add(unfloodTile1);
                cards.add(unfloodTile2);
                cards.add(unfloodTile3);
                cards.add(unfloodTile4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Card helicopter = new Card();
        helicopter.setDescription(CardType.helicopter.getDescription());
        helicopter.setName(CardType.helicopter.getCardName());
        helicopter.setType(CardType.helicopter.getCardType());
        helicopter.setHand(1);
        cards.add(helicopter);
            try {
                Card helicopter1 = (Card) helicopter.clone();
                Card helicopter2 = (Card) helicopter.clone();
                Card helicopter3 = (Card) helicopter.clone();
                Card helicopter4 = (Card) helicopter.clone();
                cards.add(helicopter1);
                cards.add(helicopter2);
                cards.add(helicopter3);
                cards.add(helicopter4);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Collections.shuffle(cards);
        
        int y = 0;
        for (int i = 0; i<30; i++) {
            allCards[i] = cards.get(y);
            y++;
        }
        
        setActorsCards(cards);
            
        return cards;
        
    }

    private static void setActorsCards(ArrayList<Card> cards) {
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actorOne = currActors.get(0);
        Actor actorTwo = currActors.get(1);
        ArrayList<Card> actorOneCards = new ArrayList();
        int y = 0;
        for (int i = 0; i < 15; i++) {
            actorOneCards.add(cards.get(y));
            y++;
        }
        actorOne.setCards(actorOneCards);
        ArrayList<Card> actorTwoCards = new ArrayList();
        for (int i = 0; i < 15; i++) {
            actorTwoCards.add(cards.get(y));
            y++;
        }
        actorTwo.setCards(actorTwoCards);
        System.out.println(actorOne.getCards());
        System.out.println(actorTwo.getCards());
    }
    
    private static void useCard() {
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor currActor = currActors.get(0);
        
    }
}
