package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The CashRegister class represents the cash register of the vending machine.
 * It manages the money stored in the cash register and handles payments and change calculation.
 */
public class CashRegister {
    private static int[] validDenominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

    private Map<Integer, Integer> cashRegister;
    private Map<Integer, Integer> paymentReceived;
    private int insertedAmount;

    /**
     * Constructor for creating a CashRegister object.
     * It initializes the cash register with all denominations set to 0.
     */
    public CashRegister() {
        cashRegister = new HashMap<>();
        paymentReceived = new HashMap<>();
        insertedAmount = 0;
        initializeDenominations();
    }

    // Getters
    public Map<Integer, Integer> getCashRegister() {
        return cashRegister;
    }

    public static int[] getValidDenominations(){
        return validDenominations;
    }

    /**
     * Initializes the cash register with all denominations set to 0.
     */
    private void initializeDenominations() {
        // Initialize the cash register with all denominations set to 0
        for (int denomination : validDenominations) {
            //cashRegister.put(denomination, 100);
            cashRegister.put(denomination, 0);
            paymentReceived.put(denomination, 0);
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
        for (int denomination : validDenominations) {
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

    // Get total payment received
    public int getTotalPaymentReceived() {
        int total = 0;
        for (int denomination : validDenominations) {
            total += denomination * paymentReceived.getOrDefault(denomination, 0);
        }
        return total;
    }

    public void setInsertedAmount(int insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    public Map<Integer, Integer> getPaymentReceived() {
        return paymentReceived;
    }

    // Add money to payment received
    public void addPaymentReceived(int denomination, int quantity) {
        int currentQuantity = paymentReceived.getOrDefault(denomination, 0);
        paymentReceived.put(denomination, currentQuantity + quantity);
    }

    // Remove money from payment received
    public void removePaymentReceived(int denomination, int quantity) {
        int currentQuantity = paymentReceived.getOrDefault(denomination, 0);
        int newQuantity = Math.max(0, currentQuantity - quantity);
        paymentReceived.put(denomination, newQuantity);
    }

    // Collect money from payment received
    public int collectPayment(int denomination, int money) {
        int quantity = paymentReceived.getOrDefault(denomination, 0);
        int amount = Math.min(money, denomination * quantity);
        removePaymentReceived(denomination, amount / denomination);
        return amount;
    }

    public void removeBillsForItemPrice(int itemPrice) {
        int remainingChangeAmount = itemPrice;

        // Iterate through the denominations from highest to lowest
        for (int denomination : validDenominations) {
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

    // transfer bills from cash register to payment received
    public void transferBillsToPaymentReceived(int amount) {
        int[] denominations = validDenominations;
        
        // Iterate through the denominations from the highest to the lowest
        for (int denomination : denominations) {
            // Get the quantity of the current denomination in the cash register
            int quantityInRegister = cashRegister.getOrDefault(denomination, 0);
    
            // Calculate the number of bills of the current denomination needed for the transfer
            int billsToTransfer = Math.min(amount / denomination, quantityInRegister);
    
            // Reduce the remaining amount by the value of the bills of the current denomination
            amount -= denomination * billsToTransfer;
    
            // If there are bills of the current denomination to transfer, update the hashmaps
            if (billsToTransfer > 0) {
                // Update the cashRegister by removing the transferred bills
                int newQuantity = Math.max(0, quantityInRegister - billsToTransfer);
                cashRegister.put(denomination, newQuantity);
                
                // Update the paymentReceived by adding the transferred bills
                int currentReceived = paymentReceived.getOrDefault(denomination, 0);
                paymentReceived.put(denomination, currentReceived + billsToTransfer);
            }
    
            // If the remaining amount becomes zero, no further calculations are needed
            if (amount == 0) {
                break;
            }
        }
    }
    

    /**
     * Calculates the change to be given for a given change amount.
     *
     * @param changeAmount the amount of change to be given
     * @return a map containing the denominations and their corresponding quantities for the change,
     *         or null if there is not enough change in the cash register
     */
    public Map<Integer, Integer> calculateChange(int changeAmount) {
        Map<Integer, Integer> change = new HashMap<>();
        int[] denominations = validDenominations;

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
}

