package Model;

import java.util.HashMap;
import java.util.Map;

public class CashRegister {
    private Map<Integer, Integer> cashRegister;
    private Map<Integer, Integer> insertedBills;

    public CashRegister() {
        cashRegister = new HashMap<>();
        insertedBills = new HashMap<>();
        initializeDenominations();
    }

    private void initializeDenominations() {
        // Initialize the cash register with all denominations set to 0
        for (int denomination : Money.getValidDenominations()) {
            cashRegister.put(denomination, 0);
            insertedBills.put(denomination, 0);
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
        int currentQuantity = insertedBills.getOrDefault(denomination, 0);
        insertedBills.put(denomination, currentQuantity + quantity);
    }

    // Remove inserted bills by the user
    public void removeInsertedBills(int denomination, int quantity) {
        int currentQuantity = insertedBills.getOrDefault(denomination, 0);
        int newQuantity = Math.max(0, currentQuantity - quantity);
        insertedBills.put(denomination, newQuantity);
    }

    // Get the quantity of a specific denomination of inserted bills
    public int getInsertedBillQuantity(int denomination) {
        return insertedBills.getOrDefault(denomination, 0);
    }

    // Calculate the total amount of inserted money
    public int calculateTotalInsertedMoney() {
        int total = 0;
        for (int denomination : Money.getValidDenominations()) {
            total += denomination * insertedBills.getOrDefault(denomination, 0);
        }
        return total;
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
