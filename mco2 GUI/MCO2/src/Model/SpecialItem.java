package Model;

/**
 * The SpecialItem class represents a special item that can be used in sandwiches.
 * Special items are typically ingredients like bread, meat, cheese, vegetables, and sauces.
 * Each special item has specific attributes such as calories, price, type, and preparation message.
 */
public class SpecialItem extends Item{
    private String type;
    private String preparationMessage;

    /**
     * Constructs a new SpecialItem object with the specified item name.
     * The type and preparationMessage will be set to empty strings by default.
     *
     * @param itemName the name of the special item
     */
    public SpecialItem(String itemName) {
        super(itemName);

        type = "";
        preparationMessage = "";
        generateItemPreset();
    }

    /**
     * Constructs a new SpecialItem object with the specified item name, price, and calories.
     * The type will be set to "Sandwich" by default, and the preparationMessage will be set to an empty string.
     *
     * @param itemName   the name of the special item
     * @param itemPrice  the price of the special item
     * @param itemCalories the calorie count of the special item
     */
    public SpecialItem(String itemName, int itemPrice, int itemCalories) {
        super(itemName, itemPrice, itemCalories);

        type = "Sandwich";
        preparationMessage = "";
        this.itemName = itemName;
    }

    /**
     * Gets the type of the special item (e.g., "Bread", "Meat", "Cheese", "Vegetable", or "Sauce").
     *
     * @return the type of the special item
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the preparation message for the special item.
     * The preparation message describes how the item is prepared or served.
     *
     * @return the preparation message
     */
    public String getPreparationMessage() {
        return preparationMessage;
    }
    
