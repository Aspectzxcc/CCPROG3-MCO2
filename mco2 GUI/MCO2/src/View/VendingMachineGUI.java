package View;

import javax.swing.*;
import java.awt.*;
import Controller.VendingMachineController;

public class VendingMachineGUI extends JFrame {
    private CardLayout cardLayout;
    private VendingMachineController controller;
    private JPanel mainPanel;
    private StartingMenuPanel startingMenuPanel;
    private CreateVendingMachinePanel createVendingMachinePanel;
    private ItemSlotInputPanel itemSlotInputPanel;
    private CreateRegularVendingMachinePanel createRegularVendingMachinePanel;
    private CreateSpecialVendingMachinePanel createSpecialVendingMachinePanel;
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
        createRegularVendingMachinePanel = new CreateRegularVendingMachinePanel(cardLayout, mainPanel);
        createSpecialVendingMachinePanel = new CreateSpecialVendingMachinePanel(cardLayout, mainPanel);
        testVendingMachinePanel = new TestVendingMachinePanel(cardLayout, mainPanel);

        // Add panels to the main panel with unique names to identify them
        mainPanel.add(startingMenuPanel, "StartingMenu");
        mainPanel.add(createVendingMachinePanel, "CreateVendingMachine");
        mainPanel.add(itemSlotInputPanel, "ItemSlotInput");
        mainPanel.add(createRegularVendingMachinePanel, "CreateRegularVendingMachine");
        mainPanel.add(createSpecialVendingMachinePanel, "CreateSpecialVendingMachine");
        mainPanel.add(testVendingMachinePanel, "TestVendingMachine");

        add(mainPanel);

        setVisible(true);
    }

    public StartingMenuPanel getStartingMenuPanel() {
        return startingMenuPanel;
    }
    
    public CreateVendingMachinePanel getCreateVendingMachinePanel() {
        return createVendingMachinePanel;
    }

    public ItemSlotInputPanel getItemSlotInputPanel() {
        return itemSlotInputPanel;
    }

    public CreateRegularVendingMachinePanel getCreateRegularVendingMachinePanel() {
        return createRegularVendingMachinePanel;
    }

    public CreateSpecialVendingMachinePanel getCreateSpecialVendingMachinePanel() {
        return createSpecialVendingMachinePanel;
    }

    public TestVendingMachinePanel getTestVendingMachinePanel() {
        return testVendingMachinePanel;
    }

    public void setController(VendingMachineController controller) {
        this.controller = controller;
    }



    // Add more methods for updating the GUI based on the interactions with the VendingMachineController
}
