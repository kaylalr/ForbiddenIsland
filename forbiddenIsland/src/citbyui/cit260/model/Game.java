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
public class Game implements Serializable{

    private double turns;
    private double score;
    private Card cardType;
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    private Map map;
    
    public Game() {
    }

    public Game(double turns, double score) {
        this.turns = turns;
        this.score = score;
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

    public Card getCardType() {
        return cardType;
    }

    public void setCardType(Card cardType) {
        this.cardType = cardType;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Game{" + "turns=" + turns + ", score=" + score + ", cardType=" + cardType + ", actors=" + actors + ", map=" + map + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.turns) ^ (Double.doubleToLongBits(this.turns) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.cardType);
        hash = 29 * hash + Objects.hashCode(this.actors);
        hash = 29 * hash + Objects.hashCode(this.map);
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.turns) != Double.doubleToLongBits(other.turns)) {
            return false;
        }
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (this.cardType != other.cardType) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        return true;
    }
    
    
}
