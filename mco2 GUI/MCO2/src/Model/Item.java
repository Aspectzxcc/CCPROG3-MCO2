package Model;

public class Item {
	// Attributes
	private String itemName;
	private double price, calories;
	
	/**
	 * Constructor:
	 * 
	 * @param itemName
	 * @param price
	 * @param calories
	 * @param quantity
	 */

	public Item(String itemName) {
		this.itemName = itemName;
		this.price = 0;
		this.calories = 0;
	}
	
	// Getters
	public String getItemName() {
		return itemName;
	}
		public double getPrice() {
		return price;
	}
	public double getCalories() {
		return calories;
	}
	
	//Set the price (MAINTENANCE FEATURE)
	public void setPrice(double price)
	{
		this.price = price;
	}

	public void generateItemPreset() {
		if (itemName == "Classic BLT") {
			this.calories = 450;
			this.price = 150;
		}

		if (itemName == "Turkey Club") {
			this.calories = 580;
			this.price = 200;
		}

		if (itemName == "Ham and Cheese") {
			this.calories = 520;
			this.price = 175;
		}

		if (itemName == "Chicken Salad") {
			this.calories = 390;
			this.price = 180;
		}

		if (itemName == "Tuna Salad") {
			this.calories = 420;
			this.price = 190;
		}

		if (itemName == "Veggie Delight") {
			this.calories = 320;
			this.price = 135;
		}

		if (itemName == "Italian Sub") {
			this.calories = 620;
			this.price = 230;
		}

		if (itemName == "Grilled Chicken Panini") {
			this.calories = 540;
			this.price = 250;
		}

		if (itemName == "Egg Salad") {
			this.calories = 380;
			this.price = 130;
		}

		if (itemName == "Roast Beef and Cheddar") {
			this.calories = 590;
			this.price = 210;
		}
	}

}