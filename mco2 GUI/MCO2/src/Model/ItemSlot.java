package Model;

import java.util.ArrayList;

public class ItemSlot {
	private ArrayList<Item> items;
	
	public ItemSlot() {
		items = new ArrayList<Item>(10);
	}
	
	public ArrayList<Item> getItemList() {
		return items;
	}

	public void setItemList(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItemToSlot(Item item) {
		items.add(item);
	}
	
	public void removeItemFromList(Item item) {
		items.remove(item);
	}
}