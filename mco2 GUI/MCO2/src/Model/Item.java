package Model;

public class Item {
	// Attributes
	private String itemName;
	private double price, calories, weight;
	
	/**
	 * Constructor:
	 * 
	 * @param itemName
	 * @param price
	 * @param calories
	 * @param weight
	 * @param quantity
	 */
	public Item(String itemName, double price, double calories, double weight) {
		this.itemName = itemName;
		this.price = price;
		this.calories = calories;
		this.weight = weight;
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
	public double getWeight() {
		return weight;
	}
	
	//Set the price (MAINTENANCE FEATURE)
	public void setPrice(double price)
	{
		this.price = price;
	}

}