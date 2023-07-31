package Model;

import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine{
    private ArrayList<ArrayList<SpecialItem>> specialItems;

    public SpecialVendingMachine() {
        super();

        this.specialItems = new ArrayList<>();
    }

    public ArrayList<ArrayList<SpecialItem>> getSpecialItems() {
        return specialItems;
    }

    public void addSpecialItems(ArrayList<SpecialItem> specialItems) {
        this.specialItems.add(specialItems);
    }

    public void removeSpecialItems(ArrayList<ArrayList<SpecialItem>> specialItems) {
        this.specialItems.remove(specialItems);
    }  
}
