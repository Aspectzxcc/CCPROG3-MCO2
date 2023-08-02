package View;

import javax.swing.*;
import java.awt.*;

/**
 * The main GUI class for the Vending Machine Factory Simulator.
 * This class extends JFrame and sets up the graphical user interface for the application.
 */

public class VendingMachineGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Panels for different views
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

    /**
     * Constructor for the VendingMachineGUI class.
     * Initializes the main JFrame, sets up the CardLayout and the main panel,
     * and creates instances of various panels for different views.
     */

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

     /**
     * Get the StartingMenuPanel instance associated with this GUI.
     *
     * @return The StartingMenuPanel instance.
     */

    public StartingMenuPanel getStartingMenuPanel() {
        return startingMenuPanel;
    }

    /**
     * Get the CreateVendingMachinePanel instance associated with this GUI.
     *
     * @return The CreateVendingMachinePanel instance.
     */
    
    public CreateVendingMachinePanel getCreateVendingMachinePanel() {
        return createVendingMachinePanel;
    }

    /**
     * Get the getItemSlotInputPanel instance associated with this GUI.
     *
     * @return The getItemSlotInputPanel instance.
     */

    public ItemSlotInputPanel getItemSlotInputPanel() {
        return itemSlotInputPanel;
    }

    /**
     * Get the ItemCheckBoxesPanel instance associated with this GUI.
     *
     * @return The ItemCheckBoxesPanel instance.
     */

    public ItemCheckBoxesPanel getItemCheckBoxesPanel() {
        return itemCheckBoxesPanel;
    }

    /**
     * Get the ItemQuantityInputPanel instance associated with this GUI.
     *
     * @return The ItemQuantityInputPanel instance.
     */

    public ItemQuantityInputPanel getItemQuantityInputPanel() {
        return itemQuantityInputPanel;
    }

    /**
     * Get the SpecialItemCheckBoxesPanel instance associated with this GUI.
     *
     * @return The SpecialItemCheckBoxesPanel instance.
     */

    public SpecialItemCheckBoxesPanel getSpecialItemCheckBoxesPanel() {
        return specialItemCheckBoxesPanel;
    }

    /**
     * Get the SpecialItemQuantityInputPanel instance associated with this GUI.
     *
     * @return The SpecialItemQuantityInputPanel instance.
     */

    public SpecialItemQuantityInputPanel getSpecialItemQuantityInputPanel() {
        return specialItemQuantityInputPanel;
    }

    /**
     * Get the TestMenuPanel instance associated with this GUI.
     *
     * @return The TestMenuPanel instance.
     */

    public TestMenuPanel getTestMenuPanel() {
        return testMenuPanel;
    }

    /**
     * Get the VendingFeaturesPanel instance associated with this GUI.
     *
     * @return The VendingFeaturesPanel instance.
     */

    public VendingFeaturesPanel getVendingFeaturesPanel() {
        return vendingFeaturesPanel;
    }

    /**
     * Get the SpecialVendingFeaturesPanel instance associated with this GUI.
     *
     * @return The SpecialVendingFeaturesPanel instance.
     */

    public SpecialVendingFeaturesPanel getSpecialVendingFeaturesPanel() {
        return specialVendingFeaturesPanel;
    }

    /**
     * Get the MaintenanceFeaturesPanel instance associated with this GUI.
     *
     * @return The MaintenanceFeaturesPanel instance.
     */

    public MaintenanceFeaturesPanel getMaintenanceFeaturesPanel() {
        return maintenanceFeaturesPanel;
    }

    /**
     * Get the RestockItemsPanel instance associated with this GUI.
     *
     * @return The RestockItemsPanel instance.
     */

    public RestockItemsPanel getRestockItemsPanel() {
        return restockItemsPanel;
    }

    /**
     * Get the SpecialRestockPanel instance associated with this GUI.
     *
     * @return The SpecialRestockPanel instance.
     */

    public SpecialRestockPanel getSpecialRestockPanel() {
        return specialRestockPanel;
    }

    /**
     * Get the SetItemPricesPanel instance associated with this GUI.
     *
     * @return The SetItemPricesPanel instance.
     */

    public SetItemPricesPanel getSetItemPricesPanel() {
        return setItemPricesPanel;
    }

    /**
     * Get the SpecialSetPricesPanel instance associated with this GUI.
     *
     * @return The SpecialSetPricesPanel instance.
     */

    public SpecialSetPricesPanel getSpecialSetPricesPanel() {
        return specialSetPricesPanel;
    }

    /**
     * Get the CollectMoneyPanel instance associated with this GUI.
     *
     * @return The CollectMoneyPanel instance.
     */

    public CollectMoneyPanel getCollectMoneyPanel() {
        return collectMoneyPanel;
    }

    /**
     * Get the ReplenishMoneyPanel instance associated with this GUI.
     *
     * @return The ReplenishMoneyPanel instance.
     */

    public ReplenishMoneyPanel getReplenishMoneyPanel() {
        return replenishMoneyPanel;
    }

    /**
     * Get the PrintTransactionsPanel instance associated with this GUI.
     *
     * @return The PrintTransactionsPanel instance.
     */
    
    public PrintTransactionsPanel getPrintTransactionsPanel() {
        return printTransactionsPanel;
    }
}
