/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;

import java.util.Objects;

/*
 *
 * @author mcwis
 */
public class TreasureLocation extends Location{
    private Treasure Treasure;

    public TreasureLocation() {
 
    }

    public Treasure getTreasure() {
        return Treasure;
    }

    public void setTreasure(Treasure Treasure) {
        this.Treasure = Treasure;
    }

    @Override
    public String toString() {
        return "TreasureLocation{" + "Treasure=" + Treasure + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.Treasure);
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
        final TreasureLocation other = (TreasureLocation) obj;
        if (!Objects.equals(this.Treasure, other.Treasure)) {
            return false;
        }
        return true;
    }
    
    
}
