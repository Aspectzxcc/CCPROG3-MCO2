package Model;

import java.util.ArrayList;

/**
 * The Transactions class represents the transaction log of the vending machine,
 * which includes the items bought, special items bought, total sales, and inventory details.
 */
public class Transactions {
    private ArrayList<Item> itemsBought;
    private ArrayList<SpecialItem> specialItemsBought;
    private int totalSales;
    private int startingInventory;
    private int endingInventory;

     /**
     * Creates a new Transactions object with default values.
     * The transaction log is initialized with empty lists of items bought and special items bought,
     * and the starting and ending inventory are set to 0.
     */
    public Transactions() {
        this.itemsBought = new ArrayList<>();
        this.specialItemsBought = new ArrayList<>();
        this.startingInventory = 0;
        this.endingInventory = 0;
    }

    // Getters

    /**
     * Gets the list of regular items bought in the transaction.
     *
     * @return the list of regular items bought
     */
    public ArrayList<Item> getItemsBought() {
        return itemsBought;
    }

    /**
     * Gets the list of special items bought in the transaction.
     *
     * @return the list of special items bought
     */
    public ArrayList<SpecialItem> getSpecialItemsBought() {
        return specialItemsBought;
    }

    /**
     * Gets the starting inventory count for the transaction.
     *
     * @return the starting inventory count
     */
    public int getStartingInventory() {
        return startingInventory;
    }

    /**
     * Gets the total sales amount for the transaction.
     *
     * @return the total sales amount
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * Gets the ending inventory count for the transaction.
     *
     * @return the ending inventory count
     */
    public int getEndingInventory() {
        return endingInventory;
    }

    // Setters

    /**
     * Sets the list of regular items bought in the transaction.
     *
     * @param itemsBought the list of regular items bought
     */
    public void setItemsBought(ArrayList<Item> itemsBought) {
        this.itemsBought = itemsBought;
    }

    /**
     * Sets the list of special items bought in the transaction.
     *
     * @param specialItemsBought the list of special items bought
     */
    public void setSpecialItemsBought(ArrayList<SpecialItem> specialItemsBought) {
        this.specialItemsBought = specialItemsBought;
    }

    /**
     * Sets the total sales amount for the transaction.
     *
     * @param totalSales the total sales amount
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Sets the starting inventory count for the transaction.
     *
     * @param startingInventory the starting inventory count
     */
    public void setStartingInventory(int startingInventory) {
        this.startingInventory = startingInventory;
    }

    /**
     * Sets the ending inventory count for the transaction.
     *
     * @param endingInventory the ending inventory count
     */
    public void setEndingInventory(int endingInventory) {
        this.endingInventory = endingInventory;
    }

    /**
     * Adds a regular item to the list of items bought in the transaction.
     *
     * @param item the regular item to add
     */
    public void addItemBought(Item item) {
        this.itemsBought.add(item);
    }

    /**
     * Adds a special item to the list of special items bought in the transaction.
     *
     * @param specialItem the special item to add
     */
    public void addSpecialItemBought(SpecialItem specialItem) {
        this.specialItemsBought.add(specialItem);
    }

    /**
     * Adds the given amount to the total sales amount for the transaction.
     *
     * @param totalSales the amount to add to the total sales
     */
    public void addTotalSales(int totalSales) {
        this.totalSales += totalSales;
    }
}
    
