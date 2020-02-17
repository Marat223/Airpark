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

/**
 *
 * @author marat
 */
public abstract class AbstractCompany {

    private int id;
    private String name;
    private final List<Airship> park = new ArrayList<>();
    private final List<AirshipType> avaliableAirships = new ArrayList<>();
    private int maxAirshipsValue;

    public AbstractCompany() {
    }

    public AbstractCompany(int id, String name, int maxAirshipsValue) {
        this.id = id;
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
        return park.remove(airship);
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
