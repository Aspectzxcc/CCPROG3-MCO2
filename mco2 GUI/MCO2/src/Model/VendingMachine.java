package Model;

import java.util.ArrayList;

public class VendingMachine {
	private ArrayList<ItemSlot> itemSlots;
	private CashRegister cashRegister;
	
	public VendingMachine() {
		itemSlots = new ArrayList<ItemSlot>(8);
		cashRegister = new CashRegister();
	}
	
	// getters
	public ArrayList<ItemSlot> getItemSlots() {
		return itemSlots;
	}

	public CashRegister getCashRegister() {
		return cashRegister;
	}

	// setters
	public void addItemSlot(ItemSlot itemSlot) {
		itemSlots.add(itemSlot);
	}
	
	public void removeItemSlot(ItemSlot itemSlot) {
		itemSlots.remove(itemSlot);
	}

	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}
}