package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.CashRegister;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class ReplenishMoneyPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable denominationsTable;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JButton[] currencyButtons;

    public ReplenishMoneyPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Initialize the denominations table
        String[] columnNames = {"Denomination", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        denominationsTable = new JTable(tableModel);

        // Initialize the table scroll pane
        JScrollPane tableScrollPane = new JScrollPane(denominationsTable);

        // Initialize the currency buttons
        JPanel currencyPanel = new JPanel();
        currencyPanel.setLayout(new GridLayout(3, 3, 5, 5));
        int[] denominations = CashRegister.getValidDenominations();
        currencyButtons = new JButton[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            int denomination = denominations[i];
            currencyButtons[i] = new JButton("₱" + String.valueOf(denomination));
            currencyPanel.add(currencyButtons[i]);
        }

        // Initialize the back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        backButton.setBackground(Color.RED); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        backButton.setFocusPainted(false); // Remove focus border

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Align buttons in the center with some spacing
        buttonPanel.add(currencyPanel);
        buttonPanel.add(backButton);

        // Add components to the panel
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateDenominationsTable(Map<Integer, Integer> denominations) {
        // Clear the existing data from the table
        tableModel.setRowCount(0);

        // Add the new data to the table
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            int denomination = entry.getKey();
            int quantity = entry.getValue();
            tableModel.addRow(new Object[]{denomination, quantity});
        }
    }
    
    public void addCurrencyButtonListener(ActionListener listener) {
        for (JButton button : currencyButtons) {
            button.addActionListener(listener);
        }
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
