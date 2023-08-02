package View;

import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendingFeaturesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JScrollPane tableScrollPane;
    private JButton[] currencyButtons;
    private JButton buyItemButton;
    private JButton customizeSandwichButton;
    private JButton exitButton;
    private JLabel insertedMoneyLabel;
    private JPanel southPanel;

    public VendingFeaturesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Initialize the item table
        String[] columnNames = {"Item", "Price (PHP)", "Calories", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(itemTable);
        add(tableScrollPane, BorderLayout.CENTER);

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

        // Initialize the inserted money label
        insertedMoneyLabel = new JLabel("Inserted Money: 0 PHP");

        // Initialize the South panel and add the label to it
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Arrange components left-to-right
        southPanel.add(insertedMoneyLabel);

        // Add the South panel to the VendingFeaturesPanel
        add(southPanel, BorderLayout.SOUTH);

        // Initialize the buy item button
        buyItemButton = new JButton("Buy Item");

        // Create a panel to hold the currency panel and the buy item button
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(currencyPanel, BorderLayout.NORTH);
        eastPanel.add(buyItemButton, BorderLayout.SOUTH);

        add(eastPanel, BorderLayout.EAST);

        // Initialize the customize sandwich button
        customizeSandwichButton = new JButton("Make Your Own Sandwich!");
        add(customizeSandwichButton, BorderLayout.WEST);

        // Initialize the exit button
        exitButton = new JButton("Exit to Test Menu");
        add(exitButton, BorderLayout.NORTH);

        // Set color constants for buttons
        Color buttonBackground = new Color(102, 153, 255);
        Color buttonForeground = Color.WHITE;
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Customize the currency buttons
        for (JButton button : currencyButtons) {
            button.setBackground(buttonBackground);
            button.setForeground(buttonForeground);
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }

        // Customize the buy item button
        buyItemButton.setBackground(new Color(255, 10, 55)); // Red background color
        buyItemButton.setForeground(buttonForeground);
        buyItemButton.setFont(buttonFont);
        buyItemButton.setFocusPainted(false);
        buyItemButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Customize the customize sandwich button
        customizeSandwichButton.setBackground(buttonBackground);
        customizeSandwichButton.setForeground(buttonForeground);
        customizeSandwichButton.setFont(buttonFont);
        customizeSandwichButton.setFocusPainted(false);
        customizeSandwichButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Customize the exit button
        exitButton.setBackground(new Color(235, 240, 200));
        exitButton.setFont(buttonFont);
        exitButton.setFocusPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
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

    // Method to update the inserted money label
    public void updateInsertedMoney(int insertedMoney) {
        insertedMoneyLabel.setText("Inserted Money: " + insertedMoney + " PHP");
    }

    // Method to add action listener for the currency buttons
    public void addCurrencyButtonListener(ActionListener listener) {
        for (JButton button : currencyButtons) {
            button.addActionListener(listener);
        }
    }

    // Method to add action listener for the buy item button
    public void addBuyItemButtonListener(ActionListener listener) {
        buyItemButton.addActionListener(listener);
    }

    // Method to add action listener for the customize sandwich button
    public void addCustomizeSandwichButtonListener(ActionListener listener) {
        customizeSandwichButton.addActionListener(listener);
    }

    // Method to add action listener for the exit button
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
