package Controller;

import Model.*;
import View.*;
import javax.swing.JOptionPane;

/**
 * The controller class that manages interactions between the StartingMenuPanel and the model (VendingMachineFactory).
 * This class handles actions performed by the user on the starting menu panel, such as creating a vending machine, testing the vending machine, and exiting the application.
 */
public class StartingMenuController {
    private StartingMenuPanel startingMenuPanel;
    private VendingMachineGUI vendingMachineGUI;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the StartingMenuController class.
     * Initializes the controller and sets up action listeners for the buttons in the StartingMenuPanel.
     *
     * @param startingMenuPanel      The StartingMenuPanel instance representing the starting menu panel.
     * @param vendingMachineGUI      The VendingMachineGUI instance representing the main GUI.
     * @param vendingMachineFactory  The VendingMachineFactory instance representing the model.
     */
    public StartingMenuController(StartingMenuPanel startingMenuPanel, VendingMachineGUI vendingMachineGUI, VendingMachineFactory vendingMachineFactory) {
        this.startingMenuPanel = startingMenuPanel;
        this.vendingMachineGUI = vendingMachineGUI;
        this.vendingMachineFactory = vendingMachineFactory;

        this.startingMenuPanel.addCreateVendingMachineButtonListener(e -> createActionPerformed());
        this.startingMenuPanel.addTestVendingMachineButtonListener(e -> testActionPerformed());
        this.startingMenuPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    // Method to handle create vending machine button click
    private void createActionPerformed() {
        resetCreateInputs();
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "CreateVendingMachine");
    }

    // Method to handle test vending machine button click
    private void testActionPerformed() {
        if (vendingMachineFactory.isCreated() == false) {
            JOptionPane.showMessageDialog(startingMenuPanel, "Please create a vending machine first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "TestVendingMachine");
        }
        
    }

    // Method to handle exit button click
    private void exitActionPerformed() {
        int option = JOptionPane.showConfirmDialog(startingMenuPanel, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Method to reset create menu inputs
    private void resetCreateInputs() {
        vendingMachineGUI.getItemSlotInputPanel().getSlotsTextField().setText("");
        vendingMachineGUI.getItemQuantityInputPanel().reset();
        vendingMachineGUI.getItemCheckBoxesPanel().resetCheckBoxes();
        vendingMachineGUI.getSpecialItemCheckBoxesPanel().resetCheckBoxes();
        vendingMachineGUI.getSpecialItemQuantityInputPanel().reset();
    }
}
