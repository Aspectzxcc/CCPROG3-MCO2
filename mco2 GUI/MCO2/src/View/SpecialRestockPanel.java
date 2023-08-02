package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Item;
import Model.ItemSlot;
import Model.SpecialItem;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecialRestockPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable normalItemTable;
    private JTable specialItemTable;
    private DefaultTableModel normalTableModel;
    private DefaultTableModel specialTableModel;
    private JScrollPane normalTableScrollPane;
    private JScrollPane specialTableScrollPane;
    private JButton backButton;
    private JButton restockButton;

    public SpecialRestockPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Initialize the normal item table
        String[] normalColumnNames = {"Item", "Price (PHP)", "Calories", "Stock"};
        normalTableModel = new DefaultTableModel(normalColumnNames, 0);
        normalItemTable = new JTable(normalTableModel);
        normalTableScrollPane = new JScrollPane(normalItemTable);

        // Initialize the special item table
        String[] specialColumnNames = {"Item", "Price (PHP)", "Calories", "Type", "Stock"};
        specialTableModel = new DefaultTableModel(specialColumnNames, 0);
        specialItemTable = new JTable(specialTableModel);
        specialTableScrollPane = new JScrollPane(specialItemTable);

        // Create a tabbed pane to display both normal and special item tables
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Normal Items", normalTableScrollPane);
        tabbedPane.addTab("Special Items", specialTableScrollPane);

        add(tabbedPane, BorderLayout.CENTER);

        // Initialize the restock button
        restockButton = new JButton("Restock");
        restockButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        restockButton.setBackground(Color.GREEN); // Set button background color
        restockButton.setForeground(Color.WHITE); // Set button text color
        restockButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        restockButton.setFocusPainted(false); // Remove focus border

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
        buttonPanel.add(restockButton);
        buttonPanel.add(backButton);

        // Add the button panel to the South of the SpecialRestockPanel
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getNormalItemTable() {
        return normalItemTable;
    }

    public JTable getSpecialItemTable() {
        return specialItemTable;
    }

    public DefaultTableModel getNormalTableModel() {
        return normalTableModel;
    }

    public DefaultTableModel getSpecialTableModel() {
        return specialTableModel;
    }

    // Method to set the data for the normal item table
    public void setNormalItemData(ArrayList<ItemSlot> itemSlots) {
        // Clear the existing data from the table
        normalTableModel.setRowCount(0);

        // Add the new data to the table
        for (ItemSlot itemSlot : itemSlots) {
            ArrayList<Item> itemList = itemSlot.getItemList();
            if (!itemList.isEmpty()) {
                Item item = itemList.get(0); // Assuming there's only one item in each slot for simplicity
                String itemName = item.getItemName();
                int itemPrice = item.getPrice();
                int itemCalorie = item.getCalories();
                int stock = itemList.size(); // The stock is the number of items in the slot
                normalTableModel.addRow(new Object[]{itemName, itemPrice, itemCalorie, stock});
            }
        }
    }

    // Method to set the data for the special item table
    public void setSpecialItemData(ArrayList<ArrayList<SpecialItem>> specialItemsList) {
        // Clear the existing data from the table
        specialTableModel.setRowCount(0);

        // Add the new data to the table
        for (ArrayList<SpecialItem> specialItems : specialItemsList) {
            if (!specialItems.isEmpty()) {
                SpecialItem item = specialItems.get(0); // Assuming there's only one item in each slot for simplicity
                String itemName = item.getItemName();
                int itemPrice = item.getPrice();
                int itemCalorie = item.getCalories();
                String itemType = item.getType();
                int stock = specialItems.size(); // The stock is the number of items in the slot
                specialTableModel.addRow(new Object[]{itemName, itemPrice, itemCalorie, itemType, stock});
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
}
