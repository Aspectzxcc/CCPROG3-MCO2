package Controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.*;
import View.SpecialVendingFeaturesPanel;

public class SpecialVendingFeaturesController {
    private SpecialVendingFeaturesPanel specialVendingFeaturesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public SpecialVendingFeaturesController(SpecialVendingFeaturesPanel specialVendingFeaturesPanel, VendingMachineFactory vendingMachineFactory) {
        this.specialVendingFeaturesPanel = specialVendingFeaturesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listeners to the buy item button and create custom sandwich button
        specialVendingFeaturesPanel.addCurrencyButtonListener(e -> currencyActionPerformed(e));
        specialVendingFeaturesPanel.addBuyItemButtonListener(e -> buyItemActionPerformed());
        specialVendingFeaturesPanel.addCreateCustomSandwichButtonListener(e -> createCustomSandwichActionPerformed());
        specialVendingFeaturesPanel.addBackButtonListener(e -> backActionPerformed());
    }

    // Method to handle currency button click
    private void currencyActionPerformed(ActionEvent e) {
        CashRegister cashRegister = vendingMachineFactory.getSpecialVM().getCashRegister();

        // Get the source of the event (the clicked currency button)
        JButton button = (JButton) e.getSource();

        // Get the text of the button (which contains the denomination)
        String buttonText = button.getText();

        // Extract the denomination from the button text and convert it to an integer
        int denomination = Integer.parseInt(buttonText.replace("₱", ""));

        // Increment the quantity of the inserted bills in the cash register for the corresponding denomination 
        cashRegister.addInsertedBills(denomination, 1);

        // Calculate the total inserted money
        int totalInsertedMoney = cashRegister.getInsertedAmount();
        
        // Update the inserted money label in the VendingFeaturesPanel
        specialVendingFeaturesPanel.updateInsertedMoney(totalInsertedMoney);

        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Inserted ₱" + denomination + ". Total inserted money: ₱" + totalInsertedMoney, "Inserted Money", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buyItemActionPerformed() {
        // Get the cash register and special vending machine
        CashRegister cashRegister = vendingMachineFactory.getSpecialVM().getCashRegister();
        SpecialVendingMachine specialVendingMachine = vendingMachineFactory.getSpecialVM();

        // Get the selected row from the item table
        int selectedRow = specialVendingFeaturesPanel.getItemTable().getSelectedRow();
    
        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Please select an item to buy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the Item name from the selected row
        String itemName = specialVendingFeaturesPanel.getItemTable().getValueAt(selectedRow, 0).toString();

        // Get the List of Special Items with the same name as the selected item
        ArrayList<SpecialItem> selectedItem = findSpecialItemArrayListByItemName(itemName);
    
        // Check if the selected item is found
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Item not found in the vending machine.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if there are items left in the List of Special Items
        if (selectedItem.isEmpty()) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Item is out of stock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the first item in the List of Special Items (assuming that all items in the List of Special Items are the same)
        SpecialItem specialItem = selectedItem.get(0);

        // Get the price of the item
        int itemPrice = specialItem.getPrice();

        // Get the total inserted money from the cash register
        int totalInsertedMoney = cashRegister.getInsertedAmount();

        // Check if the total inserted money is enough to buy the item
        if (totalInsertedMoney < itemPrice) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the cash register has enough bills for the price of the item
        if (!cashRegister.hasEnoughMoney(itemPrice)) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Not enough bills in the cash register.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the new amount of the inserted money 
        int newInsertedMoney = totalInsertedMoney - itemPrice;

        // Transfer the payment from cash register to payment received
        cashRegister.transferBillsToPaymentReceived(itemPrice);

        // Reduce the inserted amount and update the cash register
        cashRegister.setInsertedAmount(newInsertedMoney);

        // Remove the item from the List of Special Items
        selectedItem.remove(specialItem);

        // Update the option indicator for the item bought
        specialVendingFeaturesPanel.updateOptionIndicator(specialItem.getType(), specialItem.getItemName());

        // Update the item table in the VendingFeaturesPanel
        specialVendingFeaturesPanel.setItemData(specialVendingMachine.getSpecialItems());

        // Update the inserted money label in the VendingFeaturesPanel
        specialVendingFeaturesPanel.updateInsertedMoney(cashRegister.getInsertedAmount());

        // Update the total calories label in the VendingFeaturesPanel
        specialVendingFeaturesPanel.addTotalCalories(specialItem.getCalories());

        // Show a success message
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Item bought successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void createCustomSandwichActionPerformed() {
        // Check if all option indicators are set
        if (specialVendingFeaturesPanel.isOptionIndicatorSet("Bread") || 
        specialVendingFeaturesPanel.isOptionIndicatorSet("Meat") || 
        specialVendingFeaturesPanel.isOptionIndicatorSet("Cheese") ||
        specialVendingFeaturesPanel.isOptionIndicatorSet("Vegetable") || 
        specialVendingFeaturesPanel.isOptionIndicatorSet("Sauce")) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Please select all options.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the values in the option indicators
        String breadType = specialVendingFeaturesPanel.getBreadLabel().getText().replace("Bread: ", "");
        String meatType = specialVendingFeaturesPanel.getMeatLabel().getText().replace("Meat: ", "");
        String cheeseType = specialVendingFeaturesPanel.getCheeseLabel().getText().replace("Cheese: ", "");
        String vegetableType = specialVendingFeaturesPanel.getVegetableLabel().getText().replace("Vegetable: ", "");
        String sauceType = specialVendingFeaturesPanel.getSauceLabel().getText().replace("Sauce: ", "");

        // Create a new item for each option
        SpecialItem breadItem = new SpecialItem(breadType);
        SpecialItem meatItem = new SpecialItem(meatType);
        SpecialItem cheeseItem = new SpecialItem(cheeseType);
        SpecialItem vegetableItem = new SpecialItem(vegetableType);
        SpecialItem sauceItem = new SpecialItem(sauceType);

        // Get the total calories of the custom sandwich
        int totalCalories = breadItem.getCalories() + meatItem.getCalories() 
        + cheeseItem.getCalories() + vegetableItem.getCalories() + sauceItem.getCalories();

        // Get the total price of the custom sandwich
        int totalPrice = breadItem.getPrice() + meatItem.getPrice() + cheeseItem.getPrice() + vegetableItem.getPrice() + sauceItem.getPrice();

        // Display the preparation message of each item
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, breadItem.getPreparationMessage(), "Preparing Bread", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, meatItem.getPreparationMessage(), "Preparing Meat", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, cheeseItem.getPreparationMessage(), "Preparing Cheese ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, vegetableItem.getPreparationMessage(), "Preparing Vegetable", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, sauceItem.getPreparationMessage(), "Preparing Sauce", JOptionPane.INFORMATION_MESSAGE);
        

        // Create the Custom Sandwich
        SpecialItem customSandwich = new SpecialItem("Custom Sandwich", totalPrice, totalCalories);
        customSandwich.generateSandwichName(breadType, meatType);

        // Reset the option indicators and the item table
        specialVendingFeaturesPanel.resetOptionIndicators();
        specialVendingFeaturesPanel.setItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

        // Display the custom sandwich name
        JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "Your " + customSandwich.getItemName() + " has been Created!", "Custom Sandwich", JOptionPane.INFORMATION_MESSAGE);
    }

    private void backActionPerformed() {
        // Check if a payment has been received
        if (vendingMachineFactory.getSpecialVM().getCashRegister().getTotalPaymentReceived() > 0) {
            JOptionPane.showMessageDialog(specialVendingFeaturesPanel, "You can not return yet since you have already bought an item!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        specialVendingFeaturesPanel.getCardLayout().show(specialVendingFeaturesPanel.getMainPanel(), "VendingFeatures");
    }

    private ArrayList<SpecialItem> findSpecialItemArrayListByItemName(String itemName) {
    ArrayList<ArrayList<SpecialItem>> specialItemsList = vendingMachineFactory.getSpecialVM().getSpecialItems();
    for (ArrayList<SpecialItem> specialItems : specialItemsList) {
        for (SpecialItem specialItem : specialItems) {
            if (specialItem.getItemName().equals(itemName)) {
                return specialItems;
            }
        }
    }

    return null;
    }
}