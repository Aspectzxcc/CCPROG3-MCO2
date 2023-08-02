package Controller;

import Model.CashRegister;
import Model.VendingMachineFactory;
import View.CollectMoneyPanel;

import javax.swing.*;
import java.util.Map;

public class CollectMoneyController {
    private CollectMoneyPanel collectMoneyPanel;
    private VendingMachineFactory vendingMachineFactory;

    public CollectMoneyController(CollectMoneyPanel collectMoneyPanel, VendingMachineFactory vendingMachineFactory) {
        this.collectMoneyPanel = collectMoneyPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        // Add action listeners to the buttons
        collectMoneyPanel.addCollectButtonListener(e -> collectButtonActionPerformed());
        collectMoneyPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

    private void updatePaymentReceivedData(int denomination, int quantityToCollect) {
        Map<Integer, Integer> paymentReceived = getCashRegister().getPaymentReceived();

        // Remove the quantity of the denomination from the payment received map
        int quantity = paymentReceived.get(denomination);
        paymentReceived.put(denomination, quantity - quantityToCollect);

        // Update the payment received data
        collectMoneyPanel.setPaymentReceivedData(paymentReceived);
    }

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

    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        collectMoneyPanel.getCardLayout().show(collectMoneyPanel.getMainPanel(), "MaintenanceFeatures");
    }

    // Helper method to get the CashRegister object from the VendingMachineFactory
    private CashRegister getCashRegister() {
        if (vendingMachineFactory.isSpecial() == false) {
            return vendingMachineFactory.getNormalVM().getCashRegister();
        } else {
            return vendingMachineFactory.getSpecialVM().getCashRegister();
        }
    }
}
