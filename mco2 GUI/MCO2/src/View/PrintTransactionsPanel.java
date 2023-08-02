package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Item;
import Model.SpecialItem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrintTransactionsPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JTable normalItemsTable;
    private JTable specialItemsTable;
    private DefaultTableModel normalItemsTableModel;
    private DefaultTableModel specialItemsTableModel;
    private JScrollPane normalItemsScrollPane;
    private JScrollPane specialItemsScrollPane;
    private JLabel startingInventoryLabel;
    private JLabel endingInventoryLabel;
    private JButton backButton;

    public PrintTransactionsPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Create the JTabbedPane
        tabbedPane = new JTabbedPane();

        // Initialize the table models for normal items and special items
        String[] normalItemsColumnNames = {"Item Name", "Price (PHP)", "Calories"};
        normalItemsTableModel = new DefaultTableModel(normalItemsColumnNames, 0);
        normalItemsTable = new JTable(normalItemsTableModel);
        normalItemsScrollPane = new JScrollPane(normalItemsTable);

        String[] specialItemsColumnNames = {"Item Name", "Price (PHP)", "Calories", "Type"};
        specialItemsTableModel = new DefaultTableModel(specialItemsColumnNames, 0);
        specialItemsTable = new JTable(specialItemsTableModel);
        specialItemsScrollPane = new JScrollPane(specialItemsTable);

        // Add the normal items and special items tables to the tabbed pane
        tabbedPane.addTab("Normal Items", normalItemsScrollPane);
        tabbedPane.addTab("Special Items", specialItemsScrollPane);

        // Initialize the labels for starting and ending inventory
        startingInventoryLabel = new JLabel("Starting Inventory: 0");
        startingInventoryLabel.setFont(new Font("Arial", Font.BOLD, 16));

        endingInventoryLabel = new JLabel("Ending Inventory: 0");
        endingInventoryLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Initialize the back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        backButton.setBackground(Color.RED); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        backButton.setFocusPainted(false); // Remove focus border

        // Create a panel to hold the starting and ending inventory labels
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(2, 1, 5, 5));
        inventoryPanel.add(startingInventoryLabel);
        inventoryPanel.add(endingInventoryLabel);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Align buttons in the center with some spacing
        buttonPanel.add(backButton);

        // Add components to the panel
        add(tabbedPane, BorderLayout.CENTER);
        add(inventoryPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setNormalItems(ArrayList<Item> normalItems) {
        // Clear the existing data from the table
        normalItemsTableModel.setRowCount(0);

        // Add the new data to the table
        for (Item item : normalItems) {
            normalItemsTableModel.addRow(new Object[]{item.getItemName(), item.getPrice(), item.getCalories()});
        }
    }

    public void setSpecialItems(ArrayList<SpecialItem> specialItems) {
        // Clear the existing data from the table
        specialItemsTableModel.setRowCount(0);

        // Add the new data to the table
        for (SpecialItem item : specialItems) {
            specialItemsTableModel.addRow(new Object[]{item.getItemName(), item.getPrice(), item.getCalories(), item.getType()});
        }
    }

    public void setStartingInventory(int startingInventory) {
        startingInventoryLabel.setText("Starting Inventory: " + startingInventory);
    }

    public void setEndingInventory(int endingInventory) {
        endingInventoryLabel.setText("Ending Inventory: " + endingInventory);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
