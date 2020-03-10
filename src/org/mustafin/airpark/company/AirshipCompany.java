package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;

public class AirshipCompany {

    private int id;
    private String companyName;
    private final List<Airship> parkAirplains = new ArrayList<>();
    private final EnumSet<AirshipType> avaliableAirshipsTypes = EnumSet.noneOf(AirshipType.class);
    private int maxAirshipsCount;

    private static int lsdtId;

    public AirshipCompany(String name, int maxAirshipsValue) {
        this.id = lsdtId++;
        this.companyName = name;
        this.maxAirshipsCount = maxAirshipsValue;
    }

    public AirshipCompany() {
        this.id = lsdtId++;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Airship> getParkAirplains() {
        return parkAirplains;
    }

    public void setParkAirplains(List<Airship> parkAirplains) {
        this.parkAirplains.clear();
        this.parkAirplains.addAll(parkAirplains);
    }

    public boolean addAirShip(Airship airship) {
        if (parkAirplains.size() < maxAirshipsCount) {
            parkAirplains.add(airship);
            return true;
        }
        return false;
    }

    public EnumSet<AirshipType> getAvaliableAirshipsTypes() {
        return avaliableAirshipsTypes;
    }

    public void setAvaliableAirshipsTypes(AirshipType airshipType) {
        avaliableAirshipsTypes.add(airshipType);
    }

    public boolean removeAirship(Airship airship) {
        return parkAirplains.remove(airship); //if you try to add airship and then after several times try to remove airship you will faced with problem. It is because you use link for deleting.
    }

    public void removeAvaliableAirshipsTypes(AirshipType airshipType) {
        avaliableAirshipsTypes.remove(airshipType);
    }

    public int getMaxAirshipsCount() {
        return maxAirshipsCount;
    }

    public void setMaxAirshipsCount(int maxAirshipsCount) {
        this.maxAirshipsCount = maxAirshipsCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.companyName);
        hash = 37 * hash + Objects.hashCode(this.parkAirplains);
        hash = 37 * hash + Objects.hashCode(this.avaliableAirshipsTypes);
        hash = 37 * hash + this.maxAirshipsCount;
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
        final AirshipCompany other = (AirshipCompany) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.maxAirshipsCount != other.maxAirshipsCount) {
            return false;
        }
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        if (!Objects.equals(this.parkAirplains, other.parkAirplains)) {
            return false;
        }
        if (!Objects.equals(this.avaliableAirshipsTypes, other.avaliableAirshipsTypes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AirshipCompany{" + "id=" + id + ", name=" + companyName + ", park=" + parkAirplains + ", avaliableAirShipTypes=" + avaliableAirshipsTypes + ", maxAirshipsValue=" + maxAirshipsCount + '}';
    }

}
