package Controller;

import Model.*;
import View.SpecialVendingFeaturesPanel;
import View.VendingFeaturesPanel;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VendingFeaturesController {
    private VendingFeaturesPanel vendingFeaturesPanel;
    private SpecialVendingFeaturesPanel specialVendingFeaturesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public VendingFeaturesController(VendingFeaturesPanel vendingFeaturesPanel, SpecialVendingFeaturesPanel specialVendingFeaturesPanel, VendingMachineFactory vendingMachineFactory) {
        this.vendingFeaturesPanel = vendingFeaturesPanel;
        this.specialVendingFeaturesPanel = specialVendingFeaturesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listeners for the buttons in the VendingFeaturesPanel using lambda expressions
        this.vendingFeaturesPanel.addCurrencyButtonListener(e -> currencyActionPerformed(e));
        this.vendingFeaturesPanel.addBuyItemButtonListener(e -> buyItemActionPerformed());
        this.vendingFeaturesPanel.addCustomizeSandwichButtonListener(e -> customizeSandwichActionPerformed());
        this.vendingFeaturesPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    // Method to handle currency button click
    private void currencyActionPerformed(ActionEvent e) {
        CashRegister cashRegister = getCurrentCashRegister();

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
        vendingFeaturesPanel.updateInsertedMoney(totalInsertedMoney);

        JOptionPane.showMessageDialog(vendingFeaturesPanel, "Inserted ₱" + denomination + ". Total inserted money: ₱" + totalInsertedMoney, "Inserted Money", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buyItemActionPerformed() {
        // Get the selected row in the JTable
        int selectedRow = vendingFeaturesPanel.getItemTable().getSelectedRow();
    
        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Please select an item to buy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Get the Item name from the selected row
        String itemName = vendingFeaturesPanel.getItemTable().getValueAt(selectedRow, 0).toString();
    
        // Find the corresponding ItemSlot that contains the item to be bought
        ItemSlot itemSlot = findItemSlotByItemName(itemName);
    
        // Check if the itemSlot is found
        if (itemSlot == null) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Item not found in the vending machine.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Check if there are items left in the slot
        if (itemSlot.getItemList().isEmpty()) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Item is out of stock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Get the first item in the itemSlot (assuming each slot contains only one type of item)
        Item itemToBuy = itemSlot.getItemList().get(0);
    
        // Get the price of the item to be bought
        int itemPrice = itemToBuy.getPrice();
    
        // Get the total inserted money from the cash register
        int totalInsertedMoney = getCurrentCashRegister().getInsertedAmount();
    
        // Check if the total inserted money is enough to buy the item
        if (totalInsertedMoney < itemPrice) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Insufficient funds. Please insert more money.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Check if the cash register has enough bills for the price of the item
        if (!getCurrentCashRegister().hasEnoughMoney(itemPrice)) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Unable to provide change.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Get the new amount of the inserted money
        int newInsertedMoney = totalInsertedMoney - itemPrice;
    
        // Transfer the payment from cash register to payment received
        getCurrentCashRegister().transferBillsToPaymentReceived(itemPrice);

        // Reduce the inserted amount and update the cash register
        getCurrentCashRegister().setInsertedAmount(newInsertedMoney);
    
        // Update the item table in the vendingFeaturesPanel with the updated itemSlot data
        itemSlot.removeItemFromList(itemToBuy);
        if (!vendingMachineFactory.isSpecial()) {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
        } else {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
        }
        
        // Add the item to items bought
        getCurrentTransactions().addItemBought(itemToBuy);

        // Update the total sales
        getCurrentTransactions().addTotalSales(itemPrice);

        // Update the ending inventory
        getCurrentTransactions().setEndingInventory(getCurrentTransactions().getEndingInventory() - 1);
    
        // Update the inserted money label in the VendingFeaturesPanel
        vendingFeaturesPanel.updateInsertedMoney(getCurrentCashRegister().getInsertedAmount());
    
        // Show a success message
        JOptionPane.showMessageDialog(vendingFeaturesPanel, "Item bought successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    


    // Method to handle customize sandwich button click
    private void customizeSandwichActionPerformed() {
        // Check if the current vending machine is special
        if (!vendingMachineFactory.isSpecial()) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "This feature is only available for Special Vending Machines.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        specialVendingFeaturesPanel.setItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

        // If it's a special vending machine, show the SpecialVendingFeatures menu
        vendingFeaturesPanel.getCardLayout().show(vendingFeaturesPanel.getMainPanel(), "SpecialVendingFeatures");
    }


    // Method to handle exit button click
    private void exitActionPerformed() {
        int insertedMoney = getCurrentCashRegister().getInsertedAmount();
        if (insertedMoney == 0) {
            // If no money is inserted, simply close the application
            vendingFeaturesPanel.getCardLayout().show(vendingFeaturesPanel.getMainPanel(), "TestVendingMachine");
        } else {
            // Calculate the change to be given
            int changeAmount = insertedMoney;

            // Get the change denominations and quantities from the cash register
            // Assuming cashRegister.calculateChange(changeAmount) returns a Map<Integer, Integer> representing the change
            // You can replace this with your actual logic to calculate change
            // For now, let's assume we have a method called calculateChange that returns the change.
            Map<Integer, Integer> change = getCurrentCashRegister().calculateChange(changeAmount);

            // Display the change as a JOptionPane message
            StringBuilder changeMessage = new StringBuilder("Your Change Received Is: \n");
            for (Map.Entry<Integer, Integer> entry : change.entrySet()) {
                int denomination = entry.getKey();
                int quantity = entry.getValue();
                changeMessage.append("₱").append(denomination).append(": ").append(quantity).append("\n");
            }
            JOptionPane.showMessageDialog(vendingFeaturesPanel, changeMessage.toString(), "Change Amount", JOptionPane.INFORMATION_MESSAGE);

            // Reset the inserted money to zero
            getCurrentCashRegister().setInsertedAmount(0);
            vendingFeaturesPanel.updateInsertedMoney(0);

            vendingFeaturesPanel.getCardLayout().show(vendingFeaturesPanel.getMainPanel(), "TestVendingMachine");
        }
    }

    // Helper method to get the current CashRegister based on whether the vending machine is normal or special
    private CashRegister getCurrentCashRegister() {
        if (!vendingMachineFactory.isSpecial()) {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        } else {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        }
    }

    // Helper method to get the current transactions based on whether the vending machine is normal or special
    private Transactions getCurrentTransactions() {
        if (!vendingMachineFactory.isSpecial()) {
            return vendingMachineFactory.getNormalVM().getTransactions();
        } else {
            return vendingMachineFactory.getSpecialVM().getTransactions();
        }
    }

    // Helper method to find the ItemSlot that contains the item with the given name
    private ItemSlot findItemSlotByItemName(String itemName) {
        if (!vendingMachineFactory.isSpecial()) {
            for (ItemSlot itemSlot : vendingMachineFactory.getNormalVM().getItemSlots()) {
                for (Item item : itemSlot.getItemList()) {
                    if (item.getItemName().equals(itemName)) {
                        return itemSlot;
                    }
                }
             }   
        } else {
            for (ItemSlot itemSlot : vendingMachineFactory.getSpecialVM().getItemSlots()) {
                for (Item item : itemSlot.getItemList()) {
                    if (item.getItemName().equals(itemName)) {
                        return itemSlot;
                    }
                }
             }
        }
        
        return null;
    }
}
