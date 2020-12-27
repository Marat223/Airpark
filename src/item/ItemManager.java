package item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public abstract class ItemManager<Item> {

    private Map<Integer, Item> managingItems = new HashMap<>();

    public abstract boolean addItem(Item item);

    public Optional<Item> getItem(int id) {
        return managingItems.entrySet().stream().filter(e -> e.getKey() == id).map(Map.Entry::getValue).findFirst();
    }

    public void requestCharter()
    {
        
    }
}
