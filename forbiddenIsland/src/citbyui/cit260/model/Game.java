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
public class Game implements Serializable {

    private double turns;
    private int playerOneTurns;
    private int playerTwoTurns;
    private double score;
    private Card cardType;
    private Player player;
    private Map map;

    public Game() {
    }

    public int getPlayerOneTurns() {
        return playerOneTurns;
    }

    public void setPlayerOneTurns(int playerOneTurns) {
        this.playerOneTurns = playerOneTurns;
    }

    public int getPlayerTwoTurns() {
        return playerTwoTurns;
    }

    public void setPlayerTwoTurns(int playerTwoTurns) {
        this.playerTwoTurns = playerTwoTurns;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.turns) ^ (Double.doubleToLongBits(this.turns) >>> 32));
        hash = 13 * hash + this.playerOneTurns;
        hash = 13 * hash + this.playerTwoTurns;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.cardType);
        hash = 13 * hash + Objects.hashCode(this.player);
        hash = 13 * hash + Objects.hashCode(this.map);
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
        if (this.playerOneTurns != other.playerOneTurns) {
            return false;
        }
        if (this.playerTwoTurns != other.playerTwoTurns) {
            return false;
        }
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (this.cardType != other.cardType) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "turns=" + turns + ", playerOneTurns=" + playerOneTurns + ", playerTwoTurns=" + playerTwoTurns + ", score=" + score + ", cardType=" + cardType + ", player=" + player + ", map=" + map + '}';
    }

   

}
