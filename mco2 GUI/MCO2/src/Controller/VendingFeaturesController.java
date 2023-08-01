package Controller;

import Model.*;
import View.VendingFeaturesPanel;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VendingFeaturesController {
    private VendingFeaturesPanel vendingFeaturesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public VendingFeaturesController(VendingFeaturesPanel vendingFeaturesPanel, VendingMachineFactory vendingMachineFactory) {
        this.vendingFeaturesPanel = vendingFeaturesPanel;
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
        int totalInsertedMoney = cashRegister.calculateTotalInsertedMoney();
        
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
        int totalInsertedMoney = getCurrentCashRegister().calculateTotalInsertedMoney();
    
        // Check if the total inserted money is enough to buy the item
        if (totalInsertedMoney < itemPrice) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Insufficient funds. Please insert more money.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Get the denomination of the bill to be used for the transaction
        int billDenomination = getBillDenominationForTransaction(itemPrice);
    
        // Check if the cash register has enough bills of the selected denomination
        if (!getCurrentCashRegister().hasEnoughMoney(billDenomination)) {
            JOptionPane.showMessageDialog(vendingFeaturesPanel, "Unable to provide change.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Update the cash register by removing the bill used for the transaction
        getCurrentCashRegister().removeMoney(billDenomination, 1);
    
        // Remove the bought item from the itemSlot
        itemSlot.removeItemFromList(itemToBuy);
    
        // Update the item table in the vendingFeaturesPanel with the updated itemSlot data
        vendingFeaturesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
    
        // Update the inserted money label in the VendingFeaturesPanel
        vendingFeaturesPanel.updateInsertedMoney(getCurrentCashRegister().calculateTotalInsertedMoney());
    
        // Show a success message
        JOptionPane.showMessageDialog(vendingFeaturesPanel, "Item bought successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to handle customize sandwich button click
    private void customizeSandwichActionPerformed() {
        // Implement the action for customizing a sandwich here
    }

    // Method to handle exit button click
    private void exitActionPerformed() {
        vendingFeaturesPanel.getCardLayout().show(vendingFeaturesPanel.getMainPanel(), "TestVendingMachine");
    }

    // Helper method to get the current CashRegister based on whether the vending machine is normal or special
    private CashRegister getCurrentCashRegister() {
        if (!vendingMachineFactory.isSpecial()) {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        } else {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        }
    }

    // Helper method to find the ItemSlot that contains the item with the given name
    private ItemSlot findItemSlotByItemName(String itemName) {
        for (ItemSlot itemSlot : vendingMachineFactory.getNormalVM().getItemSlots()) {
            for (Item item : itemSlot.getItemList()) {
                if (item.getItemName().equals(itemName)) {
                    return itemSlot;
                }
            }
        }
        return null;
    }
    
    // Helper method to get the denomination of the bill to be used for the transaction
    private int getBillDenominationForTransaction(int itemPrice) {
        int[] denominations = Money.getValidDenominations();
        for (int denomination : denominations) {
            if (denomination <= itemPrice) {
                return denomination;
            }
        }
        // If there's no bill of suitable denomination, return 0 (error case)
        return 0;
    }
}
