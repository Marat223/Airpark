package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.mustafin.airpark.annotation.OldClass;
import org.mustafin.airpark.exception.WrongItemTypeEnumeration;
import org.mustafin.airpark.item.airship.Airship;
import org.mustafin.airpark.itemType.AirshipType;
import org.mustafin.airpark.itemType.ItemType;
import org.mustafin.airpark.itemType.VehicleType;

@OldClass(id = 1)
public class AirshipCompany implements ICompany {

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

    @Override
    public int getId() {
	return id;
    }

    @Override
    public String getCompanyName() {
	return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    @Override
    public List<Airship> getItemsPark() {
	return airshipsPark;
    }

    @Override
    public void setItemPark(List airshipsPark) {
	this.airshipsPark.clear();
	this.airshipsPark.addAll(airshipsPark);
    }

    @Override
    public boolean addItem(Optional airship) {
	if (airship.isPresent()) {
	    if (airship.get() instanceof Airship) {
		if (airshipsPark.size() < maxAirshipsCount
			&& allowedAirshipTypes.contains(((Airship) airship.get()).getType())) { // TODO
		    // allowedAirshipTypes.contains(airship.getType())
		    airshipsPark.add((Airship) airship.get());
		    return true;
		}
		return false;
	    } else {
		throw new WrongItemTypeEnumeration(": shold be \"Vehicle\" entity");
	    }
	}
	return false;
    }

    @Override
    public boolean removeItem(int id) {
	return airshipsPark.removeIf(airship -> airship.getId() == id);
    }

    @Override
    public EnumSet<AirshipType> getAllowedItemTypes() {
	return allowedAirshipTypes;
    }

    @Override
    public void addAvaliableitemTypes(ItemType airshipType) {
	if (airshipType.getClass() != AirshipType.class) {
	    throw new WrongItemTypeEnumeration(": shold be \"VehicleType\" enumeration");
	}
	allowedAirshipTypes.add((AirshipType) airshipType);
    }

    @Override
    public void removeAvaliableItemTypes(ItemType airshipType) {
	if (airshipType.getClass() != AirshipType.class) {
	    throw new WrongItemTypeEnumeration(": shold be \"VehicleType\" enumeration");
	}
	allowedAirshipTypes.remove((AirshipType) airshipType);
    }

    @Override
    public int getMaxItemsCount() {
	return maxAirshipsCount;
    }

    @Override
    public void setMaxItemsCount(int maxAirshipsCount) {
	this.maxAirshipsCount = maxAirshipsCount;
    }

    @Override
    public Optional<Airship> getItemById(int id) {
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
	return "AirshipCompany{" + "id=" + id + ", name=" + companyName + ", park=" + airshipsPark
		+ ", avaliableAirShipTypes=" + allowedAirshipTypes + ", maxAirshipsValue=" + maxAirshipsCount + '}';
    }

}
