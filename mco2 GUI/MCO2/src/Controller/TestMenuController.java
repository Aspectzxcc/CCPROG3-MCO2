package Controller;

import Model.VendingMachineFactory;
import View.TestMenuPanel;
import View.VendingFeaturesPanel;

public class TestMenuController {
    private TestMenuPanel testMenuPanel;
    private VendingFeaturesPanel vendingFeaturesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public TestMenuController(TestMenuPanel testMenuPanel, VendingFeaturesPanel vendingFeaturesPanel, VendingMachineFactory vendingMachineFactory) {
        this.testMenuPanel = testMenuPanel;
        this.vendingFeaturesPanel = vendingFeaturesPanel;
        this.vendingMachineFactory = vendingMachineFactory;

        this.testMenuPanel.addVendingButtonListener(e -> vendingActionPerformed());
        this.testMenuPanel.addMaintenanceButtonListener(e -> maintenanceActionPerformed());
        this.testMenuPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    private void vendingActionPerformed() {
        if (vendingMachineFactory.isSpecial() == false) {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
        } else {
            vendingFeaturesPanel.setItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
        }

        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "VendingFeatures");
    }

    private void maintenanceActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "MaintenanceFeatures");
    }

    private void exitActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "StartingMenu");
    }
}
