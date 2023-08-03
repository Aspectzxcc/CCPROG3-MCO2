package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The TestMenuPanel class represents a panel that displays the test menu options for the vending machine program.
 * It includes buttons for accessing vending machine features, maintenance features, and returning to the starting menu.
 */
public class TestMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton vendingButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new TestMenuPanel with the specified CardLayout and mainPanel.
     *
     * @param cardLayout The CardLayout used for navigation.
     * @param mainPanel  The main panel containing this TestMenuPanel.
     */
    public TestMenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(3, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        vendingButton = new JButton("Vending Features");
        maintenanceButton = new JButton("Maintenance Features");
        exitButton = new JButton("Exit to Starting Menu");

        // Customize the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        vendingButton.setFont(buttonFont);
        maintenanceButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        vendingButton.setBackground(new Color(243, 175, 95)); // Set button background color
        vendingButton.setForeground(Color.WHITE); // Set button text color

        maintenanceButton.setBackground(new Color(153, 204, 255)); // different color
        maintenanceButton.setForeground(Color.WHITE);

        exitButton.setBackground(new Color(100, 255, 193));
        exitButton.setForeground(Color.WHITE);

        // Remove focus border when the button is clicked
        vendingButton.setFocusPainted(false); 
        maintenanceButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        // Add the buttons to the panel
        add(vendingButton);
        add(maintenanceButton);
        add(exitButton);
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
     * Gets the main panel containing this TestMenuPanel.
     *
     * @return The main panel containing this TestMenuPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Adds an ActionListener to the vending features button.
     *
     * @param listener The ActionListener to be added to the vending features button.
     */
    public void addVendingButtonListener(ActionListener listener) {
        vendingButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the maintenance features button.
     *
     * @param listener The ActionListener to be added to the maintenance features button.
     */
    public void addMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
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
