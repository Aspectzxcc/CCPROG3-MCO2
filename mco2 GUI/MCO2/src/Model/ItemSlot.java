package Model;

import java.util.ArrayList;

/**
 * The ItemSlot class represents a slot in the vending machine that can hold multiple items.
 * Each item slot has an ArrayList to store the items it contains.
 */
public class ItemSlot {
	private ArrayList<Item> items;
	
	/**
     * Constructs a new ItemSlot object with an empty ArrayList to store the items.
     * The ArrayList has an initial capacity of 10.
     */
	public ItemSlot() {
		items = new ArrayList<Item>(10);
	}
	
	 /**
     * Gets the list of items currently stored in the item slot.
     *
     * @return the list of items in the item slot
     */
	public ArrayList<Item> getItemList() {
		return items;
	}

	/**
     * Sets the list of items in the item slot to the specified ArrayList.
     *
     * @param items the ArrayList of items to set in the item slot
     */
	public void setItemList(ArrayList<Item> items) {
		this.items = items;
	}
	
	/**
     * Adds an item to the item slot.
     *
     * @param item the item to add to the item slot
     */
	public void addItemToSlot(Item item) {
		items.add(item);
	}
	
	/**
     * Removes an item from the item slot.
     *
     * @param item the item to remove from the item slot
     */
	public void removeItemFromList(Item item) {
		items.remove(item);
	}
}