package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Item;
import Model.ItemSlot;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The SetItemPricesPanel class represents the panel for setting item prices in the vending machine configuration.
 */
public class SetItemPricesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JScrollPane tableScrollPane;
    private JButton backButton;
    private JButton setPricesButton;

    /**
     * Creates a new SetItemPricesPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public SetItemPricesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Initialize the item table
        String[] columnNames = {"Item", "Price (PHP)", "Calories", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(itemTable);

        add(tableScrollPane, BorderLayout.CENTER);

        // Initialize the set prices button
        setPricesButton = new JButton("Set Prices");
        setPricesButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        setPricesButton.setBackground(Color.GREEN); // Set button background color
        setPricesButton.setForeground(Color.WHITE); // Set button text color
        setPricesButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        setPricesButton.setFocusPainted(false); // Remove focus border

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
        buttonPanel.add(setPricesButton);
        buttonPanel.add(backButton);

        // Add the button panel to the South of the SetItemPricesPanel
        add(buttonPanel, BorderLayout.SOUTH);
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

    /**
     * Gets the item table used to display and set item prices.
     *
     * @return the item table
     */
    public JTable getItemTable() {
        return itemTable;
    }

    /**
     * Gets the table model used for the item table.
     *
     * @return the table model
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * Sets the data for the item table.
     *
     * @param itemSlots the list of item slots in the vending machine
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
     * Adds an ActionListener to the Set Prices button.
     *
     * @param listener the ActionListener to add
     */
    public void addSetPricesButtonListener(ActionListener listener) {
        setPricesButton.addActionListener(listener);
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
