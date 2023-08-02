package Controller;

import Model.VendingMachineFactory;
import View.MaintenanceFeaturesPanel;
import View.RestockItemsPanel;
import View.SpecialRestockPanel;

public class MaintenanceFeaturesController {
    private MaintenanceFeaturesPanel maintenanceFeaturesPanel;
    private RestockItemsPanel restockItemsPanel;
    private SpecialRestockPanel specialRestockPanel;
    private VendingMachineFactory vendingMachineFactory;

    public MaintenanceFeaturesController(MaintenanceFeaturesPanel maintenanceFeaturesPanel, RestockItemsPanel restockItemsPanel, SpecialRestockPanel specialRestockPanel, VendingMachineFactory vendingMachineFactory) {
        this.maintenanceFeaturesPanel = maintenanceFeaturesPanel;
        this.restockItemsPanel = restockItemsPanel;
        this.specialRestockPanel = specialRestockPanel;
        this.vendingMachineFactory = vendingMachineFactory;

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
        // Check if the vending machine is Special, then set item data accordingly
        if (vendingMachineFactory.isSpecial() == false) {
            restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
            
            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "RestockItems");
        } else {
            specialRestockPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
            specialRestockPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "SpecialRestock");
        }

        // Move to the RestockItemsPanel
    }

    // Set Item Prices button action
    private void setItemPricesActionPerformed() {
        // Move to the SetItemPricesPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "SetItemPrices");
    }

    // Collect Money button action
    private void collectMoneyActionPerformed() {
        // Move to the CollectMoneyPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "CollectMoney");
    }

    // Replenish Money button action
    private void replenishMoneyActionPerformed() {
        // Move to the ReplenishMoneyPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "ReplenishMoney");
    }

    // Print Transactions button action
    private void printTransactionsActionPerformed() {
        // Move to the PrintTransactionsPanel
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "PrintTransactions");
    }

    // Back button action
    private void backActionPerformed() {
        // Switch back to the TestMenuPanel using CardLayout
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "TestVendingMachine");
    }
}
