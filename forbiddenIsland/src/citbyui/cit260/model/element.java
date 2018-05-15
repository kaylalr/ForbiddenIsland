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
public enum element implements Serializable {
    earth(0),
    fire(1),
    water(2),
    wind(3);
    
    private final int elementType;
    
    element(int elementType) {
        this.elementType = elementType;
    }
    
    public int getElement() {
        return this.elementType;
    }
}