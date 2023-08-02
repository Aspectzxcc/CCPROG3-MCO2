package Controller;

import View.SpecialSetPricesPanel;
import Model.Item;
import Model.ItemSlot;
import Model.SpecialItem;
import Model.VendingMachineFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SpecialSetPricesController {
    private SpecialSetPricesPanel specialSetPricesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public SpecialSetPricesController(SpecialSetPricesPanel specialSetPricesPanel, VendingMachineFactory vendingMachineFactory) {
        this.specialSetPricesPanel = specialSetPricesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Set initial data for the special item table
        specialSetPricesPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

        // Add action listeners
        specialSetPricesPanel.addSetPricesButtonListener(this::setPricesActionPerformed);
        specialSetPricesPanel.addBackButtonListener(this::backActionPerformed);
    }

    private void setPricesActionPerformed(ActionEvent e) {
        // Get current tabbed pane
        int selectedTab = specialSetPricesPanel.getSelectedTabIndex();
        if (selectedTab == 0) {
            // Normal Items Tab
            int selectedRow = specialSetPricesPanel.getNormalItemTable().getSelectedRow();
            if (selectedRow != -1) {
                String itemName = specialSetPricesPanel.getNormalItemTable().getValueAt(selectedRow, 0).toString();
                askAndSetPrice(itemName);
            } else {
                JOptionPane.showMessageDialog(specialSetPricesPanel, "Please select an item to change price.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (selectedTab == 1) {
            // Special Items Tab
            int selectedRow = specialSetPricesPanel.getSpecialItemTable().getSelectedRow();
            if (selectedRow != -1) {
                String itemName = specialSetPricesPanel.getSpecialItemTable().getValueAt(selectedRow, 0).toString();
                askAndSetPrice(itemName);
            } else {
                JOptionPane.showMessageDialog(specialSetPricesPanel, "Please select an item to change price.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void backActionPerformed(ActionEvent e) {
        // Switch back to the main menu
        specialSetPricesPanel.getCardLayout().show(specialSetPricesPanel.getMainPanel(), "mainMenu");
    }

    private void askAndSetPrice(String itemName) {
        int selectedTab = specialSetPricesPanel.getSelectedTabIndex();
        String input = JOptionPane.showInputDialog(specialSetPricesPanel, "Enter the new price for \"" + itemName + "\":");
        if (input != null) {
            try {
                int price = Integer.parseInt(input);
                if (price >= 0) {
                    if (selectedTab == 0) {
                        // Normal Items Tab
                        ItemSlot itemSlot = findItemSlotByItemName(itemName);

                        for (int i = 0; i < itemSlot.getItemList().size(); i++) {
                            Item item = itemSlot.getItemList().get(i);
                            item.setPrice(price);
                        }
                        specialSetPricesPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
                    } else if (selectedTab == 1) {
                        // Special Items Tab
                        ArrayList<SpecialItem> specialItemList = findSpecialItemListByItemName(itemName);
                        
                        for (int i = 0; i < specialItemList.size(); i++) {
                            SpecialItem item = specialItemList.get(i);
                            item.setPrice(price);
                        }
                        specialSetPricesPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());
                    }
                } else {
                    JOptionPane.showMessageDialog(specialSetPricesPanel, "Invalid price. Please enter a non-negative number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(specialSetPricesPanel, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
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
