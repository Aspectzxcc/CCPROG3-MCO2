package Model;

import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine{
    private ArrayList<ArrayList<SpecialItem>> specialItems;

    public SpecialVendingMachine() {
        super();
        specialItems = new ArrayList<>();

        // Initialize some test SpecialItem objects
        ArrayList<SpecialItem> specialItems1 = new ArrayList<>();
        specialItems1.add(new SpecialItem("White Bread"));
        specialItems1.add(new SpecialItem("White Bread"));
        specialItems1.add(new SpecialItem("White Bread"));
        specialItems.add(specialItems1);

        ArrayList<SpecialItem> specialItems2 = new ArrayList<>();
        specialItems2.add(new SpecialItem("Roast Beef"));
        specialItems2.add(new SpecialItem("Roast Beef"));
        specialItems2.add(new SpecialItem("Roast Beef"));
        specialItems.add(specialItems2);

        ArrayList<SpecialItem> specialItems3 = new ArrayList<>();
        specialItems3.add(new SpecialItem("Cheddar Cheese"));
        specialItems3.add(new SpecialItem("Cheddar Cheese"));
        specialItems3.add(new SpecialItem("Cheddar Cheese"));
        specialItems.add(specialItems3);

        ArrayList<SpecialItem> specialItems4 = new ArrayList<>();
        specialItems4.add(new SpecialItem("Lettuce"));
        specialItems4.add(new SpecialItem("Lettuce"));
        specialItems4.add(new SpecialItem("Lettuce"));
        specialItems.add(specialItems4);

        ArrayList<SpecialItem> specialItems5 = new ArrayList<>();
        specialItems5.add(new SpecialItem("Hummus"));
        specialItems5.add(new SpecialItem("Hummus"));
        specialItems5.add(new SpecialItem("Hummus"));
        specialItems.add(specialItems5);

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
