package Controller;

import Model.CashRegister;
import Model.VendingMachineFactory;
import View.CollectMoneyPanel;

import javax.swing.*;
import java.util.Map;

/**
 * The controller class that manages interactions with the CollectMoneyPanel.
 * This class handles actions performed by the user on the CollectMoneyPanel,
 * such as collecting money from the vending machine's cash register.
 */
public class CollectMoneyController {
    private CollectMoneyPanel collectMoneyPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the CollectMoneyController class.
     * Initializes the controller and sets up action listeners for the buttons in the CollectMoneyPanel.
     *
     * @param collectMoneyPanel The CollectMoneyPanel instance representing the panel for collecting money from the cash register.
     * @param vendingMachineFactory The VendingMachineFactory instance used to get the cash register of the vending machine.
     */
    public CollectMoneyController(CollectMoneyPanel collectMoneyPanel, VendingMachineFactory vendingMachineFactory) {
        this.collectMoneyPanel = collectMoneyPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listeners to the buttons
        collectMoneyPanel.addCollectButtonListener(e -> collectButtonActionPerformed());
        collectMoneyPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

    /**
     * Helper method to update the payment received data after collecting money from the cash register.
     *
     * @param denomination The denomination of the money being collected.
     * @param quantityToCollect The quantity of money to collect for the given denomination.
     */
    private void updatePaymentReceivedData(int denomination, int quantityToCollect) {
        Map<Integer, Integer> paymentReceived = getCashRegister().getPaymentReceived();

        // Remove the quantity of the denomination from the payment received map
        int quantity = paymentReceived.get(denomination);
        paymentReceived.put(denomination, quantity - quantityToCollect);

        // Update the payment received data
        collectMoneyPanel.setPaymentReceivedData(paymentReceived);
    }

    /**
     * Action performed when the user clicks the "Collect" button to collect money from the cash register.
     */
    private void collectButtonActionPerformed() {
        int selectedRow = collectMoneyPanel.getSelectedRow();
        if (selectedRow != -1) {
            int denomination = collectMoneyPanel.getPaymentTable().getValueAt(selectedRow, 0).hashCode();
    
            String input = JOptionPane.showInputDialog(collectMoneyPanel, "Enter the quantity to collect for " + denomination + ":");
            if (input != null && !input.isEmpty()) {
                try {
                    int quantityToCollect = Integer.parseInt(input);
                    Map<Integer, Integer> paymentReceived = getCashRegister().getPaymentReceived();
                    int currentQuantity = paymentReceived.getOrDefault(denomination, 0);

                    if (quantityToCollect > currentQuantity) {
                        JOptionPane.showMessageDialog(collectMoneyPanel, "Not enough " + "₱" + denomination + " to collect.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (quantityToCollect > 0) {
                        int amount = getCashRegister().collectPayment(denomination, quantityToCollect);
                        if (amount > 0) {
                            JOptionPane.showMessageDialog(collectMoneyPanel, "Collected " + amount + " " + "₱" + denomination + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
                            // Update the displayed payment received data after collection
                            updatePaymentReceivedData(denomination, quantityToCollect);
                        } else {
                            JOptionPane.showMessageDialog(collectMoneyPanel, "There is no " + "₱" + denomination + " to collect.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(collectMoneyPanel, "Please enter a positive quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(collectMoneyPanel, "Invalid quantity. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(collectMoneyPanel, "Please select a row to collect.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Action performed when the user clicks the "Back" button to go back to the maintenance features panel.
     */
    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        collectMoneyPanel.getCardLayout().show(collectMoneyPanel.getMainPanel(), "MaintenanceFeatures");
    }

    /**
     * Helper method to get the CashRegister object from the VendingMachineFactory.
     *
     * @return The CashRegister object of the vending machine.
     */
    private CashRegister getCashRegister() {
        if (vendingMachineFactory.isSpecial() == false) {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        } else {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        }
    }
}
