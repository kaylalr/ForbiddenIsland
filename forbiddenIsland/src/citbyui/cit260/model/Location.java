/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author mcwis
 */
public class Location implements Serializable{

    private double row;
    private double column;
    private int flooded;
    private int sunken;
    private String displaySymbol;
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    
    public Location() {
    }

    public Location(double row, double column, int flooded, int sunken, String displaySymbol) {
        this.row = row;
        this.column = column;
        this.flooded = flooded;
        this.sunken = sunken;
        this.displaySymbol = displaySymbol;
    }

    public double getRow() {
        return row;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public double getColumn() {
        return column;
    }

    public void setColumn(double column) {
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

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", flooded=" + flooded + ", sunken=" + sunken + ", displaySymbol=" + displaySymbol + ", actors=" + actors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.row) ^ (Double.doubleToLongBits(this.row) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.column) ^ (Double.doubleToLongBits(this.column) >>> 32));
        hash = 89 * hash + this.flooded;
        hash = 89 * hash + this.sunken;
        hash = 89 * hash + Objects.hashCode(this.displaySymbol);
        hash = 89 * hash + Objects.hashCode(this.actors);
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
        if (Double.doubleToLongBits(this.row) != Double.doubleToLongBits(other.row)) {
            return false;
        }
        if (Double.doubleToLongBits(this.column) != Double.doubleToLongBits(other.column)) {
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
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }
    
    


}
