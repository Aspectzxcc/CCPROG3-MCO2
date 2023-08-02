package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestockItemsPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JScrollPane tableScrollPane;
    private JButton restockButton;
    private JButton backButton;
    private JLabel restockLabel;
    private JTextField restockTextField;

    public RestockItemsPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Initialize the item table
        String[] columnNames = {"Item", "Price (PHP)", "Calories", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(itemTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Initialize the restock button and label
        restockButton = new JButton("Restock");
        restockLabel = new JLabel("Enter quantity to restock:");
        restockTextField = new JTextField(10);

        // Create a panel to hold the restock label, text field, and button
        JPanel restockPanel = new JPanel();
        restockPanel.add(restockLabel);
        restockPanel.add(restockTextField);
        restockPanel.add(restockButton);

        // Add the restock panel to the North of the RestockItemsPanel
        add(restockPanel, BorderLayout.NORTH);

        // Initialize the back button
        backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getItemTable() {
        return itemTable;
    }

    // Method to set the data for the item table
    public void setItemData(ArrayList<ItemSlot> itemSlots) {
        // Clear the existing data from the table
        tableModel.setRowCount(0);

        // Add the new data to the table
        for (ItemSlot itemSlot : itemSlots) {
            ArrayList<Item> itemList = itemSlot.getItemList();
            if (!itemList.isEmpty()) {
                Item item = itemList.get(0); // Assuming there's only one item in each slot for simplicity
                String itemName = item.getItemName();
                int itemPrice = item.getPrice();
                int itemCalorie = item.getCalories();
                int stock = itemList.size(); // The stock is the number of items in the slot
                tableModel.addRow(new Object[]{itemName, itemPrice, itemCalorie, stock});
            }
        }
    }

    // Method to add action listener for the restock button
    public void addRestockButtonListener(ActionListener listener) {
        restockButton.addActionListener(listener);
    }

    // Method to add action listener for the back button
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    // Method to get the quantity to restock
    public int getRestockQuantity() {
        String quantityText = restockTextField.getText();
        try {
            return Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
