/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.lang.Cloneable;

/**
 *
 * @author mcwis
 */
public class Location implements Serializable, Cloneable {

    private int row;
    private int column;
    private int flooded;
    private int sunken;
    private String displaySymbol;
    private String locationType;
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    private Treasure treasure;

    public Location() {
    }

    public Location(int row, int column, int flooded, int sunken, String displaySymbol) {
        this.row = row;
        this.column = column;
        this.flooded = flooded;
        this.sunken = sunken;
        this.displaySymbol = displaySymbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getFlooded() {
        return flooded;
    }

    public void setFlooded(int flooded) {
        this.flooded = flooded;
    }

    public int getSunken() {
        return sunken;
    }

    public void setSunken(int sunken) {
        this.sunken = sunken;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.row;
        hash = 11 * hash + this.column;
        hash = 11 * hash + this.flooded;
        hash = 11 * hash + this.sunken;
        hash = 11 * hash + Objects.hashCode(this.displaySymbol);
        hash = 11 * hash + Objects.hashCode(this.locationType);
        hash = 11 * hash + Objects.hashCode(this.actors);
        hash = 11 * hash + Objects.hashCode(this.treasure);
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.flooded != other.flooded) {
            return false;
        }
        if (this.sunken != other.sunken) {
            return false;
        }
        if (!Objects.equals(this.displaySymbol, other.displaySymbol)) {
            return false;
        }
        if (!Objects.equals(this.locationType, other.locationType)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        if (!Objects.equals(this.treasure, other.treasure)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", flooded=" + flooded + ", sunken=" + sunken + ", displaySymbol=" + displaySymbol + ", locationType=" + locationType + ", actors=" + actors + ", treasure=" + treasure + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
