package Controller;

import View.SpecialRestockPanel;
import Model.Item;
import Model.ItemSlot;
import Model.SpecialItem;
import Model.VendingMachineFactory;

import java.util.ArrayList;

import javax.swing.*;

public class SpecialRestockController {
    private SpecialRestockPanel specialRestockPanel;
    private VendingMachineFactory vendingMachineFactory;

    public SpecialRestockController(SpecialRestockPanel specialRestockPanel, VendingMachineFactory vendingMachineFactory) {
        this.specialRestockPanel = specialRestockPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        specialRestockPanel.addRestockButtonListener(e -> restockButtonActionPerformed());
        specialRestockPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

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

    private void backButtonActionPerformed() {
        // Return to the main menu
        specialRestockPanel.getCardLayout().show(specialRestockPanel.getMainPanel(), "main");
    }

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
                        specialRestockPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
                    } else if (selectedTab == 1) {
                        // Special Items Tab
                        ArrayList<SpecialItem> specialItemList = findSpecialItemListByItemName(itemName);
                        
                        for (int i = 0; i < quantity; i++) {
                            SpecialItem item = new SpecialItem(itemName);
                            specialItemList.add(item);
                        }
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

    private ArrayList<SpecialItem> findSpecialItemListByItemName(String itemName) {
        ArrayList<ArrayList<SpecialItem>> specialItemsList = vendingMachineFactory.getSpecialVM().getSpecialItems();
        for (ArrayList<SpecialItem> specialItems : specialItemsList) {
            if (!specialItems.isEmpty() && specialItems.get(0).getItemName().equals(itemName)) {
                return specialItems;
            }
        }
        return null;
    }
}
