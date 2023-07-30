package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.VendingMachineController;

public class VendingMachineGUI extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private VendingMachineController controller;

    public VendingMachineGUI() {
        setTitle("Vending Machine Factory Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create panels for different views (starting menu, create vending machine, test vending machine, etc.)
        JPanel startingMenuPanel = createStartingMenuPanel();
        JPanel createVendingMachinePanel = createCreateVendingMachinePanel();
        JPanel testVendingMachinePanel = createTestVendingMachinePanel();
        JPanel createRegularVendingMachinePanel = createRegularVendingMachinePanel();
        JPanel createSpecialVendingMachinePanel = createSpecialVendingMachinePanel();

        // Add panels to the main panel with unique names to identify them
        mainPanel.add(startingMenuPanel, "StartingMenu");
        mainPanel.add(createVendingMachinePanel, "CreateVendingMachine");
        mainPanel.add(testVendingMachinePanel, "TestVendingMachine");
        mainPanel.add(createRegularVendingMachinePanel, "CreateRegularVendingMachine");
        mainPanel.add(createSpecialVendingMachinePanel, "CreateSpecialVendingMachine");

        add(mainPanel);

        setVisible(true);
    }

    public void setController(VendingMachineController controller) {
        this.controller = controller;
    }

    // Helper method to create the starting menu panel
    private JPanel createStartingMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton createVendingMachineBtn = new JButton("Create Vending Machine");
        JButton testVendingMachineBtn = new JButton("Test Vending Machine");
        JButton exitBtn = new JButton("Exit");

        // Add action listeners to the buttons
        createVendingMachineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CreateVendingMachine");
            }
        });

        testVendingMachineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TestVendingMachine");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(createVendingMachineBtn);
        panel.add(testVendingMachineBtn);
        panel.add(exitBtn);

        return panel;
    }

    // Helper method to create the panel for creating a vending machine (you can implement this similarly)
    private JPanel createCreateVendingMachinePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Create panels for choosing regular or special vending machine
        JPanel chooseTypePanel = new JPanel();
        chooseTypePanel.setLayout(new GridLayout(1, 2));

        JButton regularVendingMachineBtn = new JButton("Regular Vending Machine");
        JButton specialVendingMachineBtn = new JButton("Special Vending Machine");

        // Add action listeners to the buttons for choosing the type of vending machine
        regularVendingMachineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CreateRegularVendingMachine");
            }
        });

        specialVendingMachineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "CreateSpecialVendingMachine");
            }
        });

        chooseTypePanel.add(regularVendingMachineBtn);
        chooseTypePanel.add(specialVendingMachineBtn);

        panel.add(chooseTypePanel, BorderLayout.CENTER);

        return panel;
    }

    // Helper method to create the panel for creating a regular vending machine
    private JPanel createRegularVendingMachinePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Vending Machine Configuration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Create panel for the slot input field and continue button
        JPanel slotPanel = new JPanel();
        slotPanel.setLayout(new FlowLayout());

        JLabel slotsLabel = new JLabel("Number of Slots:");
        JTextField slotsInputField = new JTextField(10);

        JButton continueBtn = new JButton("Continue");

        // Add action listener to the continue button
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate the slot input field
                try {
                    int numSlots = Integer.parseInt(slotsInputField.getText());
                    if (numSlots < 8) {
                        JOptionPane.showMessageDialog(VendingMachineGUI.this,
                                "The number of slots must be at least 8.", "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // Proceed to the next step by showing the item input fields
                    //controller.showItemInputFields(numSlots);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VendingMachineGUI.this,
                            "Please enter a valid number for the slots.", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        slotPanel.add(slotsLabel);
        slotPanel.add(slotsInputField);
        slotPanel.add(continueBtn);

        panel.add(slotPanel, BorderLayout.CENTER);

        return panel;
    }

    // Helper method to create the panel for creating a special vending machine
    private JPanel createSpecialVendingMachinePanel() {
        JPanel panel = new JPanel();
        // Implement the GUI components for creating a special vending machine
        return panel;
    }

    // Helper method to create the panel for testing a vending machine (you can implement this similarly)
    private JPanel createTestVendingMachinePanel() {
        JPanel panel = new JPanel();
        // Implement the GUI components for testing a vending machine
        return panel;
    }

    // Add more methods for updating the GUI based on the interactions with the VendingMachineController
}
