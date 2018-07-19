/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author mcwis
 */
public class Map implements Serializable {

    private double rowCount;
    private double columnCount;
    private String description;
    private ArrayList<Game> games = new ArrayList<Game>();
    private ArrayList<Location> floodLocations = new ArrayList<Location>();
    private int positionInFLoodedLocations;
    private Location location[][];
    

    public Map() {
    }

    public Map(double rowCount, double columnCount, String description) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.description = description;
    }

    public double getRowCount() {
        return rowCount;
    }

    public void setRowCount(double rowCount) {
        this.rowCount = rowCount;
    }

    public double getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(double columnCount) {
        this.columnCount = columnCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public Location[][] getLocation() {
        return location;
    }

    public void setLocation(Location[][] location) {
        this.location = location;
    }

    public ArrayList<Location> getFloodLocations() {
        return floodLocations;
    }

    public void setFloodLocations(ArrayList<Location> floodLocations) {
        this.floodLocations = floodLocations;
    }

    public int getPositionInFLoodedLocations() {
        return positionInFLoodedLocations;
    }

    public void setPositionInFLoodedLocations(int positionInFLoodedLocations) {
        this.positionInFLoodedLocations = positionInFLoodedLocations;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.rowCount) ^ (Double.doubleToLongBits(this.rowCount) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.columnCount) ^ (Double.doubleToLongBits(this.columnCount) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.games);
        hash = 29 * hash + Objects.hashCode(this.floodLocations);
        hash = 29 * hash + this.positionInFLoodedLocations;
        hash = 29 * hash + Arrays.deepHashCode(this.location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (Double.doubleToLongBits(this.rowCount) != Double.doubleToLongBits(other.rowCount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.columnCount) != Double.doubleToLongBits(other.columnCount)) {
            return false;
        }
        if (this.positionInFLoodedLocations != other.positionInFLoodedLocations) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.games, other.games)) {
            return false;
        }
        if (!Objects.equals(this.floodLocations, other.floodLocations)) {
            return false;
        }
        if (!Arrays.deepEquals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", description=" + description + ", games=" + games + ", floodLocations=" + floodLocations + ", positionInFLoodedLocations=" + positionInFLoodedLocations + ", location=" + location + '}';
    }
}