    /**
     * Generates the preset attributes of the special item based on its item name.
     * The attributes such as calories, price, type, and preparation message are set accordingly.
     */
    @Override
    public void generateItemPreset() {
        switch (this.itemName) {
            // Bread Options
            case "White Bread":
                this.calories = 80;
                this.price = 30; // Raised price
                this.type = "Bread";
                preparationMessage = "Slicing White Bread...";
                break;
            case "Whole Wheat Bread":
                this.calories = 90;
                this.price = 35; // Raised price
                this.type = "Bread";
                preparationMessage = "Cutting Whole Wheat Bread...";
                break;
            case "Multigrain Bread":
                this.calories = 100;
                this.price = 40; // Raised price
                this.type = "Bread";
                preparationMessage = "Preparing Multigrain Bread...";
                break;
            case "Rye Bread":
                this.calories = 110;
                this.price = 40; // Raised price
                this.type = "Bread";
                preparationMessage = "Slicing Rye Bread...";
                break;
            case "Baguette":
                this.calories = 120;
                this.price = 50; // Raised price
                this.type = "Bread";
                preparationMessage = "Preparing Baguette...";
                break;
            case "Ciabatta":
                this.calories = 130;
                this.price = 55; // Raised price
                this.type = "Bread";
                preparationMessage = "Cutting Ciabatta Bread...";
                break;
            case "Wrap":
                this.calories = 110;
                this.price = 45; // Raised price
                this.type = "Bread";
                preparationMessage = "Warming up the Wrap...";
                break;
    
            // Meat Options
            case "Roast Beef":
                this.calories = 150;
                this.price = 60; // Raised price
                this.type = "Meat";
                preparationMessage = "Slicing Roast Beef...";
                break;
            case "Turkey":
                this.calories = 120;
                this.price = 50; // Raised price
                this.type = "Meat";
                preparationMessage = "Preparing Turkey Slices...";
                break;
            case "Ham":
                this.calories = 100;
                this.price = 50; // Raised price
                this.type = "Meat";
                preparationMessage = "Slicing Ham...";
                break;
            case "Chicken":
                this.calories = 140;
                this.price = 65; // Raised price
                preparationMessage = "Grilling Chicken...";
                break;
            case "Tuna":
                this.calories = 120;
                this.price = 55; // Raised price
                this.type = "Meat";
                preparationMessage = "Flaking Tuna...";
                break;
            case "Bacon":
                this.calories = 80;
                this.price = 40; // Raised price
                this.type = "Meat";
                preparationMessage = "Cooking Bacon...";
                break;
            case "Salami":
                this.calories = 130;
                this.price = 70; // Raised price
                this.type = "Meat";
                preparationMessage = "Slicing Salami...";
                break;
    
            // Cheese Options
            case "Cheddar Cheese":
                this.calories = 110;
                this.price = 45; // Raised price
                this.type = "Cheese";
                preparationMessage = "Slicing Cheddar Cheese...";
                break;
            case "Swiss Cheese":
                this.calories = 100;
                this.price = 40; // Raised price
                this.type = "Cheese";
                preparationMessage = "Cutting Swiss Cheese...";
                break;
            case "Provolone Cheese":
                this.calories = 90;
                this.price = 40; // Raised price
                this.type = "Cheese";
                preparationMessage = "Preparing Provolone Cheese...";
                break;
            case "Pepper Jack Cheese":
                this.calories = 100;
                this.price = 45; // Raised price
                this.type = "Cheese";
                preparationMessage = "Slicing Pepper Jack Cheese...";
                break;
            case "Mozzarella Cheese":
                this.calories = 80;
                this.price = 35; // Raised price
                this.type = "Cheese";
                preparationMessage = "Slicing Mozzarella Cheese...";
                break;
            case "Gouda Cheese":
                this.calories = 95;
                this.price = 45; // Raised price
                this.type = "Cheese";
                preparationMessage = "Slicing Mozzarella Cheese...";
                break;
            case "Blue Cheese":
                this.calories = 120;
                this.price = 55; // Raised price
                this.type = "Cheese";
                preparationMessage = "Slicing Blue Cheese...";
                break;
    
            // Vegetable Options
            case "Lettuce":
                this.calories = 5;
                this.price = 20; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Cleaning and Preparing Lettuce...";
                break;
            case "Tomato":
                this.calories = 15;
                this.price = 25; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Slicing Fresh Tomato...";
                break;
            case "Cucumber":
                this.calories = 10;
                this.price = 25; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Slicing Cucumber...";
                break;
            case "Onion":
                this.calories = 10;
                this.price = 25; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Chopping Onion...";
                break;
            case "Bell Pepper":
                this.calories = 15;
                this.price = 25; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Slicing Bell Pepper...";
                break;
            case "Spinach":
                this.calories = 5;
                this.price = 20; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Preparing Fresh Spinach...";
                break;
            case "Pickles":
                this.calories = 5;
                this.price = 20; // Raised price
                this.type = "Vegetable";
                preparationMessage = "Placing Pickles...";
                break;
    
            // Sauce Options
            case "Mayonnaise":
                this.calories = 100;
                this.price = 30; // Raised price
                this.type = "Sauce";
                preparationMessage = "Spreading Mayonnaise...";
                break;
            case "Mustard":
                this.calories = 10;
                this.price = 20; // Raised price
                this.type = "Sauce";
                preparationMessage = "Adding Mustard...";
                break;
            case "Ketchup":
                this.calories = 20;
                this.price = 20; // Raised price
                this.type = "Sauce";
                preparationMessage = "Squeezing Ketchup...";
                break;
            case "Ranch Dressing":
                this.calories = 90;
                this.price = 35; // Raised price
                this.type = "Sauce";
                preparationMessage = "Drizzling Ranch Dressing...";
                break;
            case "BBQ Sauce":
                this.calories = 50;
                this.price = 25; // Raised price
                this.type = "Sauce";
                preparationMessage = "Applying BBQ Sauce...";
                break;
            case "Pesto":
                this.calories = 80;
                this.price = 35; // Raised price
                this.type = "Sauce";
                preparationMessage = "Spreading Pesto...";
                break;
            case "Hummus":
                this.calories = 70;
                this.price = 35; // Raised price
                this.type = "Sauce";
                preparationMessage = "Serving Hummus...";
                break;
    
            default:
                System.out.println("Item not found.");
                break;
        }
    }
    

    /**
     * Generates the name of a sandwich using the specified bread and meat names.
     * The sandwich name is created by combining the bread name and meat name.
     *
     * @param breadName the name of the bread
     * @param meatName  the name of the meat
     * @return the name of the sandwich
     */
    public String generateSandwichName(String breadName, String meatName) {
        String sandwichName = "";
        String breadNameWithoutBread = breadName.substring(0, breadName.indexOf(" Bread"));
        sandwichName = breadNameWithoutBread + " " + meatName;
        return sandwichName;
    }
}
