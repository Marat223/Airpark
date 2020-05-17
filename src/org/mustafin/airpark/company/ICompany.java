package org.mustafin.airpark.company;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import org.mustafin.airpark.itemType.ItemType;

public interface ICompany {

    public int getId();

    public String getCompanyName();

    public void setCompanyName(String companyName);

    public List getItemsPark();

    public void setItemPark(List itemsPark);

    public boolean addItem(Optional airship);

    public boolean removeItem(int id);

    public EnumSet getAllowedItemTypes();

    public void addAvaliableitemTypes(ItemType ItemType);

    public void removeAvaliableItemTypes(ItemType ItemType);

    public int getMaxItemsCount();

    public void setMaxItemsCount(int maxItemsCount);

    public Optional getItemById(int id);
}
