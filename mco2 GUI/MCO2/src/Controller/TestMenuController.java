package Controller;

import View.TestMenuPanel;

public class TestMenuController {
    private TestMenuPanel testMenuPanel;

    public TestMenuController(TestMenuPanel testMenuPanel) {
        this.testMenuPanel = testMenuPanel;

        this.testMenuPanel.addVendingButtonListener(e -> vendingActionPerformed());
        this.testMenuPanel.addMaintenanceButtonListener(e -> maintenanceActionPerformed());
        this.testMenuPanel.addExitButtonListener(e -> exitActionPerformed());
    }

    private void vendingActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "VendingFeatures");
    }

    private void maintenanceActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "MaintenanceFeatures");
    }

    private void exitActionPerformed() {
        testMenuPanel.getCardLayout().show(testMenuPanel.getMainPanel(), "StartingMenu");
    }
}
