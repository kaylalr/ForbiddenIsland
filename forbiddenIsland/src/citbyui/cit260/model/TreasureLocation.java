/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
/**
 *
 * @author mcwis
 */
public class TreasureLocation implements Serializable{
    
    private Treasure Treasure;

    public TreasureLocation() {
 
    }

    public Treasure getTreasure() {
        return Treasure;
    }

    public void setTreasure(Treasure Treasure) {
        this.Treasure = Treasure;
    }
    
    
    
    
    
}
