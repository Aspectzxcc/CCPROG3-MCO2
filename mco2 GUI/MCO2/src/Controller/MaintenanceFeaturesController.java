package Controller;

import Model.VendingMachineFactory;
import View.MaintenanceFeaturesPanel;
import View.RestockItemsPanel;
import View.SetItemPricesPanel;
import View.SpecialRestockPanel;
import View.SpecialSetPricesPanel;

public class MaintenanceFeaturesController {
    private MaintenanceFeaturesPanel maintenanceFeaturesPanel;
    private RestockItemsPanel restockItemsPanel;
    private SpecialRestockPanel specialRestockPanel;
    private SetItemPricesPanel setItemPricesPanel;
    private SpecialSetPricesPanel specialSetPricesPanel;
    private VendingMachineFactory vendingMachineFactory;

    public MaintenanceFeaturesController(MaintenanceFeaturesPanel maintenanceFeaturesPanel, RestockItemsPanel restockItemsPanel, 
    SpecialRestockPanel specialRestockPanel, SetItemPricesPanel setItemPricesPanel, SpecialSetPricesPanel specialSetPricesPanel,
    VendingMachineFactory vendingMachineFactory) {
        this.maintenanceFeaturesPanel = maintenanceFeaturesPanel;
        this.restockItemsPanel = restockItemsPanel;
        this.specialRestockPanel = specialRestockPanel;
        this.setItemPricesPanel = setItemPricesPanel;
        this.specialSetPricesPanel = specialSetPricesPanel;
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
            // Set the item data for the RestockItemsPanel
            restockItemsPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
            
            // Move to the RestockItemsPanel
            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "RestockItems");
        } else {
            // Set the item data for the SpecialRestockPanel
            specialRestockPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
            specialRestockPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

            // Move to the SpecialRestockPanel
            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "SpecialRestock");
        }
    }

    // Set Item Prices button action
    private void setItemPricesActionPerformed() {
        // Move to the SetItemPricesPanel
        if (vendingMachineFactory.isSpecial() == false) {
            setItemPricesPanel.setItemData(vendingMachineFactory.getNormalVM().getItemSlots());
            
            setItemPricesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "SetItemPrices");
        } else {
            specialSetPricesPanel.setNormalItemData(vendingMachineFactory.getSpecialVM().getItemSlots());
            specialSetPricesPanel.setSpecialItemData(vendingMachineFactory.getSpecialVM().getSpecialItems());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "SpecialSetPrices");
        }
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
