package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;

public class AirshipCompany {

    private int id;
    private String companyName;
    private final List<Airship> airshipsPark = new ArrayList<>();
    private final EnumSet<AirshipType> allowedAirshipTypes = EnumSet.noneOf(AirshipType.class);
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

    public List<Airship> getAirshipsPark() {
        return airshipsPark;
    }

    public void setAirshipsPark(List<Airship> airshipsPark) {
        this.airshipsPark.clear();
        this.airshipsPark.addAll(airshipsPark);
    }

    public boolean addAirShip(Airship airship) {
        if (airshipsPark.size() < maxAirshipsCount
                && allowedAirshipTypes.stream().anyMatch(type -> type == airship.getType())) {
            airshipsPark.add(airship);
            return true;
        }
        return false;
    }

    public EnumSet<AirshipType> getAllowedAirshipTypes() {
        return allowedAirshipTypes;
    }

    public void setAvaliableAirshipsTypes(AirshipType airshipType) {
        allowedAirshipTypes.add(airshipType);
    }

    public boolean removeAirship(int id) {
        return airshipsPark.removeIf(airship -> airship.getId() == id);
    }

    public void removeAvaliableAirshipsTypes(AirshipType airshipType) {
        allowedAirshipTypes.remove(airshipType);
    }

    public int getMaxAirshipsCount() {
        return maxAirshipsCount;
    }

    public void setMaxAirshipsCount(int maxAirshipsCount) {
        this.maxAirshipsCount = maxAirshipsCount;
    }

    public Optional<Airship> getAirshipById(int id) {
        return airshipsPark.stream().filter(airship -> airship.getId() == id).findFirst();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.companyName);
        hash = 37 * hash + Objects.hashCode(this.airshipsPark);
        hash = 37 * hash + Objects.hashCode(this.allowedAirshipTypes);
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
        if (!Objects.equals(this.airshipsPark, other.airshipsPark)) {
            return false;
        }
        if (!Objects.equals(this.allowedAirshipTypes, other.allowedAirshipTypes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AirshipCompany{" + "id=" + id + ", name=" + companyName + ", park=" + airshipsPark + ", avaliableAirShipTypes=" + allowedAirshipTypes + ", maxAirshipsValue=" + maxAirshipsCount + '}';
    }

}
