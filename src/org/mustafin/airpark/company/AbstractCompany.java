//remove signature
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;

//remove signature
/**
 *
 * @author marat
 */
//why abstract??
public abstract class AbstractCompany {

    private int id;
    private String name; // not informative, for ex rename to companyName
    private final List<Airship> park = new ArrayList<>(); // not informative
    private final List<AirshipType> avaliableAirships = new ArrayList<>(); //where getters and setters?? Name is not informative
    private int maxAirshipsValue; //where getters? or any checks for COUNTS? rename to maxAirshipsCount

    public AbstractCompany() {
    }

    public AbstractCompany(int id, String name, int maxAirshipsValue) {
        this.id = id; // it would be better to generate this parameter
        this.name = name;
        this.maxAirshipsValue = maxAirshipsValue;
    }

    public List<Airship> getPark() {
        return park;
    }

    public void addAirShip(Airship airship) {
        park.add(airship);
    }

    public boolean removeAirship(Airship airship) {
        return park.remove(airship); //if you try to add airship and then after several times try to remove airship you will faced with problem. It is because you use link for deleting.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.park);
        hash = 37 * hash + Objects.hashCode(this.avaliableAirships);
        hash = 37 * hash + this.maxAirshipsValue;
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
        final AbstractCompany other = (AbstractCompany) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.maxAirshipsValue != other.maxAirshipsValue) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.park, other.park)) {
            return false;
        }
        if (!Objects.equals(this.avaliableAirships, other.avaliableAirships)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AbstarctCompany{" + "id=" + id + ", name=" + name + ", park=" + park + ", avaliableAirShips=" + avaliableAirships + ", maxAirshipsValue=" + maxAirshipsValue + '}';
    }


}
