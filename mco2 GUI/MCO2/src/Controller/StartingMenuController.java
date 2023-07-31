package Controller;

import javax.swing.JTextField;

import View.*;

public class StartingMenuController {
    private StartingMenuPanel startingMenuPanel;
    private VendingMachineGUI vendingMachineGUI;

    public StartingMenuController(StartingMenuPanel startingMenuPanel, VendingMachineGUI vendingMachineGUI) {
        this.startingMenuPanel = startingMenuPanel;
        this.vendingMachineGUI = vendingMachineGUI;

        this.startingMenuPanel.addCreateVendingMachineButtonListener(e -> createActionPerformed());
        this.startingMenuPanel.addTestVendingMachineButtonListener(e -> testActionPerformed());
    }

    private void createActionPerformed() {
        resetCreateInputs();
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "CreateVendingMachine");
    }

    private void testActionPerformed() {
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "TestVendingMachine");
    }

    private void resetCreateInputs() {
        vendingMachineGUI.getItemSlotInputPanel().getSlotsTextField().setText("");

        vendingMachineGUI.getItemCheckBoxesPanel().resetCheckBoxes();
        for (JTextField textField : vendingMachineGUI.getCreateRegularVendingMachinePanel().getQuantityTextFields())
            textField.setText("");
        
        vendingMachineGUI.getSpecialItemCheckBoxesPanel().resetCheckBoxes();
    }
}
