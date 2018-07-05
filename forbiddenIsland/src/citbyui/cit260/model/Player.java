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
public class Player implements Serializable {

    private String name;
    private double bestScore;
    private ArrayList<Game> games = new ArrayList<Game>();
    private ArrayList<Actor> actors = new ArrayList<Actor>();

    public Player() {
    }

    public Player(String name, double bestScore) {
        this.name = name;
        this.bestScore = bestScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", bestScore=" + bestScore + ", games=" + games + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.bestScore) ^ (Double.doubleToLongBits(this.bestScore) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.games);
        hash = 23 * hash + Objects.hashCode(this.actors);
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.bestScore) != Double.doubleToLongBits(other.bestScore)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.games, other.games)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }

}
