package View;

import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The VendingFeaturesPanel class represents the panel that displays vending machine features.
 * It includes a table showing available items, currency buttons, buy item button, customize sandwich button,
 * exit button, and an inserted money label.
 */
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

    /**
     * Creates a new VendingFeaturesPanel with the specified CardLayout and mainPanel.
     *
     * @param cardLayout The CardLayout used for navigation.
     * @param mainPanel  The main panel containing this VendingFeaturesPanel.
     */
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

    /**
     * Gets the CardLayout used by this panel.
     *
     * @return The CardLayout used by this panel.
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Gets the main panel containing this VendingFeaturesPanel.
     *
     * @return The main panel containing this VendingFeaturesPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets the JTable displaying the item data.
     *
     * @return The JTable displaying the item data.
     */
    public JTable getItemTable() {
        return itemTable;
    }

    /**
     * Sets the data for the item table.
     *
     * @param itemSlots The list of ItemSlot objects representing the available items in the vending machine.
     */
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

    /**
     * Updates the inserted money label with the specified amount.
     *
     * @param insertedMoney The amount of money inserted into the vending machine.
     */
    public void updateInsertedMoney(int insertedMoney) {
        insertedMoneyLabel.setText("Inserted Money: " + insertedMoney + " PHP");
    }

    /**
     * Adds an ActionListener to each currency button.
     *
     * @param listener The ActionListener to be added to the currency buttons.
     */
    public void addCurrencyButtonListener(ActionListener listener) {
        for (JButton button : currencyButtons) {
            button.addActionListener(listener);
        }
    }

    /**
     * Adds an ActionListener to the buy item button.
     *
     * @param listener The ActionListener to be added to the buy item button.
     */
    public void addBuyItemButtonListener(ActionListener listener) {
        buyItemButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the customize sandwich button.
     *
     * @param listener The ActionListener to be added to the customize sandwich button.
     */
    public void addCustomizeSandwichButtonListener(ActionListener listener) {
        customizeSandwichButton.addActionListener(listener);
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
