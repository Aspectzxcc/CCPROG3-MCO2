import Model.*;
import Controller.*;
import View.*;

/**
 * Main Class to run program
 */
public class Main {
    public static void main(String[] args) {
        // Create instances of the Model, View, and Controller
        VendingMachineFactory vendingMachineFactory = new VendingMachineFactory();
        VendingMachineGUI vendingMachineGUI = new VendingMachineGUI();
        new VendingMachineController(vendingMachineFactory, vendingMachineGUI);
    }
}
