package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.item.vehicle.AbstracVehicle;
import org.mustafin.airpark.item.vehicle.VehicleType;

public class CompanyParametrized<T extends AbstracVehicle> {

    private int id;
    private String companyName;
    private final List<T> itemsPark = new ArrayList<>();
    private final EnumSet<VehicleType> allowedItemTypes = EnumSet.noneOf(VehicleType.class);
    private int maxItemCount;

    private static int lsdtId;

    public CompanyParametrized(String name, int maxItemCount) {
	this.id = lsdtId++;
	this.companyName = name;
	this.maxItemCount = maxItemCount;
    }

    public CompanyParametrized() {
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

    public List<T> getItemsPark() {
	return itemsPark;
    }

    public void setItemsPark(List<T> itemsPark) {
	this.itemsPark.clear();
	this.itemsPark.addAll(itemsPark);
    }

    public boolean addItem(T t) {
	if (itemsPark.size() < maxItemCount) { // TODO
	    // allowedAirshipTypes.contains(airship.getType())
	    itemsPark.add(t);
	    return true;
	}
	return false;
    }
    
    public boolean removeItem(int id) {
	return itemsPark.removeIf(item -> item.getId() == id);
    }
    
    public EnumSet<VehicleType> getAllowedItemTypes() {
	return allowedItemTypes;
    }
    
    public void addAvaliableItemTypes(VehicleType vehicleType) {
	allowedItemTypes.add(vehicleType);
    }
    
    public void removeAvaliableItemTypes(VehicleType vehicleType) {
	allowedItemTypes.remove(vehicleType);
    }

    public int getMaxItemCount() {
	return maxItemCount;
    }

    public void setMaxItemCount(int maxItemCount) {
	this.maxItemCount = maxItemCount;
    }

    public Optional<T> getItemById(int id) {
	return itemsPark.stream().filter(airship -> airship.getId() == id).findFirst();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
	result = prime * result + id;
	result = prime * result + ((itemsPark == null) ? 0 : itemsPark.hashCode());
	result = prime * result + maxItemCount;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof CompanyParametrized)) {
	    return false;
	}
	CompanyParametrized other = (CompanyParametrized) obj;
	if (companyName == null) {
	    if (other.companyName != null) {
		return false;
	    }
	} else if (!companyName.equals(other.companyName)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (itemsPark == null) {
	    if (other.itemsPark != null) {
		return false;
	    }
	} else if (!itemsPark.equals(other.itemsPark)) {
	    return false;
	}
	if (maxItemCount != other.maxItemCount) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "CompanyParametrized [id=" + id + ", companyName=" + companyName + ", itemsPark=" + itemsPark
		+ ", maxItemCount=" + maxItemCount + "]";
    }

}
