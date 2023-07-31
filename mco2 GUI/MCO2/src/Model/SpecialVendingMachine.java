package Model;

import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine{
    private ArrayList<ItemSlot> specialItems;
    SpecialVendingMachine() {
        super();

        this.specialItems = new ArrayList<>();
    }

    public ArrayList<ItemSlot> getSpecialItems() {
        return specialItems;
    }
    
}
