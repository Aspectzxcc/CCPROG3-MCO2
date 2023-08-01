package Model;

public class Item {
	// Attributes
	protected String itemName;
	protected int price, calories;
	
	/**
	 * Constructor:
	 * 
	 * @param itemName
	 * @param price
	 * @param calories
	 */

	public Item(String itemName) {
		this.itemName = itemName;
		generateItemPreset();
	}

	public Item(String itemName, int price, int calories) {
		this.itemName = itemName;
		this.price = price;
		this.calories = calories;
	}
	
	// Getters
	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}
	public int getCalories() {
		return calories;
	}
	
	//Set the price (MAINTENANCE FEATURE)
	public void setPrice(int price)
	{
		this.price = price;
	}

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