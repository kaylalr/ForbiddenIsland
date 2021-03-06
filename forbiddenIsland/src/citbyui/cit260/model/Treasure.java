/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mcwis
 */
public class Treasure implements Serializable {

    private String name;
    private String description;
    private String status;
    private Point coordinates;
    private TreasureLocation TreasureLocation;

    public Treasure() {
    }

    public Treasure(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TreasureLocation getTreasureLocation() {
        return TreasureLocation;
    }

    public void setTreasureLocation(TreasureLocation TreasureLocation) {
        this.TreasureLocation = TreasureLocation;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Treasure{" + "name=" + name + ", description=" + description + ", status=" + status + ", coordinates=" + coordinates + ", TreasureLocation=" + TreasureLocation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.status);
        hash = 17 * hash + Objects.hashCode(this.coordinates);
        hash = 17 * hash + Objects.hashCode(this.TreasureLocation);
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
        final Treasure other = (Treasure) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        if (!Objects.equals(this.TreasureLocation, other.TreasureLocation)) {
            return false;
        }
        return true;
    }

}
