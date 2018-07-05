/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.model.Actor;
import citbyui.cit260.model.ActorType;
import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import citbyui.cit260.model.Treasure;
import forbiddenisland.ForbiddenIsland;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class MapControl {

    public static Map createMap(Game game, int noOfRows, int noOfColumns, ArrayList<Actor> actors, Treasure[] treasures) {
        // check for invalid inputs
        if (game == null || noOfRows < 1 || noOfColumns < 1) {
            return null;
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
            return null;
        }

        map.setLocation(locations);

// assign objects to locations
        int success = assignActorsToLocations(locations, actors);
        if (success < 0) {
            return null;
        }
        success = assignTreasuresToLocations(locations, treasures);
        if (success < 0) {
            return null;
        }

        return map;

    }

    private static Location[][] createLocations(int noOfRows, int noOfColumns) {
        Location[][] locations = new Location[noOfRows][noOfColumns];
        System.out.println("createdLocations working");
        if (noOfRows < 1 || noOfColumns < 1) {
            return null;
        }

        ArrayList<Location> unshuffledLocations = new ArrayList<Location>();

        Location fireLocation = new Location();
        fireLocation.setDisplaySymbol("^F^");
        fireLocation.setLocationType("fireLocation");
        unshuffledLocations.add(fireLocation);

        Location waterLocation = new Location();
        waterLocation.setDisplaySymbol("~W~");
        waterLocation.setLocationType("waterLocation");
        unshuffledLocations.add(waterLocation);

        Location windLocation = new Location();
        windLocation.setDisplaySymbol("{W}");
        windLocation.setLocationType("windLocation");
        unshuffledLocations.add(windLocation);

        Location earthLocation = new Location();
        earthLocation.setDisplaySymbol("-E-");
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
        landingPadLocation.setDisplaySymbol(" # ");
        landingPadLocation.setLocationType("landingPad");
        unshuffledLocations.add(landingPadLocation);

        Location playerOneStart = new Location();
        playerOneStart.setDisplaySymbol(" 1 ");
        playerOneStart.setLocationType("startOne");
        unshuffledLocations.add(playerOneStart);

        Location playerTwoStart = new Location();
        playerTwoStart.setDisplaySymbol(" 2 ");
        playerTwoStart.setLocationType("startTwo");
        unshuffledLocations.add(playerTwoStart);

        for (int i = 0; i < 14; i++) {
            Location loc = new Location();
            loc.setDisplaySymbol("...");
            unshuffledLocations.add(loc);
            loc.setLocationType("normal");
        }

        Collections.shuffle(unshuffledLocations);

        int y = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                locations[i][j] = unshuffledLocations.get(y);
                locations[i][j].setRow(i);
                locations[i][j].setColumn(j);
                System.out.println(unshuffledLocations.get(y) + "\n");
                y++;
            }
        }

        /*--------------------------------------------------------------------*/
// // Create a location and assign it to its position in the locations array
// location = create a new location object of the appropriate location datatype
// assign the location object to its row and column position in the locations array
// call setters to assign the row and column number in the location object
// call setter to assign a description in the location object
// call setter to assign a display symbol in the location object
// call setter methods to assign values to other attributes in the location object
//
// // Repeat above steps to create and assign each location to the locations array
// … 
        return locations;
    }

    public static void displayMap() {
        Location[][] locations = ForbiddenIsland.getCurrentGame().getMap().getLocation();
        System.out.println("\n-_-_-GAME MAP-_-_-\n");
        for (int i = 0; i < 5; i++) {
            System.out.print("-----------------------------------------\n");
            for (int j = 0; j < 5; j++) {
                System.out.print("|  " + locations[i][j].getDisplaySymbol() + "  ");
            }
            System.out.print("|\n");
        }
        System.out.print("-----------------------------------------");

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

    private static int assignActorsToLocations(Location[][] locations, ArrayList<Actor> actors) {
        System.out.println("assignActorsToLocations");
        // Check for invalid input
        if (locations == null) {
            return -1;
        }
        Location pilotLocation = MapControl.findLocation(locations, "startOne");
        if (pilotLocation == null) {
            return -1;
        }
        Actor pilot = actors.get(ActorType.Pilot.ordinal());
        pilotLocation.getActors().add(pilot);
        pilot.getCoordinates().x = pilotLocation.getRow();
        pilot.getCoordinates().y = pilotLocation.getColumn();

        Location explorerLocation = MapControl.findLocation(locations, "startTwo");
        if (explorerLocation == null) {
            return -1;
        }
        Actor explorer = actors.get(ActorType.Explorer.ordinal());
        explorerLocation.getActors().add(explorer);
        explorer.getCoordinates().x = explorerLocation.getRow();
        explorer.getCoordinates().y = explorerLocation.getColumn();

        return 1;
    }

    private static int assignTreasuresToLocations(Location[][] locations, Treasure[] treasures) {
        System.out.println("assignTreasuresToLocations");
        // Check for invalid input
        if (locations == null) {
            return -1;
        }
        Location fireLocation = MapControl.findLocation(locations, "fireLocation");
        if (fireLocation == null) {
            return -1;
        }
        Treasure fireTreasure = treasures[2];
        fireTreasure.getName();
        fireTreasure.getDescription();
        fireTreasure.getStatus();
        //  fireLocation.getTreasures().add(fireTreasure);

        return 1;
    }

}
