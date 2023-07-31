package Controller;

import View.CreateRegularVendingMachinePanel;
import Model.*; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CreateRegularVendingMachineController {
    private CreateRegularVendingMachinePanel createRegularVendingMachinePanel;
    private VendingMachineFactory vendingMachineFactory;

    public CreateRegularVendingMachineController(CreateRegularVendingMachinePanel createRegularVendingMachinePanel, 
    VendingMachineFactory vendingMachineFactory) {
        this.createRegularVendingMachinePanel = createRegularVendingMachinePanel;
        this.vendingMachineFactory = vendingMachineFactory;
        
        this.createRegularVendingMachinePanel.addSubmitButtonListener(e -> submitActionPerformed());
    }
    
    private void submitActionPerformed() {
        if (validateQuantities()) {
            // Update the item quantities when the Submit button is clicked.
            createRegularVendingMachinePanel.setItemQuantities(new ArrayList<Integer>());

            if (validateQuantities()) {
                for (int i = 0; i < createRegularVendingMachinePanel.getQuantityTextFields().length; i++) {
                String quantityText = createRegularVendingMachinePanel.getQuantityTextFields()[i].getText();
                int quantity = Integer.parseInt(quantityText);
                createRegularVendingMachinePanel.getItemQuantities().add(quantity);
                }

                vendingMachineFactory.setNormalVM(new VendingMachine());
                vendingMachineFactory.setCreated(true);

                ArrayList<String> selectedItems = createRegularVendingMachinePanel.getSelectedItems();
                ArrayList<Integer> itemQuantities = createRegularVendingMachinePanel.getItemQuantities();

                for (int i = 0; i < selectedItems.size(); i++) {
                    String itemName = selectedItems.get(i);
                    int quantity = itemQuantities.get(i);
        
                    // Find the item with the same name in the ItemFactory (if you have one)
                    Item item = new Item(itemName);

                    item.generateItemPreset();
        
                    if (item != null) {
                        // Create a new item slot
                        ItemSlot itemSlot = new ItemSlot();
                        for (int j = 0; j < quantity; j++) {
                            itemSlot.addItemToSlot(item);
                        }
                        // Add the item slot to the vending machine
                        vendingMachineFactory.getNormalVM().addItemSlot(itemSlot);
                    }
                }
                
                createRegularVendingMachinePanel.getCardLayout().show(createRegularVendingMachinePanel.getMainPanel(), "StartingMenu");
                JOptionPane.showMessageDialog(createRegularVendingMachinePanel, "Vending machine created successfully! Redirecting you to Starting Menu.");
            }
        }
    }

    private boolean validateQuantities() {
        for (int i = 0; i < createRegularVendingMachinePanel.getQuantityTextFields().length; i++) {
            String quantityText = createRegularVendingMachinePanel.getQuantityTextFields()[i].getText();
            try {
                int quantity = Integer.parseInt(quantityText);
                if (quantity < 10) {
                    JOptionPane.showMessageDialog(createRegularVendingMachinePanel, "Quantity for " + 
                    createRegularVendingMachinePanel.getSelectedItems().get(i) + " must be 10 or more.");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(createRegularVendingMachinePanel, "Invalid quantity for " + 
                createRegularVendingMachinePanel.getSelectedItems().get(i) + ".");
                return false;
            }
        }
        return true;
    }
    
}