/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author mcwis
 */
public class Game implements Serializable{

    private double turns;
    private double score;
    private Element elementType;
    private SpecialAction specialActionType;
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    
    public Game() {
    }

    public double getTurns() {
        return turns;
    }

    public void setTurns(double turns) {
        this.turns = turns;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.turns) ^ (Double.doubleToLongBits(this.turns) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "turns=" + turns + ", score=" + score + '}';
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.turns) != Double.doubleToLongBits(other.turns)) {
            return false;
        }
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
