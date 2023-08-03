package Controller;

import Model.VendingMachineFactory;
import View.TestMenuPanel;
import View.VendingFeaturesPanel;

/**
 * The controller class that manages interactions between the TestMenuPanel and the model (VendingMachineFactory).
 * This class handles actions performed by the user on the TestMenuPanel, such as switching to the vending features or maintenance features, and exiting the application.
 */
public class TestMenuController {
    private TestMenuPanel testMenuPanel;
    private VendingFeaturesPanel vendingFeaturesPanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the TestMenuController class.
     * Initializes the controller and sets up action listeners for the buttons in the TestMenuPanel.
     *
     * @param testMenuPanel          The TestMenuPanel instance representing the test menu panel.
     * @param vendingFeaturesPanel   The VendingFeaturesPanel instance representing the main vending features panel.
     * @param vendingMachineFactory  The VendingMachineFactory instance representing the model.
     */
    public TestMenuController(TestMenuPanel testMenuPanel, VendingFeaturesPanel vendingFeaturesPanel, VendingMachineFactory vendingMachineFactory) {
        this.testMenuPanel = testMenuPanel;
        this.vendingFeaturesPanel = vendingFeaturesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        this.testMenuPanel.addVendingButtonListener(e -> vendingActionPerformed());
        this.testMenuPanel.addMaintenanceButtonListener(e -> maintenanceActionPerformed());
        this.testMenuPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    // Method to handle vending button click
    private void vendingActionPerformed() {
        if (vendingMachineFactory.isSpecial() == false) {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
        } else {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
        }

        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "VendingFeatures");
    }

    // Method to handle maintenance button click
    private void maintenanceActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "MaintenanceFeatures");
    }

    // Method to handle exit button click
    private void exitActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "StartingMenu");
    }
}
