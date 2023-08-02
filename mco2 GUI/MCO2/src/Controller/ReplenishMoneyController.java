package Controller;

import Model.CashRegister;
import Model.VendingMachineFactory;
import View.ReplenishMoneyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReplenishMoneyController {
    private ReplenishMoneyPanel replenishMoneyPanel;
    private VendingMachineFactory vendingMachineFactory;

    public ReplenishMoneyController(ReplenishMoneyPanel replenishMoneyPanel, VendingMachineFactory vendingMachineFactory) {
        this.replenishMoneyPanel = replenishMoneyPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listener to the back button
        replenishMoneyPanel.addBackButtonListener(e -> backButtonActionPerformed());

        // Add action listeners to the currency buttons
        replenishMoneyPanel.addCurrencyButtonListener(e -> currencyButtonActionPerformed(e));
    }

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

    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        replenishMoneyPanel.getCardLayout().show(replenishMoneyPanel.getMainPanel(), "MaintenanceFeatures");
    }

    // Helper method to get the CashRegister object from the VendingMachineFactory
    private CashRegister getCashRegister() {
        if (vendingMachineFactory.isSpecial()) {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        } else {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        }
    }
}
