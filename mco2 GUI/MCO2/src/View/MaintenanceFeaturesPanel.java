package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MaintenanceFeaturesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton restockItemsButton;
    private JButton setItemPricesButton;
    private JButton collectMoneyButton;
    private JButton replenishMoneyButton;
    private JButton printTransactionsButton;
    private JButton backButton; 

    public MaintenanceFeaturesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(6, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        // Initialize the buttons
        restockItemsButton = new JButton("Restock Items");
        setItemPricesButton = new JButton("Set Item Prices");
        collectMoneyButton = new JButton("Collect Money");
        replenishMoneyButton = new JButton("Replenish Money");
        printTransactionsButton = new JButton("Print Transactions");
        backButton = new JButton("Back To Test Menu"); // Initialize the back button

        // Initialize the buttons with custom design and colors
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

    public CardLayout getCardLayout() {
        return cardLayout;
    }

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

    // Method to add action listener for the Restock Items button
    public void addRestockItemsButtonListener(ActionListener listener) {
        restockItemsButton.addActionListener(listener);
    }

    // Method to add action listener for the Set Item Prices button
    public void addSetItemPricesButtonListener(ActionListener listener) {
        setItemPricesButton.addActionListener(listener);
    }

    // Method to add action listener for the Collect Money button
    public void addCollectMoneyButtonListener(ActionListener listener) {
        collectMoneyButton.addActionListener(listener);
    }

    // Method to add action listener for the Replenish Money button
    public void addReplenishMoneyButtonListener(ActionListener listener) {
        replenishMoneyButton.addActionListener(listener);
    }

    // Method to add action listener for the Print Transactions button
    public void addPrintTransactionsButtonListener(ActionListener listener) {
        printTransactionsButton.addActionListener(listener);
    }

    // Method to add action listener for the Back button
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
