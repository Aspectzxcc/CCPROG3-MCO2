package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The MaintenanceFeaturesPanel class represents a panel containing maintenance-related features.
 * It provides buttons to perform actions such as restocking items, setting item prices,
 * collecting money, replenishing money, and printing transactions.
 */
public class MaintenanceFeaturesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton restockItemsButton;
    private JButton setItemPricesButton;
    private JButton collectMoneyButton;
    private JButton replenishMoneyButton;
    private JButton printTransactionsButton;
    private JButton backButton;

    /**
     * Creates a new MaintenanceFeaturesPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public MaintenanceFeaturesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(6, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        // Initialize the buttons
        restockItemsButton = createCustomButton("Restock Items");
        restockItemsButton.setBackground(new Color(255, 165, 0));

        setItemPricesButton = createCustomButton("Set Item Prices");
        setItemPricesButton.setBackground(new Color(255, 50, 10));

        collectMoneyButton = createCustomButton("Collect Money");
        collectMoneyButton.setBackground(new Color(150, 234, 102));

        replenishMoneyButton = createCustomButton("Replenish Money");
        replenishMoneyButton.setBackground(new Color(0, 204, 255));

        printTransactionsButton = createCustomButton("Print Transactions");
        printTransactionsButton.setBackground(new Color(233, 55, 153));

        backButton = createCustomButton("Back To Test Menu");
        backButton.setBackground(new Color(15, 255, 55));

        // Add the buttons to the panel
        add(restockItemsButton);
        add(setItemPricesButton);
        add(collectMoneyButton);
        add(replenishMoneyButton);
        add(printTransactionsButton);
        add(backButton); // Add the back button to the panel
    }

    /**
     * Gets the CardLayout used in the main frame.
     *
     * @return the CardLayout
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Gets the main panel that contains all the panels in the main frame.
     *
     * @return the main panel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Helper method to create custom buttons
    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    /**
     * Adds an ActionListener to the Restock Items button.
     *
     * @param listener the ActionListener to add
     */
    public void addRestockItemsButtonListener(ActionListener listener) {
        restockItemsButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Set Item Prices button.
     *
     * @param listener the ActionListener to add
     */
    public void addSetItemPricesButtonListener(ActionListener listener) {
        setItemPricesButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Collect Money button.
     *
     * @param listener the ActionListener to add
     */
    public void addCollectMoneyButtonListener(ActionListener listener) {
        collectMoneyButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Replenish Money button.
     *
     * @param listener the ActionListener to add
     */
    public void addReplenishMoneyButtonListener(ActionListener listener) {
        replenishMoneyButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Print Transactions button.
     *
     * @param listener the ActionListener to add
     */
    public void addPrintTransactionsButtonListener(ActionListener listener) {
        printTransactionsButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Back button.
     *
     * @param listener the ActionListener to add
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
