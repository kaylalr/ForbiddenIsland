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
public enum SpecialAction implements Serializable{
    unfloodTile(0),
    helicopter(1);
    
    private final int specialActionType;
    
    SpecialAction(int specialActionType) {
        this.specialActionType = specialActionType;
    }
    
    public int getspecialAction() {
        return this.specialActionType;
    }

    @Override
    public String toString() {
        return "SpecialAction{" + "specialActionType=" + specialActionType + '}';
    }
    
    
}
