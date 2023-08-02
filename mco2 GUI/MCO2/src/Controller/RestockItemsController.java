package Controller;

import Model.Item;
import Model.ItemSlot;
import Model.VendingMachineFactory;
import View.RestockItemsPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class RestockItemsController {
    private RestockItemsPanel restockItemsPanel;
    private VendingMachineFactory vendingMachineFactory;

    public RestockItemsController(RestockItemsPanel restockItemsPanel, VendingMachineFactory vendingMachineFactory) {
        this.restockItemsPanel = restockItemsPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Set the initial data for the item table
        restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());

        // Add action listeners to the buttons
        restockItemsPanel.addRestockButtonListener(e -> restockButtonActionPerformed());
        restockItemsPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

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
        
        // Update the item table in the restockItemsPanel with the updated itemSlot data
        restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());

        // Show a success message
        JOptionPane.showMessageDialog(restockItemsPanel, "Items restocked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void backButtonActionPerformed() {
        // Return to the maintenance menu
        restockItemsPanel.getCardLayout().show(restockItemsPanel.getMainPanel(), "MaintenanceFeatures");
    }

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
}
