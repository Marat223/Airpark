package runapplication;

import item.IdGenerator;
import item.Item;
import item.ItemManager;
import item.TransferingBus;


public class MainClass {

    public static void main(String[] args) {

        Item bus = new TransferingBus();

        IdGenerator.getInstance().setNewId(bus);

        ItemManager<Item> busManager = new ItemManager() {
            @Override
            public boolean addItem(Object item) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
