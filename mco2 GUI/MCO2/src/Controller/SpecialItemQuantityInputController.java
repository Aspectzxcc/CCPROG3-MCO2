package Controller;

import View.SpecialItemQuantityInputPanel;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;

public class SpecialItemQuantityInputController {
    private SpecialItemQuantityInputPanel specialItemQuantityInputPanel;
    private VendingMachineFactory vendingMachineFactory;

    public SpecialItemQuantityInputController(SpecialItemQuantityInputPanel specialItemQuantityInputPanel, VendingMachineFactory vendingMachineFactory) {
        this.specialItemQuantityInputPanel = specialItemQuantityInputPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listener for the submit button
        this.specialItemQuantityInputPanel.addSubmitButtonListener(e -> submitActionPerformed());
    }

    private void submitActionPerformed() {
        // Get the quantities entered by the user for each special item
        JTextField[] quantityTextFields = specialItemQuantityInputPanel.getQuantityTextFields();
        ArrayList<Integer> specialItemQuantities = new ArrayList<>();

        for (JTextField textField : quantityTextFields) {
            try {
                int quantity = Integer.parseInt(textField.getText());
                specialItemQuantities.add(quantity);
            } catch (NumberFormatException ex) {
                // Show an error message if the quantity is not a valid integer
                JOptionPane.showMessageDialog(specialItemQuantityInputPanel,
                        "Please enter a valid integer quantity for each special item.",
                        "Invalid Quantity",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Check if any quantity is missing (not entered)
        if (specialItemQuantities.contains(0)) {
            // Show an error message that the user has not entered the quantity for some special items
            JOptionPane.showMessageDialog(specialItemQuantityInputPanel,
                    "Please enter the quantity for each special item.",
                    "Missing Quantity",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            specialItemQuantityInputPanel.setSpecialItemQuantities(specialItemQuantities);

            ArrayList<String> selectedSpecialItems = specialItemQuantityInputPanel.getSelectedSpecialItems();

            for(int i = 0; i < selectedSpecialItems.size(); i++) {
                String itemName = selectedSpecialItems.get(i);
                int quantity = specialItemQuantities.get(i);

                SpecialItem specialItem = new SpecialItem(itemName);

                specialItem.generateItemPreset();

                if (specialItem != null) {
                    // Create a new item slot
                    ArrayList<SpecialItem> specialItemList = new ArrayList<>();
                    for (int j = 0; j < quantity; j++) {
                        specialItemList.add(specialItem);
                    }
                    // Add the item slot to the vending machine
                    vendingMachineFactory.getSpecialVM().addSpecialItems(specialItemList);
                }
            }

            JOptionPane.showMessageDialog(specialItemQuantityInputPanel, "Special Items Successfully Added! Redirecting to Starting Menu.");
            specialItemQuantityInputPanel.getCardLayout().show(specialItemQuantityInputPanel.getMainPanel(), "StartingMenu");
        }
    }
}
