package Model;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Item> itemsBought;
    private int totalSales;
    private int startingInventory;
    private int endingInventory;

    public Transactions() {
        this.itemsBought = new ArrayList<>();
        this.startingInventory = 0;
        this.endingInventory = 0;
    }

    // Getters
    public ArrayList<Item> getItemsBought() {
        return itemsBought;
    }

    public int getStartingInventory() {
        return startingInventory;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int getEndingInventory() {
        return endingInventory;
    }

    // Setters
    public void setItemsBought(ArrayList<Item> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public void setStartingInventory(int startingInventory) {
        this.startingInventory = startingInventory;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public void setEndingInventory(int endingInventory) {
        this.endingInventory = endingInventory;
    }
}
    
