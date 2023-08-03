package Model;

/**
 * The Item class represents a generic item that can be stored in the vending machine.
 * Each item has attributes such as its name, price, and calories.
 */
public class Item {
	// Attributes
	protected String itemName;
	protected int price, calories;
	
	/**
     * Constructor for creating an Item object with the specified name.
     * The price and calories are set based on the item name using the generateItemPreset method.
     *
     * @param itemName the name of the item
     */
	public Item(String itemName) {
		this.itemName = itemName;
		generateItemPreset();
	}

	/**
     * Constructor for creating an Item object with the specified name, price, and calories.
     *
     * @param itemName the name of the item
     * @param price    the price of the item
     * @param calories the number of calories in the item
     */
	public Item(String itemName, int price, int calories) {
		this.itemName = itemName;
		this.price = price;
		this.calories = calories;
	}
	
	/**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
	public String getItemName() {
		return itemName;
	}

	/**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
	public int getPrice() {
		return price;
	}

	/**
     * Gets the number of calories in the item.
     *
     * @return the number of calories in the item
     */
	public int getCalories() {
		return calories;
	}
	
	/**
     * Sets the price of the item (maintenance feature).
     *
     * @param price the new price to set for the item
     */
	public void setPrice(int price)
	{
		this.price = price;
	}

	 /**
     * Generates the default price and calories for the item based on its name.
     * This method is called in the constructor when only the item name is provided.
     */
	public void generateItemPreset() {
		if ("Classic BLT".equals(itemName)) {
			this.calories = 450;
			this.price = 150;
		}
	
		if ("Turkey Club".equals(itemName)) {
			this.calories = 580;
			this.price = 200;
		}
	
		if ("Ham and Cheese".equals(itemName)) {
			this.calories = 520;
			this.price = 175;
		}
	
		if ("Chicken Salad".equals(itemName)) {
			this.calories = 390;
			this.price = 180;
		}
	
		if ("Tuna Salad".equals(itemName)) {
			this.calories = 420;
			this.price = 190;
		}
	
		if ("Veggie Delight".equals(itemName)) {
			this.calories = 320;
			this.price = 135;
		}
	
		if ("Italian Sub".equals(itemName)) {
			this.calories = 620;
			this.price = 230;
		}
	
		if ("Grilled Chicken Panini".equals(itemName)) {
			this.calories = 540;
			this.price = 250;
		}
	
		if ("Egg Salad".equals(itemName)) {
			this.calories = 380;
			this.price = 130;
		}
	
		if ("Roast Beef and Cheddar".equals(itemName)) {
			this.calories = 590;
			this.price = 210;
		}
	}
	

}