package Model;

import java.util.ArrayList;

public class VendingMachine {
	private ArrayList<ItemSlot> itemSlots;
	
	public VendingMachine() {
		itemSlots = new ArrayList<ItemSlot>(8);
	}
	
	// getters
	public ArrayList<ItemSlot> getItemSlots() {
		return itemSlots;
	}

	// setters
	public void addItemSlot(ItemSlot itemSlot) {
		itemSlots.add(itemSlot);
	}
	
	public void removeItemSlot(ItemSlot itemSlot) {
		itemSlots.remove(itemSlot);
	}
}