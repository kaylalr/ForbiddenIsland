/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
/**
 *
 * @author DD
 */
public enum Card implements Serializable {
    earth("Desc earth", "element"),
    fire("Desc fire", "element"),
    water("Desc water", "element"),
    wind("Desc wind", "element"),
    unfloodTile("descFlood", "specialAction"),
    helicopter("DescHelicopter", "specialAction");
    
    private final String description;
    private final String cardType;

    private Card(String description, String cardType) {
        this.description = description;
        this.cardType = cardType;
    }

    public String getDescription() {
        return description;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return "Card{" + "description=" + description + ", cardType=" + cardType + '}';
    }


    
    
}