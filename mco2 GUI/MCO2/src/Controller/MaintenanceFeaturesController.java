package Controller;

import Model.VendingMachineFactory;
import View.CollectMoneyPanel;
import View.MaintenanceFeaturesPanel;
import View.PrintTransactionsPanel;
import View.ReplenishMoneyPanel;
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
    private CollectMoneyPanel collectMoneyPanel;
    private ReplenishMoneyPanel replenishMoneyPanel;
    private PrintTransactionsPanel printTransactionsPanel;
    private VendingMachineFactory vendingMachineFactory;

    public MaintenanceFeaturesController(MaintenanceFeaturesPanel maintenanceFeaturesPanel, RestockItemsPanel restockItemsPanel, 
    SpecialRestockPanel specialRestockPanel, SetItemPricesPanel setItemPricesPanel, SpecialSetPricesPanel specialSetPricesPanel,
    CollectMoneyPanel collectMoneyPanel, ReplenishMoneyPanel replenishMoneyPanel, PrintTransactionsPanel printTransactionsPanel,
    VendingMachineFactory vendingMachineFactory) {
        this.maintenanceFeaturesPanel = maintenanceFeaturesPanel;
        this.restockItemsPanel = restockItemsPanel;
        this.specialRestockPanel = specialRestockPanel;
        this.setItemPricesPanel = setItemPricesPanel;
        this.specialSetPricesPanel = specialSetPricesPanel;
        this.collectMoneyPanel = collectMoneyPanel;
        this.replenishMoneyPanel = replenishMoneyPanel;
        this.printTransactionsPanel = printTransactionsPanel;
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
        if (vendingMachineFactory.isSpecial() == false) {
            collectMoneyPanel.setPaymentReceivedData(vendingMachineFactory.getNormalVM().getCashRegister().getPaymentReceived());
            
            setItemPricesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "CollectMoney");
        } else {
            collectMoneyPanel.setPaymentReceivedData(vendingMachineFactory.getSpecialVM().getCashRegister().getPaymentReceived());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "CollectMoney");
        }
    }

    // Replenish Money button action
    private void replenishMoneyActionPerformed() {
        // Move to the ReplenishMoneyPanel
        if (vendingMachineFactory.isSpecial() == false) {
            replenishMoneyPanel.updateDenominationsTable(vendingMachineFactory.getNormalVM().getCashRegister().getCashRegister());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "ReplenishMoney");
        } else {
            replenishMoneyPanel.updateDenominationsTable(vendingMachineFactory.getSpecialVM().getCashRegister().getCashRegister());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "ReplenishMoney");
        }
    }

    // Print Transactions button action
    private void printTransactionsActionPerformed() {
        // Move to the PrintTransactionsPanel
        if (vendingMachineFactory.isSpecial() == false) {
            printTransactionsPanel.setNormalItems(vendingMachineFactory.getNormalVM().getTransactions().getItemsBought());
            printTransactionsPanel.setSpecialItems(vendingMachineFactory.getNormalVM().getTransactions().getSpecialItemsBought());
            printTransactionsPanel.setStartingInventory(vendingMachineFactory.getNormalVM().getTransactions().getStartingInventory());
            printTransactionsPanel.setEndingInventory(vendingMachineFactory.getNormalVM().getTransactions().getEndingInventory());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "PrintTransactions");
        } else {
            printTransactionsPanel.setNormalItems(vendingMachineFactory.getSpecialVM().getTransactions().getItemsBought());
            printTransactionsPanel.setSpecialItems(vendingMachineFactory.getSpecialVM().getTransactions().getSpecialItemsBought());
            printTransactionsPanel.setStartingInventory(vendingMachineFactory.getSpecialVM().getTransactions().getStartingInventory());
            printTransactionsPanel.setEndingInventory(vendingMachineFactory.getSpecialVM().getTransactions().getEndingInventory());

            maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "PrintTransactions");
        }
    }

    // Back button action
    private void backActionPerformed() {
        // Switch back to the TestMenuPanel using CardLayout
        maintenanceFeaturesPanel.getCardLayout().show(maintenanceFeaturesPanel.getMainPanel(), "TestVendingMachine");
    }
}
