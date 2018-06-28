/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.forbiddenisland.control;

import citbyui.cit260.model.Game;
import citbyui.cit260.model.Location;
import citbyui.cit260.model.Map;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mcwis
 */
public class MapControl {

    public static Map createMap(Game game, int noOfRows, int noOfColumns) {
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
        int success = assignActorsToLocations(locations);
        if (success < 0) {
            return null;
        }
        success = assignIemsToLocations(locations);
        if (success < 0) {
            return null;
        }
        success = assignTreasuresToLocations(locations);
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
        fireLocation.setDisplaySymbol("^f^");
        unshuffledLocations.add(fireLocation);
        Location waterLocation = new Location();
        waterLocation.setDisplaySymbol("~w~");
        unshuffledLocations.add(waterLocation);
        Location windLocation = new Location();
        windLocation.setDisplaySymbol("{w}");
        unshuffledLocations.add(windLocation);
        Location earthLocation = new Location();
        windLocation.setDisplaySymbol("-e-");
        unshuffledLocations.add(earthLocation);
        try {
            Location fireLocation1 = (Location) fireLocation.clone();
            Location waterLocation1 = (Location) waterLocation.clone();
            Location windLocation1 = (Location) windLocation.clone();
            Location earthLocation1 = (Location) earthLocation.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MapControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                locations[i][j] = new Location();
            }
        }
        
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

    private static int assignActorsToLocations(Location[][] locations) {
        System.out.println("assignActorsToLocations");
        return 1;
    }

    private static int assignIemsToLocations(Location[][] locations) {
        System.out.println("assignIemsToLocations");
        return 1;
    }

    private static int assignTreasuresToLocations(Location[][] locations) {
        System.out.println("assignTreasuresToLocations");
        return 1;
    }
    
}
