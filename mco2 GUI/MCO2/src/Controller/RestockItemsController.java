package Controller;

import Model.Item;
import Model.ItemSlot;
import Model.Transactions;
import Model.VendingMachineFactory;
import View.RestockItemsPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * The controller class that manages interactions between the RestockItemsPanel and the VendingMachineFactory.
 * This class handles actions performed by the user on the RestockItemsPanel, such as restocking items.
 */
public class RestockItemsController {
    private RestockItemsPanel restockItemsPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the RestockItemsController class.
     * Initializes the controller and sets up action listeners for the buttons in the RestockItemsPanel.
     *
     * @param restockItemsPanel The RestockItemsPanel instance representing the panel with the table of items and buttons to restock.
     * @param vendingMachineFactory The VendingMachineFactory instance representing the vending machine factory that holds the data.
     */
    public RestockItemsController(RestockItemsPanel restockItemsPanel, VendingMachineFactory vendingMachineFactory) {
        this.restockItemsPanel = restockItemsPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Set the initial data for the item table
        restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());

        // Add action listeners to the buttons
        restockItemsPanel.addRestockButtonListener(e -> restockButtonActionPerformed());
        restockItemsPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

    /**
     * Action performed when the "Restock" button is clicked on the RestockItemsPanel.
     * This method restocks the selected item in the table with the specified quantity.
     * If no item is selected or an invalid restock quantity is entered, appropriate error messages are shown.
     */
    private void restockButtonActionPerformed() {
        JTable itemTable = restockItemsPanel.getItemTable();
        DefaultTableModel tableModel = (DefaultTableModel) itemTable.getModel();

        // Get the selected row from the item table
        int selectedRow = itemTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(restockItemsPanel, "Please select an item to restock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the Item name from the selected row
        String itemName = tableModel.getValueAt(selectedRow, 0).toString();

        // Find the corresponding ItemSlot that contains the item to be restocked
        ItemSlot itemSlot = findItemSlotByItemName(itemName);

        // Check if the itemSlot is found
        if (itemSlot == null) {
            JOptionPane.showMessageDialog(restockItemsPanel, "Item not found in the vending machine.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the quantity to restock from the input field
        int restockQuantity = restockItemsPanel.getRestockQuantity();

        // Check if the restock quantity is valid
        if (restockQuantity <= 0) {
            JOptionPane.showMessageDialog(restockItemsPanel, "Please enter a valid restock quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add new items to the item slot to restock
        for (int i = 0; i < restockQuantity; i++) {
            Item item = new Item(itemName);
            itemSlot.addItemToSlot(item);
        }

        // Reset the Items Bought
        getCurrentTransactions().setItemsBought(new ArrayList<Item>());

        // Update the total sales
        getCurrentTransactions().setTotalSales(0);

        // Update the Starting Inventory
        getCurrentTransactions().setStartingInventory(getCurrentTransactions().getEndingInventory() + restockQuantity);

        // Update the ending inventory
        getCurrentTransactions().setEndingInventory(getCurrentTransactions().getStartingInventory());
        
        // Update the item table in the restockItemsPanel with the updated itemSlot data
        restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());

        // update the Starting and Ending Inventory
        

        // Show a success message
        JOptionPane.showMessageDialog(restockItemsPanel, "Items restocked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Action performed when the "Back" button is clicked on the RestockItemsPanel.
     * This method switches back to the maintenance menu.
     */
    private void backButtonActionPerformed() {
        // Return to the maintenance menu
        restockItemsPanel.getCardLayout().show(restockItemsPanel.getMainPanel(), "MaintenanceFeatures");
    }

     /**
     * Find the ItemSlot containing the specified item name.
     *
     * @param itemName The name of the item to find.
     * @return The ItemSlot containing the specified item, or null if not found.
     */
    private ItemSlot findItemSlotByItemName(String itemName) {
        ArrayList<ItemSlot> itemSlots = vendingMachineFactory.getNormalVM().getItemSlots();
        for (ItemSlot itemSlot : itemSlots) {
            ArrayList<Item> itemList = itemSlot.getItemList();
            if (!itemList.isEmpty() && itemList.get(0).getItemName().equals(itemName)) {
                return itemSlot;
            }
        }
        return null;
    }

    /**
     * Get the current Transactions object from the VendingMachineFactory.
     *
     * @return The Transactions object representing the current transactions in the vending machine.
     */
    private Transactions getCurrentTransactions() {
            return vendingMachineFactory.getNormalVM().getTransactions();
    }
}
