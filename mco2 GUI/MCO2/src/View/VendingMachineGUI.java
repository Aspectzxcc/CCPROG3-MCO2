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
    private SpecialItemRadioButtonsPanel specialItemRadioButtonsPanel;
    private ItemQuantityInputPanel itemQuantityInputPanel;
    private SpecialItemQuantityInputPanel specialItemQuantityInputPanel;
    private TestVendingMachinePanel testVendingMachinePanel;

    public VendingMachineGUI() {
        setTitle("Vending Machine Factory Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create panels for different views (starting menu, create vending machine, test vending machine, etc.)
        startingMenuPanel = new StartingMenuPanel(cardLayout, mainPanel);
        createVendingMachinePanel = new CreateVendingMachinePanel(cardLayout, mainPanel);
        itemSlotInputPanel = new ItemSlotInputPanel(cardLayout, mainPanel);
        itemCheckBoxesPanel = new ItemCheckBoxesPanel(cardLayout, mainPanel);
        itemQuantityInputPanel = new ItemQuantityInputPanel(cardLayout, mainPanel);
        specialItemRadioButtonsPanel = new SpecialItemRadioButtonsPanel(cardLayout, mainPanel); 
        specialItemQuantityInputPanel = new SpecialItemQuantityInputPanel(cardLayout, mainPanel);
        testVendingMachinePanel = new TestVendingMachinePanel(cardLayout, mainPanel);

        // Add panels to the main panel with unique names to identify them
        mainPanel.add(startingMenuPanel, "StartingMenu");
        mainPanel.add(createVendingMachinePanel, "CreateVendingMachine");
        mainPanel.add(itemSlotInputPanel, "ItemSlotInput");
        mainPanel.add(itemCheckBoxesPanel, "ItemCheckBoxes");
        mainPanel.add(itemQuantityInputPanel, "ItemQuantityInput");
        mainPanel.add(specialItemRadioButtonsPanel, "SpecialItemRadioButtons"); 
        mainPanel.add(specialItemQuantityInputPanel, "SpecialItemQuantityInput");
        mainPanel.add(testVendingMachinePanel, "TestVendingMachine");

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

    public SpecialItemRadioButtonsPanel getSpecialItemRadioButtonsPanel() {
        return specialItemRadioButtonsPanel;
    }

    public SpecialItemQuantityInputPanel getSpecialItemQuantityInputPanel() {
        return specialItemQuantityInputPanel;
    }

    public TestVendingMachinePanel getTestVendingMachinePanel() {
        return testVendingMachinePanel;
    }
}
