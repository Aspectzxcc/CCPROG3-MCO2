package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;
    }

    // Add methods for handling user interactions with the GUI and updating the VendingMachineFactory accordingly

    // For example:
    public void createRegularVendingMachine(/* Parameters for vending machine configuration */) {
        // Call the appropriate method in VendingMachineFactory to create a regular vending machine
        // Update the GUI to show the created vending machine (if needed)
    }

    public void testVendingMachine(/* Parameters for testing the vending machine */) {
        // Call the appropriate method in VendingMachineFactory to perform tests on the vending machine
        // Update the GUI to show the test results (if needed)
    }

    // Add more methods as required to interact with the VendingMachineFactory and update the GUI
}
