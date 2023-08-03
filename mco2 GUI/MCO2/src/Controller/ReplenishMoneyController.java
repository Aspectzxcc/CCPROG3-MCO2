package Controller;

import Model.CashRegister;
import Model.VendingMachineFactory;
import View.ReplenishMoneyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The controller class that manages interactions between the ReplenishMoneyPanel and the VendingMachineFactory.
 * This class handles actions performed by the user on the ReplenishMoneyPanel, such as replenishing money.
 */
public class ReplenishMoneyController {
    private ReplenishMoneyPanel replenishMoneyPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the ReplenishMoneyController class.
     * Initializes the controller and sets up action listeners for the buttons in the ReplenishMoneyPanel.
     *
     * @param replenishMoneyPanel The ReplenishMoneyPanel instance representing the panel with the currency buttons and table.
     * @param vendingMachineFactory The VendingMachineFactory instance representing the vending machine factory that holds the data.
     */
    public ReplenishMoneyController(ReplenishMoneyPanel replenishMoneyPanel, VendingMachineFactory vendingMachineFactory) {
        this.replenishMoneyPanel = replenishMoneyPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listener to the back button
        replenishMoneyPanel.addBackButtonListener(e -> backButtonActionPerformed());

        // Add action listeners to the currency buttons
        replenishMoneyPanel.addCurrencyButtonListener(e -> currencyButtonActionPerformed(e));
    }

    /**
     * Action performed when a currency button is clicked on the ReplenishMoneyPanel.
     * This method replenishes the selected denomination with the specified quantity.
     * If an invalid quantity is entered, an appropriate error message is shown.
     *
     * @param e The ActionEvent representing the click on the currency button.
     */
    private void currencyButtonActionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText(); // Get the text of the clicked button (e.g., "₱20")
        String denominationText = buttonText.substring(1); // Remove the "₱" symbol to get the denomination value
        int denomination = Integer.parseInt(denominationText);

        // Ask for the quantity to replenish for the selected denomination
        String input = JOptionPane.showInputDialog(replenishMoneyPanel, "Enter the quantity to replenish for " + buttonText + " denomination:");
        if (input != null) {
            try {
                int quantity = Integer.parseInt(input);
                if (quantity > 0) {
                    // Replenish the selected denomination with the given quantity
                    getCashRegister().addMoney(denomination, quantity);
                    // Update the denominations table
                    replenishMoneyPanel.updateDenominationsTable(getCashRegister().getCashRegister());
                    JOptionPane.showMessageDialog(replenishMoneyPanel, "Successfully replenished " + quantity + " " + buttonText + " denomination.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(replenishMoneyPanel, "Invalid quantity. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(replenishMoneyPanel, "Invalid quantity. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

     /**
     * Action performed when the "Back" button is clicked on the ReplenishMoneyPanel.
     * This method switches back to the maintenance features panel.
     *
     * @param e The ActionEvent representing the click on the back button.
     */
    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        replenishMoneyPanel.getCardLayout().show(replenishMoneyPanel.getMainPanel(), "MaintenanceFeatures");
    }


    /**
     * Helper method to get the CashRegister object from the VendingMachineFactory.
     * If the vending machine is a special vending machine, it gets the CashRegister from the special vending machine.
     * Otherwise, it gets the CashRegister from the normal vending machine.
     *
     * @return The CashRegister object representing the cash register of the current vending machine.
     */
    private CashRegister getCashRegister() {
        if (vendingMachineFactory.isSpecial()) {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        } else {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        }
    }
}
