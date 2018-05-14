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
public class CardType implements Serializable {
    private String element;
    private String specialAction;
    
 
    public CardType(String element, String specialAction) {
        this.element = element;
        this.specialAction = specialAction;
    }

    
    
    
    
}
