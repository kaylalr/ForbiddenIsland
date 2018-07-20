/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;

/**
 *
 * @author DD
 */
public enum CardType {
    earth("Desc earth", "earth", "element"),
    fire("Desc fire", "fire", "element"),
    water("Desc water", "water", "element"),
    wind("Desc wind", "wind", "element"),
    unfloodTile("descFlood", "unfloodTile", "specialAction"),
    helicopter("DescHelicopter", "helicopter", "specialAction");

    
    
    private final String description;
    private final String cardName;
    private final String cardType;
    
    

//    private CardType(String description, String cardType) {
//        this.description = description;
//        this.cardType = cardType;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getCardType() {
//        return cardType;
//    }
//
//    @Override
//    public String toString() {
//        return "Card{" + "description=" + description + ", cardType=" + cardType + '}';
//    }

    private CardType(String description, String cardName, String cardType) {
        this.description = description;
        this.cardName = cardName;
        this.cardType = cardType;
    }

    public static CardType getEarth() {
        return earth;
    }

    public static CardType getFire() {
        return fire;
    }

    public static CardType getWater() {
        return water;
    }

    public static CardType getWind() {
        return wind;
    }

    public static CardType getUnfloodTile() {
        return unfloodTile;
    }

    public static CardType getHelicopter() {
        return helicopter;
    }

    public String getDescription() {
        return description;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return "CardType{" + "description=" + description + ", cardName=" + cardName + ", cardType=" + cardType + '}';
    }
    
    
}
