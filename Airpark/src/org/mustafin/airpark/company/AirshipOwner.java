package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;
//Owner is not a Company, rename it. Maybe Airport, Airpark
public class AirshipOwner {

    private int id;
    private String companyName;
    private final List<Airship> parkAirplains = new ArrayList<>();
    private final EnumSet<AirshipType> avaliableAirshipsTypes = EnumSet.noneOf(AirshipType.class); //where getters and setters?? till not implemented
    private int maxAirshipsCount; //where getters? or any checks for COUNTS? the same

    public AirshipOwner() {
    }

    public AirshipOwner(int id, String name, int maxAirshipsValue) {
        this.id = id; // it would be better to generate this parameter
        this.companyName = name;
        this.maxAirshipsCount = maxAirshipsValue;
    }

    public List<Airship> getPark() {
        return parkAirplains;
    }

    public void addAirShip(Airship airship) {
        parkAirplains.add(airship);
    }

    public boolean removeAirship(Airship airship) {
        return parkAirplains.remove(airship); //if you try to add airship and then after several times try to remove airship you will faced with problem. It is because you use link for deleting.
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
        final AirshipOwner other = (AirshipOwner) obj;
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
        return "AbstarctCompany{" + "id=" + id + ", name=" + companyName + ", park=" + parkAirplains + ", avaliableAirShips=" + avaliableAirshipsTypes + ", maxAirshipsValue=" + maxAirshipsCount + '}';
    }


}
