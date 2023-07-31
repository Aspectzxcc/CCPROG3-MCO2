package Model;

public class SpecialItem extends Item{
    private String preparationMessage;

    public SpecialItem(String itemName) {
        super(itemName);
    }

    public String getPreparationMessage() {
        return preparationMessage;
    }

    public void generateSpecialItemPreset() {
        switch (this.itemName) {
            // Bread Options
            case "White Bread":
                this.calories = 80;
                this.price = 10;
                System.out.println("Slicing White Bread...");
                break;
            case "Whole Wheat Bread":
                this.calories = 90;
                this.price = 12;
                System.out.println("Cutting Whole Wheat Bread...");
                break;
            case "Multigrain Bread":
                this.calories = 100;
                this.price = 15;
                System.out.println("Preparing Multigrain Bread...");
                break;
            case "Rye Bread":
                this.calories = 110;
                this.price = 13;
                System.out.println("Slicing Rye Bread...");
                break;
            case "Baguette":
                this.calories = 120;
                this.price = 18;
                System.out.println("Preparing Baguette...");
                break;
            case "Ciabatta":
                this.calories = 130;
                this.price = 20;
                System.out.println("Cutting Ciabatta Bread...");
                break;
            case "Wrap":
                this.calories = 110;
                this.price = 15;
                System.out.println("Warming up the Wrap...");
                break;
            
            // Meat Options
            case "Roast Beef":
                this.calories = 150;
                this.price = 25;
                System.out.println("Slicing Roast Beef...");
                break;
            case "Turkey":
                this.calories = 120;
                this.price = 20;
                System.out.println("Preparing Turkey Slices...");
                break;
            case "Ham":
                this.calories = 100;
                this.price = 18;
                System.out.println("Slicing Ham...");
                break;
            case "Chicken":
                this.calories = 140;
                this.price = 22;
                System.out.println("Grilling Chicken...");
                break;
            case "Tuna":
                this.calories = 120;
                this.price = 20;
                System.out.println("Flaking Tuna...");
                break;
            case "Bacon":
                this.calories = 80;
                this.price = 12;
                System.out.println("Cooking Bacon...");
                break;
            case "Salami":
                this.calories = 130;
                this.price = 23;
                System.out.println("Slicing Salami...");
                break;

            // Cheese Options
            case "Cheddar Cheese":
                this.calories = 110;
                this.price = 17;
                System.out.println("Slicing Cheddar Cheese...");
                break;
            case "Swiss Cheese":
                this.calories = 100;
                this.price = 15;
                System.out.println("Cutting Swiss Cheese...");
                break;
            case "Provolone Cheese":
                this.calories = 90;
                this.price = 14;
                System.out.println("Preparing Provolone Cheese...");
                break;
            case "Pepper Jack Cheese":
                this.calories = 100;
                this.price = 16;
                System.out.println("Slicing Pepper Jack Cheese...");
                break;
            case "Mozzarella Cheese":
                this.calories = 80;
                this.price = 12;
                System.out.println("Slicing Mozzarella Cheese...");
                break;
            case "Gouda Cheese":
                this.calories = 95;
                this.price = 18;
                System.out.println("Slicing Mozzarella Cheese...");
                break;
            case "Blue Cheese":
                this.calories = 120;
                this.price = 22;
                System.out.println("Slicing Mozzarella Cheese...");
                break;

            // Vegetable Options
            case "Lettuce":
                this.calories = 5;
                this.price = 5;
                System.out.println("Cleaning and Preparing Lettuce...");
                break;
            case "Tomato":
                this.calories = 15;
                this.price = 8;
                System.out.println("Slicing Fresh Tomato...");
                break;
            case "Cucumber":
                this.calories = 10;
                this.price = 6;
                System.out.println("Slicing Cucumber...");
                break;
            case "Onion":
                this.calories = 10;
                this.price = 6;
                System.out.println("Chopping Onion...");
                break;
            case "Bell Pepper":
                this.calories = 15;
                this.price = 8;
                System.out.println("Slicing Bell Pepper...");
                break;
            case "Spinach":
                this.calories = 5;
                this.price = 5;
                System.out.println("Preparing Fresh Spinach...");
                break;
            case "Pickles":
                this.calories = 5;
                this.price = 5;
                System.out.println("Placing Pickles...");
                break;

            // Sauce Options
            case "Mayonnaise":
                this.calories = 100;
                this.price = 10;
                System.out.println("Spreading Mayonnaise...");
                break;
            case "Mustard":
                this.calories = 10;
                this.price = 3;
                System.out.println("Adding Mustard...");
                break;
            case "Ketchup":
                this.calories = 20;
                this.price = 5;
                System.out.println("Squeezing Ketchup...");
                break;
            case "Ranch Dressing":
                this.calories = 90;
                this.price = 16;
                System.out.println("Drizzling Ranch Dressing...");
                break;
            case "BBQ Sauce":
                this.calories = 50;
                this.price = 9;
                System.out.println("Applying BBQ Sauce...");
                break;
            case "Pesto":
                this.calories = 80;
                this.price = 14;
                System.out.println("Spreading Pesto...");
                break;
            case "Hummus":
                this.calories = 70;
                this.price = 12;
                System.out.println("Serving Hummus...");
                break;
            default:
                System.out.println("Item not found.");
                break;
        }
    }
    


}
