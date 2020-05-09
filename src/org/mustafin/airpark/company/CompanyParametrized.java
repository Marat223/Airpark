package org.mustafin.airpark.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import org.mustafin.airpark.annotation.NewClass;
import org.mustafin.airpark.exception.WrongItemTypeEnumeration;
import org.mustafin.airpark.item.ItemType;
import org.mustafin.airpark.item.vehicle.AbstractVehicle;
import org.mustafin.airpark.item.vehicle.Vehicle;
import org.mustafin.airpark.item.vehicle.VehicleType;

@NewClass(id = 1)
public class CompanyParametrized<T extends AbstractVehicle> implements ICompany {

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
    public List<T> getItemsPark() {
	return itemsPark;
    }

    @Override
    public void setItemPark(List itemsPark) {
	this.itemsPark.clear();
	this.itemsPark.addAll(itemsPark);
    }

    @Override
    public boolean addItem(Object vehicle) {
	if (itemsPark.size() < maxItemCount) { // TODO
	    // allowedAirshipTypes.contains(airship.getType())
	    if (vehicle.getClass() instanceof Vehicle) {
		    throw new WrongItemTypeEnumeration(": shold be \"VehicleType\" enumeration");
		}
	    itemsPark.add(vehicle);
	    return true;
	}
	return false;
    }

    @Override
    public boolean removeItem(int id) {
	return itemsPark.removeIf(item -> item.getId() == id);
    }

    @Override
    public EnumSet<VehicleType> getAllowedItemTypes() {
	return allowedItemTypes;
    }

    @Override
    public void addAvaliableitemTypes(ItemType vehicleType) {
	if (vehicleType.getClass() != VehicleType.class) {
	    throw new WrongItemTypeEnumeration(": shold be \"VehicleType\" enumeration");
	}
	allowedItemTypes.add((VehicleType) vehicleType);
    }

    @Override
    public void removeAvaliableItemTypes(ItemType vehicleType) {
	if (vehicleType.getClass() != VehicleType.class) {
	    throw new WrongItemTypeEnumeration(": shold be \"VehicleType\" enumeration");
	}
	allowedItemTypes.remove(vehicleType);
    }

    @Override
    public int getMaxItemsCount() {
	return maxItemCount;
    }

    @Override
    public void setMaxItemsCount(int maxItemCount) {
	this.maxItemCount = maxItemCount;
    }

    @Override
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

}
