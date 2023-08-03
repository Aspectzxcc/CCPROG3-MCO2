package Controller;

import View.ItemQuantityInputPanel;
import Model.*; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * The controller class that manages interactions with the ItemQuantityInputPanel.
 * This class handles actions performed by the user on the ItemQuantityInputPanel,
 * such as submitting the item quantities for creating the vending machine.
 */
public class ItemQuantityInputController {
    private ItemQuantityInputPanel itemQuantityInputPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the ItemQuantityInputController class.
     * Initializes the controller and sets up action listeners for the buttons in the ItemQuantityInputPanel.
     *
     * @param itemQuantityInputPanel The ItemQuantityInputPanel instance representing the panel for inputting item quantities.
     * @param vendingMachineFactory The VendingMachineFactory instance for creating the vending machine.
     */
    public ItemQuantityInputController(ItemQuantityInputPanel itemQuantityInputPanel, VendingMachineFactory vendingMachineFactory) {
        this.itemQuantityInputPanel = itemQuantityInputPanel;
        this.vendingMachineFactory = vendingMachineFactory;
        
        this.itemQuantityInputPanel.addSubmitButtonListener(e -> submitActionPerformed());
    }
    
    /**
     * Action performed when the user clicks the submit button.
     * Validates the item quantities and proceeds to create the vending machine if the input is valid.
     */
    protected void submitActionPerformed() {
        if (validateQuantities()) {
            // Update the item quantities when the Submit button is clicked.
            itemQuantityInputPanel.setItemQuantities(new ArrayList<Integer>());

            if (validateQuantities()) {
                for (int i = 0; i < itemQuantityInputPanel.getQuantityTextFields().length; i++) {
                    String quantityText = itemQuantityInputPanel.getQuantityTextFields()[i].getText();
                    int quantity = Integer.parseInt(quantityText);
                    itemQuantityInputPanel.getItemQuantities().add(quantity);
                }

                if (vendingMachineFactory.isSpecial() == false) {
                    vendingMachineFactory.setNormalVM(new VendingMachine());
                } else {
                    vendingMachineFactory.setSpecialVM(new SpecialVendingMachine());
                }
                
                vendingMachineFactory.setCreated(true);

                ArrayList<String> selectedItems = itemQuantityInputPanel.getSelectedItems();
                ArrayList<Integer> itemQuantities = itemQuantityInputPanel.getItemQuantities();

                VendingMachine VendingMachine = getVendingMachine();

                for (int i = 0; i < selectedItems.size(); i++) {
                    String itemName = selectedItems.get(i);
                    int quantity = itemQuantities.get(i);
        
                    Item item = new Item(itemName);

                    item.generateItemPreset();
        
                    if (item != null) {
                        // Create a new item slot
                        ItemSlot itemSlot = new ItemSlot();
                        for (int j = 0; j < quantity; j++) {
                            itemSlot.addItemToSlot(item);
                        }

                        // Add the item slot to the vending machine
                        VendingMachine.addItemSlot(itemSlot);
                    }

                    // Add Starting Inventory
                    Transactions transactions = VendingMachine.getTransactions();
                    transactions.setStartingInventory(transactions.getStartingInventory() + quantity);

                    // The ending inventory is the same as the starting inventory at the start
                    transactions.setEndingInventory(transactions.getStartingInventory());
                }
                
                if (vendingMachineFactory.isSpecial() == false) {
                    itemQuantityInputPanel.getCardLayout().show(itemQuantityInputPanel.getMainPanel(), "StartingMenu");
                    JOptionPane.showMessageDialog(itemQuantityInputPanel, "Vending machine created successfully! Redirecting you to Starting Menu.");
                } else {
                    itemQuantityInputPanel.getCardLayout().show(itemQuantityInputPanel.getMainPanel(), "SpecialItemCheckBoxes");
                    JOptionPane.showMessageDialog(itemQuantityInputPanel, "Vending machine created successfully! Please Choose your Special Items.");
                }
                
            }
        }
    }

    /**
     * Validates the item quantities input by the user.
     *
     * @return True if the input is valid, False otherwise.
     */
    private boolean validateQuantities() {
        for (int i = 0; i < itemQuantityInputPanel.getQuantityTextFields().length; i++) {
            String quantityText = itemQuantityInputPanel.getQuantityTextFields()[i].getText();
            try {
                int quantity = Integer.parseInt(quantityText);
                if (quantity < 10) {
                    JOptionPane.showMessageDialog(itemQuantityInputPanel, "Quantity for " + 
                    itemQuantityInputPanel.getSelectedItems().get(i) + " must be 10 or more.");
                    return false;
                } else if (quantity > 20) {
                    JOptionPane.showMessageDialog(itemQuantityInputPanel, "Quantity for " + 
                    itemQuantityInputPanel.getSelectedItems().get(i) + " must be 20 or less.");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(itemQuantityInputPanel, "Invalid quantity for " + 
                itemQuantityInputPanel.getSelectedItems().get(i) + ".");
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to get the current vending machine.
     *
     * @return The VendingMachine instance representing the current vending machine.
     */
    public VendingMachine getVendingMachine() {
        if (vendingMachineFactory.isSpecial() == false) {
            return vendingMachineFactory.getNormalVM();
        } else {
            return vendingMachineFactory.getSpecialVM();
        }
    }
    
}