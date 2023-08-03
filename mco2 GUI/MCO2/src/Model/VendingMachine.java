package Model;

import java.util.ArrayList;

/**
 * The VendingMachine class represents a vending machine that contains multiple item slots,
 * a cash register, and a transaction log.
 */
public class VendingMachine {
	private ArrayList<ItemSlot> itemSlots;
	private CashRegister cashRegister;
	private Transactions transactions;
	
	/**
     * Creates a new VendingMachine with default settings.
     * The vending machine is initialized with empty item slots, a cash register, and an empty transaction log.
     */
	public VendingMachine() {
		itemSlots = new ArrayList<ItemSlot>(8);
		cashRegister = new CashRegister();
		transactions = new Transactions();

		// Initialize Test ItemSlots
		/* 
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
		*/
	}
	
	/**
     * Gets the list of item slots in the vending machine.
     *
     * @return the list of item slots
     */
	public ArrayList<ItemSlot> getItemSlots() {
		return itemSlots;
	}

	/**
     * Gets the cash register of the vending machine.
     *
     * @return the cash register
     */
	public CashRegister getCashRegister() {
		return cashRegister;
	}

	/**
     * Gets the transaction log of the vending machine.
     *
     * @return the transaction log
     */
	public Transactions getTransactions() {
		return transactions;
	}

	/**
     * Adds an item slot to the vending machine.
     *
     * @param itemSlot the item slot to add
     */
	public void addItemSlot(ItemSlot itemSlot) {
		itemSlots.add(itemSlot);
	}
	
	/**
     * Removes an item slot from the vending machine.
     *
     * @param itemSlot the item slot to remove
     */
	public void removeItemSlot(ItemSlot itemSlot) {
		itemSlots.remove(itemSlot);
	}

	/**
     * Sets the cash register of the vending machine.
     *
     * @param cashRegister the cash register to set
     */
	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}

	/**
     * Sets the transaction log of the vending machine.
     *
     * @param transactions the transaction log to set
     */
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
}