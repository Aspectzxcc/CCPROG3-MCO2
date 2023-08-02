package Model;

import java.util.ArrayList;

public class VendingMachine {
	private ArrayList<ItemSlot> itemSlots;
	private CashRegister cashRegister;
	private Transactions transactions;
	
	public VendingMachine() {
		itemSlots = new ArrayList<ItemSlot>(8);
		cashRegister = new CashRegister();
		transactions = new Transactions();

		// Initialize Test ItemSlots
		ItemSlot itemSlot1 = new ItemSlot();
		ArrayList<Item> items1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items1.add(new Item("Classic BLT"));
		}
		itemSlot1.setItemList(items1);

		ItemSlot itemSlot2 = new ItemSlot();
		ArrayList<Item> items2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items2.add(new Item("Turkey Club"));
		}
		itemSlot2.setItemList(items2);

		ItemSlot itemSlot3 = new ItemSlot();
		ArrayList<Item> items3 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items3.add(new Item("Ham and Cheese"));
		}
		itemSlot3.setItemList(items3);

		ItemSlot itemSlot4 = new ItemSlot();
		ArrayList<Item> items4 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items4.add(new Item("Chicken Salad"));
		}
		itemSlot4.setItemList(items4);

		ItemSlot itemSlot5 = new ItemSlot();
		ArrayList<Item> items5 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items5.add(new Item("Tuna Salad"));
		}
		itemSlot5.setItemList(items5);

		ItemSlot itemSlot6 = new ItemSlot();
		ArrayList<Item> items6 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items6.add(new Item("Egg Salad"));
		}
		itemSlot6.setItemList(items6);

		ItemSlot itemSlot7 = new ItemSlot();
		ArrayList<Item> items7 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items7.add(new Item("Veggie Delight"));
		}
		itemSlot7.setItemList(items7);

		ItemSlot itemSlot8 = new ItemSlot();
		ArrayList<Item> items8 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			items8.add(new Item("Italian Sub"));
		}
		itemSlot8.setItemList(items8);

		itemSlots.add(itemSlot1);
		itemSlots.add(itemSlot2);
		itemSlots.add(itemSlot3);
		itemSlots.add(itemSlot4);
		itemSlots.add(itemSlot5);
		itemSlots.add(itemSlot6);
		itemSlots.add(itemSlot7);
		itemSlots.add(itemSlot8);
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