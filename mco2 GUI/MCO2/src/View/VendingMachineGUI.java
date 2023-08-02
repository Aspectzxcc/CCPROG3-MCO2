package View;

import javax.swing.*;
import java.awt.*;

public class VendingMachineGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StartingMenuPanel startingMenuPanel;
    private CreateVendingMachinePanel createVendingMachinePanel;
    private ItemSlotInputPanel itemSlotInputPanel;
    private ItemCheckBoxesPanel itemCheckBoxesPanel;
    private SpecialItemCheckBoxesPanel specialItemCheckBoxesPanel;
    private ItemQuantityInputPanel itemQuantityInputPanel;
    private SpecialItemQuantityInputPanel specialItemQuantityInputPanel;
    private TestMenuPanel testMenuPanel;
    private VendingFeaturesPanel vendingFeaturesPanel;
    private SpecialVendingFeaturesPanel specialVendingFeaturesPanel;
    private MaintenanceFeaturesPanel maintenanceFeaturesPanel;
    private RestockItemsPanel restockItemsPanel;
    private SpecialRestockPanel specialRestockPanel;
    private SetItemPricesPanel setItemPricesPanel;
    private SpecialSetPricesPanel specialSetPricesPanel;
    private CollectMoneyPanel collectMoneyPanel;
    private ReplenishMoneyPanel replenishMoneyPanel;
    private PrintTransactionsPanel printTransactionsPanel;

    public VendingMachineGUI() {
        setTitle("Vending Machine Factory Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create panels for different views (starting menu, create vending machine, test vending machine, etc.)
        startingMenuPanel = new StartingMenuPanel(cardLayout, mainPanel);
        createVendingMachinePanel = new CreateVendingMachinePanel(cardLayout, mainPanel);
        itemSlotInputPanel = new ItemSlotInputPanel(cardLayout, mainPanel);
        itemCheckBoxesPanel = new ItemCheckBoxesPanel(cardLayout, mainPanel);
        itemQuantityInputPanel = new ItemQuantityInputPanel(cardLayout, mainPanel);
        specialItemCheckBoxesPanel = new SpecialItemCheckBoxesPanel(cardLayout, mainPanel); 
        specialItemQuantityInputPanel = new SpecialItemQuantityInputPanel(cardLayout, mainPanel);
        testMenuPanel = new TestMenuPanel(cardLayout, mainPanel);
        vendingFeaturesPanel = new VendingFeaturesPanel(cardLayout, mainPanel);
        specialVendingFeaturesPanel = new SpecialVendingFeaturesPanel(cardLayout, mainPanel);
        maintenanceFeaturesPanel = new MaintenanceFeaturesPanel(cardLayout, mainPanel);
        restockItemsPanel = new RestockItemsPanel(cardLayout, mainPanel);
        specialRestockPanel = new SpecialRestockPanel(cardLayout, mainPanel);
        setItemPricesPanel = new SetItemPricesPanel(cardLayout, mainPanel);
        specialSetPricesPanel = new SpecialSetPricesPanel(cardLayout, mainPanel);
        collectMoneyPanel = new CollectMoneyPanel(cardLayout, mainPanel);
        replenishMoneyPanel = new ReplenishMoneyPanel(cardLayout, mainPanel);
        printTransactionsPanel = new PrintTransactionsPanel(cardLayout, mainPanel);

        // Add panels to the main panel with unique names to identify them
        mainPanel.add(startingMenuPanel, "StartingMenu");
        mainPanel.add(createVendingMachinePanel, "CreateVendingMachine");
        mainPanel.add(itemSlotInputPanel, "ItemSlotInput");
        mainPanel.add(itemCheckBoxesPanel, "ItemCheckBoxes");
        mainPanel.add(itemQuantityInputPanel, "ItemQuantityInput");
        mainPanel.add(specialItemCheckBoxesPanel, "SpecialItemCheckBoxes"); 
        mainPanel.add(specialItemQuantityInputPanel, "SpecialItemQuantityInput");
        mainPanel.add(testMenuPanel, "TestVendingMachine");
        mainPanel.add(vendingFeaturesPanel, "VendingFeatures");
        mainPanel.add(specialVendingFeaturesPanel, "SpecialVendingFeatures");
        mainPanel.add(maintenanceFeaturesPanel, "MaintenanceFeatures");
        mainPanel.add(restockItemsPanel, "RestockItems");
        mainPanel.add(specialRestockPanel, "SpecialRestock");
        mainPanel.add(setItemPricesPanel, "SetItemPrices");
        mainPanel.add(specialSetPricesPanel, "SpecialSetPrices");
        mainPanel.add(collectMoneyPanel, "CollectMoney");
        mainPanel.add(replenishMoneyPanel, "ReplenishMoney");
        mainPanel.add(printTransactionsPanel, "PrintTransactions");

        add(mainPanel);

        setVisible(true);
    }

    // Getters for the panels
    public StartingMenuPanel getStartingMenuPanel() {
        return startingMenuPanel;
    }
    
    public CreateVendingMachinePanel getCreateVendingMachinePanel() {
        return createVendingMachinePanel;
    }

    public ItemSlotInputPanel getItemSlotInputPanel() {
        return itemSlotInputPanel;
    }

    public ItemCheckBoxesPanel getItemCheckBoxesPanel() {
        return itemCheckBoxesPanel;
    }

    public ItemQuantityInputPanel getItemQuantityInputPanel() {
        return itemQuantityInputPanel;
    }

    public SpecialItemCheckBoxesPanel getSpecialItemCheckBoxesPanel() {
        return specialItemCheckBoxesPanel;
    }

    public SpecialItemQuantityInputPanel getSpecialItemQuantityInputPanel() {
        return specialItemQuantityInputPanel;
    }

    public TestMenuPanel getTestMenuPanel() {
        return testMenuPanel;
    }

    public VendingFeaturesPanel getVendingFeaturesPanel() {
        return vendingFeaturesPanel;
    }

    public SpecialVendingFeaturesPanel getSpecialVendingFeaturesPanel() {
        return specialVendingFeaturesPanel;
    }

    public MaintenanceFeaturesPanel getMaintenanceFeaturesPanel() {
        return maintenanceFeaturesPanel;
    }

    public RestockItemsPanel getRestockItemsPanel() {
        return restockItemsPanel;
    }

    public SpecialRestockPanel getSpecialRestockPanel() {
        return specialRestockPanel;
    }

    public SetItemPricesPanel getSetItemPricesPanel() {
        return setItemPricesPanel;
    }

    public SpecialSetPricesPanel getSpecialSetPricesPanel() {
        return specialSetPricesPanel;
    }

    public CollectMoneyPanel getCollectMoneyPanel() {
        return collectMoneyPanel;
    }

    public ReplenishMoneyPanel getReplenishMoneyPanel() {
        return replenishMoneyPanel;
    }
    
    public PrintTransactionsPanel getPrintTransactionsPanel() {
        return printTransactionsPanel;
    }
}
