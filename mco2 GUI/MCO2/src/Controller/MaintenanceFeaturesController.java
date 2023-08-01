package Controller;

import View.MaintenanceFeaturesPanel;

public class MaintenanceFeaturesController {
    private MaintenanceFeaturesPanel maintenanceFeaturesPanel;

    public MaintenanceFeaturesController(MaintenanceFeaturesPanel maintenanceFeaturesPanel) {
        this.maintenanceFeaturesPanel = maintenanceFeaturesPanel;

        // Add action listeners to the buttons
        maintenanceFeaturesPanel.addRestockItemsButtonListener(e -> restockItemsActionPerformed());
        maintenanceFeaturesPanel.addSetItemPricesButtonListener(e -> setItemPricesActionPerformed());
        maintenanceFeaturesPanel.addCollectMoneyButtonListener(e -> collectMoneyActionPerformed());
        maintenanceFeaturesPanel.addReplenishMoneyButtonListener(e -> replenishMoneyActionPerformed());
        maintenanceFeaturesPanel.addPrintTransactionsButtonListener(e -> printTransactionsActionPerformed());
        maintenanceFeaturesPanel.addBackButtonListener(e -> backActionPerformed());
    }

    // Restock Items button action
    private void restockItemsActionPerformed() {
        // Move to the RestockItemsPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "restockItems");
    }

    // Set Item Prices button action
    private void setItemPricesActionPerformed() {
        // Move to the SetItemPricesPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "setItemPrices");
    }

    // Collect Money button action
    private void collectMoneyActionPerformed() {
        // Move to the CollectMoneyPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "collectMoney");
    }

    // Replenish Money button action
    private void replenishMoneyActionPerformed() {
        // Move to the ReplenishMoneyPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "replenishMoney");
    }

    // Print Transactions button action
    private void printTransactionsActionPerformed() {
        // Move to the PrintTransactionsPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "printTransactions");
    }

    // Back button action
    private void backActionPerformed() {
        // Switch back to the TestMenuPanel using CardLayout
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "testVendingMachine");
    }
}
