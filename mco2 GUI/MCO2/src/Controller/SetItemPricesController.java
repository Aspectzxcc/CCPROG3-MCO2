package Controller;

import View.SetItemPricesPanel;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The controller class that manages interactions between the SetItemPricesPanel and the VendingMachineFactory.
 * This class handles actions performed by the user on the SetItemPricesPanel, such as setting the prices for items.
 */
public class SetItemPricesController {
    private SetItemPricesPanel setItemPricesPanel;
    private VendingMachineFactory vendingMachineFactory;

     /**
     * Constructor for the SetItemPricesController class.
     * Initializes the controller and sets up action listeners for the buttons in the SetItemPricesPanel.
     *
     * @param setItemPricesPanel The SetItemPricesPanel instance representing the panel with the table of items and buttons to set prices.
     * @param vendingMachineFactory The VendingMachineFactory instance representing the vending machine factory that holds the data.
     */
    public SetItemPricesController(SetItemPricesPanel setItemPricesPanel, VendingMachineFactory vendingMachineFactory) {
        this.setItemPricesPanel = setItemPricesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listeners to the buttons
        setItemPricesPanel.addSetPricesButtonListener(e -> setPricesActionPerformed());
        setItemPricesPanel.addBackButtonListener(e -> backActionPerformed());
    }

    /**
     * Action performed when the "Set Prices" button is clicked on the SetItemPricesPanel.
     * This method sets the price of the selected item in the table.
     * If no item is selected or an invalid price is entered, appropriate error messages are shown.
     */
    private void setPricesActionPerformed() {
        int selectedRow = setItemPricesPanel.getItemTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(setItemPricesPanel, "Please select an item to restock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String itemName = setItemPricesPanel.getItemTable().getValueAt(selectedRow, 0).toString();
        ItemSlot itemSlot = findItemSlotByItemName(itemName);
        if (itemSlot == null) {
            setItemPricesPanel.getTableModel().setRowCount(0); // Clear the table selection
            return;
        }

        String input = JOptionPane.showInputDialog(setItemPricesPanel, "Enter the new price for \"" + itemName + "\":");

        if (input != null) {
            try {
                int newPrice = Integer.parseInt(input);
                if (newPrice >= 0) {
                    ArrayList<Item> itemList = itemSlot.getItemList();
                    if (!itemList.isEmpty()) {
                        for (Item item : itemList) {
                            item.setPrice(newPrice); // Update the price of the item
                        }
                        setItemPricesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots()); // Update the price in the table
                    }
                    JOptionPane.showMessageDialog(setItemPricesPanel, "Successfully set the new price for \"" + itemName + "\".", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(setItemPricesPanel, "Invalid price. Please enter a non-negative number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(setItemPricesPanel, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Action performed when the "Back" button is clicked on the SetItemPricesPanel.
     * This method switches back to the main menu.
     */
    private void backActionPerformed() {
        // Switch back to the main menu
        setItemPricesPanel.getCardLayout().show(setItemPricesPanel.getMainPanel(), "MaintenanceFeatures");
    }

    /**
     * Find the ItemSlot containing the specified item name.
     *
     * @param itemName The name of the item to find.
     * @return The ItemSlot containing the specified item, or null if not found.
     */
    private ItemSlot findItemSlotByItemName(String itemName) {
        for (ItemSlot itemSlot : vendingMachineFactory.getNormalVM().getItemSlots()) {
            ArrayList<Item> itemList = itemSlot.getItemList();
            if (!itemList.isEmpty()) {
                Item item = itemList.get(0); // Assuming there's only one item in each slot for simplicity
                if (item.getItemName().equals(itemName)) {
                    return itemSlot;
                }
            }
        }
        return null;
    }   
}
