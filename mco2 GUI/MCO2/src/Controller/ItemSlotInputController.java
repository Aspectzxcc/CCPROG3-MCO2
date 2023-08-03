package Controller;

import View.ItemSlotInputPanel;
import javax.swing.*;

/**
 * The controller class that manages interactions with the ItemSlotInputPanel.
 * This class handles actions performed by the user on the ItemSlotInputPanel,
 * such as continuing to create the vending machine panel with the specified number of slots.
 */
public class ItemSlotInputController {
    private ItemSlotInputPanel itemSlotInputPanel;

    /**
     * Constructor for the ItemSlotInputController class.
     * Initializes the controller and sets up action listeners for the buttons in the ItemSlotInputPanel.
     *
     * @param itemSlotInputPanel The ItemSlotInputPanel instance representing the panel for inputting the number of slots.
     */
    public ItemSlotInputController(ItemSlotInputPanel itemSlotInputPanel) {
        this.itemSlotInputPanel = itemSlotInputPanel;

        this.itemSlotInputPanel.addContinueButtonListener(e -> continueActionPerformed());
    }

     /**
     * Action performed when the user clicks the continue button.
     * Validates the input for the number of slots and proceeds to create the vending machine panel if the input is valid.
     */
    private void continueActionPerformed() {
        int slotCount = 0;
        try {
            slotCount = Integer.parseInt(itemSlotInputPanel.getSlotsTextField().getText());
        } catch (NumberFormatException ex) {
            // Handle invalid input (e.g., non-numeric input)
            JOptionPane.showMessageDialog(itemSlotInputPanel, "Please enter a valid number for slots.");
            return;
        }

        if (slotCount >= 8 && slotCount <= 10) {
            // Proceed to create vending machine panel
            itemSlotInputPanel.getCardLayout().show(itemSlotInputPanel.getMainPanel(), "ItemCheckBoxes");
        } else if (slotCount < 8) {
            JOptionPane.showMessageDialog(itemSlotInputPanel, "Please enter at least 8 slots.");
        } else if (slotCount > 10) {
            JOptionPane.showMessageDialog(itemSlotInputPanel, "Please enter at most 10 slots.");
        }
    }
}
