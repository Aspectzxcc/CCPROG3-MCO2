package Controller;

import Model.*;
import View.*;
import javax.swing.JOptionPane;

public class StartingMenuController {
    private StartingMenuPanel startingMenuPanel;
    private VendingMachineGUI vendingMachineGUI;
    private VendingMachineFactory vendingMachineFactory;

    public StartingMenuController(StartingMenuPanel startingMenuPanel, VendingMachineGUI vendingMachineGUI, VendingMachineFactory vendingMachineFactory) {
        this.startingMenuPanel = startingMenuPanel;
        this.vendingMachineGUI = vendingMachineGUI;
        this.vendingMachineFactory = vendingMachineFactory;

        this.startingMenuPanel.addCreateVendingMachineButtonListener(e -> createActionPerformed());
        this.startingMenuPanel.addTestVendingMachineButtonListener(e -> testActionPerformed());
        this.startingMenuPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    private void createActionPerformed() {
        resetCreateInputs();
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "CreateVendingMachine");
    }

    private void testActionPerformed() {
        if (vendingMachineFactory.isCreated() == false) {
            JOptionPane.showMessageDialog(startingMenuPanel, "Please create a vending machine first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "TestVendingMachine");
        }
        
    }

    private void exitActionPerformed() {
        System.exit(0);
    }

    private void resetCreateInputs() {
        vendingMachineGUI.getItemSlotInputPanel().getSlotsTextField().setText("");
        vendingMachineGUI.getItemQuantityInputPanel().reset();
        vendingMachineGUI.getItemCheckBoxesPanel().resetCheckBoxes();
        vendingMachineGUI.getSpecialItemCheckBoxesPanel().resetCheckBoxes();
        vendingMachineGUI.getSpecialItemQuantityInputPanel().reset();
    }
}
