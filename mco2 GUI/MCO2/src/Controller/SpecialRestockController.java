package Controller;

import View.SpecialRestockPanel;
import Model.Item;
import Model.ItemSlot;
import Model.SpecialItem;
import Model.Transactions;
import Model.VendingMachineFactory;

import java.util.ArrayList;

import javax.swing.*;

/**
 * The controller class that manages interactions between the SpecialRestockPanel and the model (VendingMachineFactory) for restocking items in the Special Vending Machine.
 * This class handles actions performed by the user on the special restock panel, such as restocking normal and special items and going back to the maintenance features panel.
 */
public class SpecialRestockController {
    private SpecialRestockPanel specialRestockPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the SpecialRestockController class.
     * Initializes the controller and sets up action listeners for the buttons in the SpecialRestockPanel.
     *
     * @param specialRestockPanel The SpecialRestockPanel instance representing the special restock panel.
     * @param vendingMachineFactory The VendingMachineFactory instance representing the model.
     */
    public SpecialRestockController(SpecialRestockPanel specialRestockPanel, VendingMachineFactory vendingMachineFactory) {
        this.specialRestockPanel = specialRestockPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        specialRestockPanel.addRestockButtonListener(e -> restockButtonActionPerformed());
        specialRestockPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

     // Method to handle restock button click
    private void restockButtonActionPerformed() {
        // Get current tabbed pane
        int selectedTab = specialRestockPanel.getSelectedTabIndex();
        if (selectedTab == 0) {
            // Normal Items Tab
            int selectedRow = specialRestockPanel.getNormalItemTable().getSelectedRow();
            if (selectedRow != -1) {
                String itemName = specialRestockPanel.getNormalItemTable().getValueAt(selectedRow, 0).toString();
                askAndRestock(itemName);
            } else {
                JOptionPane.showMessageDialog(specialRestockPanel, "Please select an item to restock.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (selectedTab == 1) {
            // Special Items Tab
            int selectedRow = specialRestockPanel.getSpecialItemTable().getSelectedRow();
            if (selectedRow != -1) {
                String itemName = specialRestockPanel.getSpecialItemTable().getValueAt(selectedRow, 0).toString();
                askAndRestock(itemName);
            } else {
                JOptionPane.showMessageDialog(specialRestockPanel, "Please select an item to restock.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

     // Method to handle back button click
    private void backButtonActionPerformed() {
        // Return to the main menu
        specialRestockPanel.getCardLayout().show(specialRestockPanel.getMainPanel(), "MaintenanceFeatures");
    }

    // Method to ask the user for the quantity to restock and restock the selected item
    private void askAndRestock(String itemName) {
        int selectedTab = specialRestockPanel.getSelectedTabIndex();
        String input = JOptionPane.showInputDialog(specialRestockPanel, "Enter the quantity to restock for \"" + itemName + "\":");
        if (input != null) {
            try {
                int quantity = Integer.parseInt(input);
                if (quantity > 0) {
                    // Restock the item with the given quantity
                    if (selectedTab == 0) {
                        // Normal Items Tab
                        ItemSlot itemSlot = findItemSlotByItemName(itemName);

                        for (int i = 0; i < quantity; i++) {
                            Item item = new Item(itemName);
                            itemSlot.addItemToSlot(item);
                        }

                        // Reset the Items Bought
                        getTransactions().setItemsBought(new ArrayList<Item>());

                        // Update the total sales
                        getTransactions().setTotalSales(0);

                        // Update  the Starting Inventory
                        getTransactions().setStartingInventory(getTransactions().getEndingInventory() + quantity);

                        // Update the ending inventory
                        getTransactions().setEndingInventory(getTransactions().getStartingInventory());

                        specialRestockPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
                    } else if (selectedTab == 1) {
                        // Special Items Tab
                        ArrayList<SpecialItem> specialItemList = findSpecialItemListByItemName(itemName);
                        
                        for (int i = 0; i < quantity; i++) {
                            SpecialItem item = new SpecialItem(itemName);
                            specialItemList.add(item);
                        }

                        // Reset the Items Bought
                        getTransactions().setSpecialItemsBought(new ArrayList<SpecialItem>());

                        // Update the total sales
                        getTransactions().setTotalSales(0);

                        // Update the Starting Inventory
                        getTransactions().setStartingInventory(getTransactions().getEndingInventory() + quantity);

                        // Update the ending inventory
                        getTransactions().setEndingInventory(getTransactions().getStartingInventory());

                        specialRestockPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());
                    }
                    JOptionPane.showMessageDialog(specialRestockPanel, "Successfully restocked " + quantity + " items of \"" + itemName + "\".", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(specialRestockPanel, "Invalid quantity. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(specialRestockPanel, "Invalid quantity. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Helper method to find the ItemSlot that contains the item with the given name
    private ItemSlot findItemSlotByItemName(String itemName) {
        ArrayList<ItemSlot> itemSlots = vendingMachineFactory.getSpecialVM().getItemSlots();
        for (ItemSlot itemSlot : itemSlots) {
            ArrayList<Item> itemList = itemSlot.getItemList();
            if (!itemList.isEmpty() && itemList.get(0).getItemName().equals(itemName)) {
                return itemSlot;
            }
        }
        return null;
    }

    // Helper method to find the List of Special Items that contains the item with the given name
    private ArrayList<SpecialItem> findSpecialItemListByItemName(String itemName) {
        ArrayList<ArrayList<SpecialItem>> specialItemsList = vendingMachineFactory.getSpecialVM().getSpecialItems();
        for (ArrayList<SpecialItem> specialItems : specialItemsList) {
            if (!specialItems.isEmpty() && specialItems.get(0).getItemName().equals(itemName)) {
                return specialItems;
            }
        }
        return null;
    }

    // Helper method to get the Transactions instance from the model
    private Transactions getTransactions() {
        return vendingMachineFactory.getSpecialVM().getTransactions();
    }
}
