/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.forbiddenisland.exceptions.MapControlException;
import citbyui.cit260.forbiddenisland.view.MoveMenuView;
import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Treasure;
import forbiddenisland.ForbiddenIsland;
import citbyui.cit260.model.TreasureType;
//import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class MapControl {

    public static Map createMap(Game game, int noOfRows, int noOfColumns, ArrayList<Actor> actors, Treasure[] treasures) throws MapControlException {
        // check for invalid inputs
        if (game == null || noOfRows < 1 || noOfColumns < 1) {

            throw new MapControlException("Game cant be NULL or less than 1 Row / 1Column");
        }
        // create the map object and assign values to it
        Map map = new Map();
        map.setDescription("Map Description");
        map.setRowCount(5);
        map.setColumnCount(5);

        game.setMap(map);

// create a two-dimensional array of locations and assign array to the map
        // initially create stub method
        Location[][] locations = createLocations(noOfRows, noOfColumns);
        if (locations == null) {
            throw new MapControlException("Location can't be NULL.");
        }

        map.setLocation(locations);

// assign objects to locations
        int success = assignActorsToLocations(locations, actors);
        if (success < 0) {
            throw new MapControlException("Assign actors to location can't return NULL/ Failed.");
        }
        success = assignTreasuresToLocations(locations, treasures);
        if (success < 0) {
            throw new MapControlException("Assign Treasures to location can't return NULL/ Failed.");
        }

        return map;

    }

    private static Location[][] createLocations(int noOfRows, int noOfColumns) throws MapControlException {
        Location[][] locations = new Location[noOfRows][noOfColumns];
        if (noOfRows < 1 || noOfColumns < 1) {
            throw new MapControlException("Rows and Columns must be more than one 1 in size.");
        }

        ArrayList<Location> unshuffledLocations = new ArrayList<Location>();

        Location fireLocation = new Location();
        fireLocation.setDisplaySymbol("F");
        fireLocation.setLocationType("fireLocation");
        unshuffledLocations.add(fireLocation);

        Location waterLocation = new Location();
        waterLocation.setDisplaySymbol("W");
        waterLocation.setLocationType("waterLocation");
        unshuffledLocations.add(waterLocation);

        Location windLocation = new Location();
        windLocation.setDisplaySymbol("A");
        windLocation.setLocationType("windLocation");
        unshuffledLocations.add(windLocation);

        Location earthLocation = new Location();
        earthLocation.setDisplaySymbol("E");
        earthLocation.setLocationType("earthLocation");
        unshuffledLocations.add(earthLocation);

        try {
            Location fireLocation1 = (Location) fireLocation.clone();
            unshuffledLocations.add(fireLocation1);
            Location waterLocation1 = (Location) waterLocation.clone();
            unshuffledLocations.add(waterLocation1);
            Location windLocation1 = (Location) windLocation.clone();
            unshuffledLocations.add(windLocation1);
            Location earthLocation1 = (Location) earthLocation.clone();
            unshuffledLocations.add(earthLocation1);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MapControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        Location landingPadLocation = new Location();
        landingPadLocation.setDisplaySymbol("#");
        landingPadLocation.setLocationType("landingPad");
        unshuffledLocations.add(landingPadLocation);

        Location playerOneStart = new Location();
        playerOneStart.setDisplaySymbol(" ");
        playerOneStart.setLocationType("startOne");
        unshuffledLocations.add(playerOneStart);

        Location playerTwoStart = new Location();
        playerTwoStart.setDisplaySymbol(" ");
        playerTwoStart.setLocationType("startTwo");
        unshuffledLocations.add(playerTwoStart);

        for (int i = 0; i < 14; i++) {
            Location loc = new Location();
            loc.setDisplaySymbol(" ");
            unshuffledLocations.add(loc);
            loc.setLocationType("normal");
        }
        Collections.shuffle(unshuffledLocations);
        
//        int randomFloodRow = 0;
//        int randomFloodCol = 0;
//        
//        do {
//            randomFloodRow = (int)Math.ceil(Math.random()*5);
//        } while (randomFloodRow < 6);
//        do {
//            randomFloodCol = (int)Math.ceil(Math.random()*5);
//        } while (randomFloodCol < 6);

        int randomFloodRow = (int)Math.ceil(Math.random()*5);
        int randomFloodCol = (int)Math.ceil(Math.random()*5);
        

        System.out.println("Flooded Tile: " + randomFloodRow + ", " + randomFloodCol);

        //THIS CREATES THE ALLOCATED LOCATION SPACES AND GIVES THEM THEIR VALUES.
        int y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                locations[i][j] = unshuffledLocations.get(y);
                locations[i][j].setRow(i);
                locations[i][j].setColumn(j);
                y++;
            }
        }
        
        return locations;
    }

    //THIS HAS A SIMILAR EQUATION AS THE LOCATION ALLOCATION BUT THIS REFERENCES IT AND DISPLAYS THE MAP WITH THE DISPLAY SYMBOLS
    public static void displayMap() {
        ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        Actor actor = currActors.get(0);
        System.out.println("\nCurrent Actors Name: " + actor.getName());
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
       // ArrayList<Actor> currActors = ForbiddenIsland.getPlayer().getActors();
        //Actor actor = currActors.get(0);
        Actor pilot = currActors.get(ActorType.Pilot.ordinal());
        Actor explorer = currActors.get(ActorType.Explorer.ordinal());
       
        System.out.println("\n-_-_-GAME MAP-_-_-\n");
        System.out.println("       1       2       3       4       5");
        int t = 1;
        for (int i = 0; i < 5; i++) {
            System.out.print("   -----------------------------------------\n");
            System.out.print(t + "  ");
            t++;
            for (int j = 0; j < 5; j++) {
                if(pilot.getCoordinates().x == i && pilot.getCoordinates().y == j){
                        System.out.print("| 1 " + locations[i][j].getDisplaySymbol());
                }
                else{
                    System.out.print("|   " + locations[i][j].getDisplaySymbol());
                }
                if(explorer.getCoordinates().x == i && explorer.getCoordinates().y == j){
                    System.out.print(" 2 ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print("   -----------------------------------------");
        System.out.println("\n" + currActors);
    }

    private static Location findLocation(Location[][] locations, String locationType) {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                if (locations[i][j].getLocationType().equals(locationType)) {
                    return locations[i][j];
                }
            }
        }
        return null;
    }

    private static int assignActorsToLocations(Location[][] locations, ArrayList<Actor> actors) throws MapControlException {
        // Check for invalid input
        if (locations == null) {
            throw new MapControlException("Locations can't be NULL.");
        }
        Location pilotLocation = MapControl.findLocation(locations, "startOne");
        if (pilotLocation == null) {
            throw new MapControlException("Pilot can't be NULL");
        }
        Actor pilot = actors.get(ActorType.Pilot.ordinal());
        //pilotLocation.getActors().add(pilot);
        pilotLocation.setActor(pilot);
        pilot.getCoordinates().x = pilotLocation.getRow();
        pilot.getCoordinates().y = pilotLocation.getColumn();

        Location explorerLocation = MapControl.findLocation(locations, "startTwo");
        if (explorerLocation == null) {
            throw new MapControlException("Explorer Location can't be NULL.");
        }
        Actor explorer = actors.get(ActorType.Explorer.ordinal());
        //explorerLocation.getActors().add(explorer);
        explorerLocation.setActor(explorer);
        explorer.getCoordinates().x = explorerLocation.getRow();
        explorer.getCoordinates().y = explorerLocation.getColumn();
        
        
        return 1;
    }

    private static int assignTreasuresToLocations(Location[][] locations, Treasure[] treasures) throws MapControlException {
        // Check for invalid input
        if (locations == null) {
            throw new MapControlException("Locations can't be NULL.");

        }

        //Treasure treasure = null;
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                switch (locations[i][j].getLocationType()) {
                    case "earthLocation":
                        locations[i][j].setTreasure(treasures[TreasureType.Earth.ordinal()]);
                        break;
                    case "fireLocation":
                        locations[i][j].setTreasure(treasures[TreasureType.Fire.ordinal()]);
                        break;
                    case "waterLocation":
                        locations[i][j].setTreasure(treasures[TreasureType.Water.ordinal()]);
                        break;
                    case "windLocation":
                        locations[i][j].setTreasure(treasures[TreasureType.Wind.ordinal()]);
                        break;
                    default:
                        locations[i][j].setTreasure(treasures[TreasureType.Empty.ordinal()]);
                }

            }
        }

        Treasure fireTreasure = treasures[2];
        fireTreasure.getName();
        fireTreasure.getDescription();
        fireTreasure.getStatus();
        //  fireLocation.getTreasures().add(fireTreasure);

        return 1;

    }

    public static Location moveActor(Actor actor, int newRow, int newColumn) throws MapControlException {

        if (actor == null) {
            throw new MapControlException("Actor can't be NULL.");
        }
        
        int currTurns = actor.getTurns();
            if (currTurns > 3) {
                //System.out.println("\nSorry, you have no turns left.\nPlease end your turn.\n");
                throw new MapControlException("\nSorry, you have no turns left.\nPlease end your turn.\n");
            }

        Location locs[][] = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        if (newRow < 0 || newRow > 4 || newColumn < 0 || newColumn > 4) {
            throw new MapControlException("NewRow and NewColumn must be within 1-5.");
        }

        int currentRow = actor.getCoordinates().x;
        int currentColumn = actor.getCoordinates().y;
        Location oldLocation = ForbiddenIsland.getCurrentGame().getMap().getLocation()[currentRow][currentColumn];
        Location newLocation = ForbiddenIsland.getCurrentGame().getMap().getLocation()[newRow][newColumn];

        oldLocation.setActor(null);
        newLocation.setActor(actor);
        actor.getCoordinates().x = newLocation.getRow();
        actor.getCoordinates().y = newLocation.getColumn();
        
        

        System.out.println(actor.getCoordinates());
        System.out.println(oldLocation);
        System.out.println(newLocation);
        
        if (currTurns < 4) {
                int newTurns = currTurns++;
                actor.setTurns(newTurns);
            }

        return newLocation;

    }
}
