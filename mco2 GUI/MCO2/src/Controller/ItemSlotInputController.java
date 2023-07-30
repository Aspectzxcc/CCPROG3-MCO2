package Controller;

import View.ItemSlotInputPanel;

import javax.swing.*;

public class ItemSlotInputController {
    private ItemSlotInputPanel itemSlotInputPanel;

    public ItemSlotInputController(ItemSlotInputPanel itemSlotInputPanel) {
        this.itemSlotInputPanel = itemSlotInputPanel;

        this.itemSlotInputPanel.addContinueBtnListener(e -> continueActionPerformed());
    }

    private void continueActionPerformed() {
        int slotCount = 0;
        try {
            slotCount = Integer.parseInt(itemSlotInputPanel.getSlotsTextField().getText());
        } catch (NumberFormatException ex) {
            // Handle invalid input (e.g., non-numeric input)
            JOptionPane.showMessageDialog(itemSlotInputPanel, "Please enter a valid number for slots.");
            return;
        }

        if (slotCount >= 8) {
            // Proceed to create vending machine panel
            itemSlotInputPanel.getCardLayout().show(itemSlotInputPanel.getMainPanel(), "CreateRegularVendingMachine");
        } else {
            JOptionPane.showMessageDialog(itemSlotInputPanel, "Please enter at least 8 slots.");
        }
    }
}
