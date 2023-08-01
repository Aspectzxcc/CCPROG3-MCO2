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
}
