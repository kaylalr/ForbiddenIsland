/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author mcwis
 */
public class CardType implements Serializable {
    private String element;
    private String specialAction;
    
 
    public CardType(){

    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getSpecialAction() {
        return specialAction;
    }

    public void setSpecialAction(String specialAction) {
        this.specialAction = specialAction;
    }

    @Override
    public String toString() {
        return "CardType{" + "element=" + element + ", specialAction=" + specialAction + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.element);
        hash = 67 * hash + Objects.hashCode(this.specialAction);
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
        final CardType other = (CardType) obj;
        if (!Objects.equals(this.element, other.element)) {
            return false;
        }
        if (!Objects.equals(this.specialAction, other.specialAction)) {
            return false;
        }
        return true;
    }
    
    
    
    

    
    
    
    
}
