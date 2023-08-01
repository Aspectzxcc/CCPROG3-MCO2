package Model;

import java.util.HashMap;
import java.util.Map;

public class CashRegister {
    private Map<Integer, Integer> cashRegister;
    private Map<Integer, Integer> paymentReceived;
    private int insertedAmount;

    public CashRegister() {
        cashRegister = new HashMap<>();
        insertedAmount = 0;
        initializeDenominations();
    }

    private void initializeDenominations() {
        // Initialize the cash register with all denominations set to 0
        for (int denomination : Money.getValidDenominations()) {
            cashRegister.put(denomination, 100);
        }
    }

    // Add money to the cash register
    public void addMoney(int denomination, int quantity) {
        int currentQuantity = cashRegister.getOrDefault(denomination, 0);
        cashRegister.put(denomination, currentQuantity + quantity);
    }

    // Remove money from the cash register
    public void removeMoney(int denomination, int quantity) {
        int currentQuantity = cashRegister.getOrDefault(denomination, 0);
        int newQuantity = Math.max(0, currentQuantity - quantity);
        cashRegister.put(denomination, newQuantity);
    }

    // Check if the cash register has enough money
    public boolean hasEnoughMoney(int amount) {
        // Greedy algorithm to check if there is enough money to provide change
        for (int denomination : Money.getValidDenominations()) {
            int quantity = cashRegister.getOrDefault(denomination, 0);
            while (amount >= denomination && quantity > 0) {
                amount -= denomination;
                quantity--;
            }
        }
        return amount == 0;
    }

    // Get the quantity of a specific denomination in the cash register
    public int getQuantity(int denomination) {
        return cashRegister.getOrDefault(denomination, 0);
    }

    // Add inserted bills by the user
    public void addInsertedBills(int denomination, int quantity) {
        int currentQuantity = cashRegister.getOrDefault(denomination, 0);
        cashRegister.put(denomination, currentQuantity + quantity);
        insertedAmount += denomination * quantity;
    }

    // Get the total amount of inserted money
    public int getInsertedAmount() {
        return insertedAmount;
    }

    public void setInsertedAmount(int insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    public Map<Integer, Integer> getPaymentReceived() {
        return paymentReceived;
    }

    public void addPaymentReceived(int denomination, int quantity) {
        int currentQuantity = paymentReceived.getOrDefault(denomination, 0);
        paymentReceived.put(denomination, currentQuantity + quantity);
    }

    public void removePaymentReceived(int denomination, int quantity) {
        int currentQuantity = paymentReceived.getOrDefault(denomination, 0);
        int newQuantity = Math.max(0, currentQuantity - quantity);
        paymentReceived.put(denomination, newQuantity);
    }

    public void removeBillsForItemPrice(int itemPrice) {
        int remainingChangeAmount = itemPrice;

        // Iterate through the denominations from highest to lowest
        for (int denomination : Money.getValidDenominations()) {
            int quantityInRegister = cashRegister.getOrDefault(denomination, 0);
            int billsToRemove = Math.min(quantityInRegister, remainingChangeAmount / denomination);
            remainingChangeAmount -= denomination * billsToRemove;
            cashRegister.put(denomination, quantityInRegister - billsToRemove);

            // If the remaining change amount becomes zero, no further calculations are needed
            if (remainingChangeAmount == 0) {
                break;
            }
        }
    }

        // Method to calculate the change to be given
    public Map<Integer, Integer> calculateChange(int changeAmount) {
        Map<Integer, Integer> change = new HashMap<>();
        int[] denominations = Money.getValidDenominations();

        // Iterate through the denominations from the lowest to the highest
        for (int denomination : denominations) {
            // Get the quantity of the current denomination in the cash register
            int quantityInRegister = cashRegister.getOrDefault(denomination, 0);

            // Calculate the number of bills of the current denomination needed for the change
            int billsNeeded = Math.min(changeAmount / denomination, quantityInRegister);

            // Reduce the change amount by the value of the bills of the current denomination
            changeAmount -= denomination * billsNeeded;

            // Store the quantity of the bills of the current denomination in the change map
            if (billsNeeded > 0) {
                change.put(denomination, billsNeeded);
            }

            // If the change amount becomes zero, no further calculations are needed
            if (changeAmount == 0) {
                break;
            }
        }

        // If there is still a remaining change amount, it means that the cash register does not have
        // enough change for the transaction. In this case, return null to indicate an error.
        if (changeAmount > 0) {
            return null;
        }

        // Update the cash register by removing the bills used for change from it
        for (Map.Entry<Integer, Integer> entry : change.entrySet()) {
            int denomination = entry.getKey();
            int quantityInRegister = cashRegister.getOrDefault(denomination, 0);
            int billsNeeded = entry.getValue();
            int newQuantity = Math.max(0, quantityInRegister - billsNeeded);
            cashRegister.put(denomination, newQuantity);
        }

        return change;
    }


    // Print a summary of transactions
    public void printTransactionSummary() {
        System.out.println("Transaction Summary:");
        for (int denomination : Money.getValidDenominations()) {
            int quantity = cashRegister.getOrDefault(denomination, 0);
            System.out.println("Denomination: " + denomination + " - Quantity: " + quantity);
        }
    }
}
