package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The StartingMenuPanel class represents a panel that displays the starting menu options for the vending machine program.
 * It includes buttons for creating a vending machine, testing the vending machine, and exiting the program.
 */
public class StartingMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton createVendingMachineButton;
    private JButton testVendingMachineButton;
    private JButton exitButton;

    /**
     * Creates a new StartingMenuPanel with the specified CardLayout and mainPanel.
     *
     * @param cardLayout The CardLayout used for navigation.
     * @param mainPanel  The main panel containing this StartingMenuPanel.
     */
    public StartingMenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridBagLayout());
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // Load image icons
        ImageIcon vendingMachineIcon = new ImageIcon("mco2 GUI\\MCO2\\lib\\vendingMachineIcon.png");
        vendingMachineIcon = new ImageIcon(vendingMachineIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));

        ImageIcon testVendingMachineIcon = new ImageIcon("mco2 GUI\\MCO2\\lib\\testVendingMachineIcon.png");
        testVendingMachineIcon = new ImageIcon(testVendingMachineIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        ImageIcon exitIcon = new ImageIcon("mco2 GUI\\MCO2\\lib\\exitIcon.png");
        exitIcon = new ImageIcon(exitIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        createVendingMachineButton = new JButton("Create Vending Machine", vendingMachineIcon);
        testVendingMachineButton = new JButton("Test Vending Machine", testVendingMachineIcon);
        exitButton = new JButton("Exit Program");

        // Set button styles
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        createVendingMachineButton.setFont(buttonFont);
        testVendingMachineButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);
        
        // Set preferred button sizes
        createVendingMachineButton.setPreferredSize(new Dimension(350, 100));
        testVendingMachineButton.setPreferredSize(new Dimension(350, 100));
        exitButton.setPreferredSize(new Dimension(350, 100));

        createVendingMachineButton.setBackground(new Color(67, 160, 71));
        createVendingMachineButton.setForeground(Color.WHITE);
        testVendingMachineButton.setBackground(new Color(33, 150, 243));
        testVendingMachineButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(200, 17, 17));
        exitButton.setForeground(Color.WHITE);

        createVendingMachineButton.setFocusPainted(false);
        testVendingMachineButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        // Add buttons to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(createVendingMachineButton, gbc);

        gbc.gridy = 1;
        add(testVendingMachineButton, gbc);

        gbc.gridy = 2;
        add(exitButton, gbc);
    }

    /**
     * Gets the CardLayout used by this panel.
     *
     * @return The CardLayout used by this panel.
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Gets the main panel containing this StartingMenuPanel.
     *
     * @return The main panel containing this StartingMenuPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Adds an ActionListener to the create vending machine button.
     *
     * @param listener The ActionListener to be added to the create vending machine button.
     */

    public void addCreateVendingMachineButtonListener(ActionListener listener) {
        createVendingMachineButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the test vending machine button.
     *
     * @param listener The ActionListener to be added to the test vending machine button.
     */
    public void addTestVendingMachineButtonListener(ActionListener listener) {
        testVendingMachineButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the exit button.
     *
     * @param listener The ActionListener to be added to the exit button.
     */
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
