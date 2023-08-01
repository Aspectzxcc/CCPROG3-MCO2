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
    private JButton backButton; // The back button

    public MaintenanceFeaturesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(6, 1, 10, 10));

        // Initialize the buttons
        restockItemsButton = new JButton("Restock Items");
        setItemPricesButton = new JButton("Set Item Prices");
        collectMoneyButton = new JButton("Collect Money");
        replenishMoneyButton = new JButton("Replenish Money");
        printTransactionsButton = new JButton("Print Transactions");
        backButton = new JButton("Back To Test Menu"); // Initialize the back button

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
