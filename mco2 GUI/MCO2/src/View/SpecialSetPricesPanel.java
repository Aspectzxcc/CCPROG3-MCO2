package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The SpecialSetPricesPanel class represents a panel that allows setting prices for normal and special items.
 * It includes two JTables, a tabbed pane, set prices button, and back button.
 */
public class SpecialSetPricesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable normalItemTable;
    private JTable specialItemTable;
    private JTabbedPane tabbedPane;
    private DefaultTableModel normalTableModel;
    private DefaultTableModel specialTableModel;
    private JScrollPane normalTableScrollPane;
    private JScrollPane specialTableScrollPane;
    private JButton backButton;
    private JButton setPricesButton;

    /**
     * Creates a new SpecialSetPricesPanel with the specified CardLayout and mainPanel.
     *
     * @param cardLayout The CardLayout used for navigation.
     * @param mainPanel  The main panel containing this SpecialSetPricesPanel.
     */
    public SpecialSetPricesPanel(CardLayout cardLayout, JPanel mainPanel) {
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
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Normal Items", normalTableScrollPane);
        tabbedPane.addTab("Special Items", specialTableScrollPane);

        add(tabbedPane, BorderLayout.CENTER);

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

        // Add the button panel to the South of the SpecialSetItemsPanel
        add(buttonPanel, BorderLayout.SOUTH);
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
     * Gets the main panel containing this SpecialSetPricesPanel.
     *
     * @return The main panel containing this SpecialSetPricesPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets the JTable displaying normal items' data.
     *
     * @return The JTable displaying normal items' data.
     */
    public JTable getNormalItemTable() {
        return normalItemTable;
    }

    /**
     * Gets the JTable displaying special items' data.
     *
     * @return The JTable displaying special items' data.
     */
    public JTable getSpecialItemTable() {
        return specialItemTable;
    }

    /**
     * Gets the DefaultTableModel used for the normal item table.
     *
     * @return The DefaultTableModel used for the normal item table.
     */
    public DefaultTableModel getNormalTableModel() {
        return normalTableModel;
    }

    /**
     * Gets the DefaultTableModel used for the special item table.
     *
     * @return The DefaultTableModel used for the special item table.
     */
    public DefaultTableModel getSpecialTableModel() {
        return specialTableModel;
    }

    /**
     * Gets the index of the selected tab in the tabbed pane.
     *
     * @return The index of the selected tab in the tabbed pane.
     */
    public int getSelectedTabIndex() {
        return tabbedPane.getSelectedIndex();
    }

    /**
     * Sets the data for the normal item table.
     *
     * @param itemSlots The list of ItemSlot objects representing the available normal items in the vending machine.
     */
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

    /**
     * Sets the data for the special item table.
     *
     * @param specialItemsList The list of ArrayLists representing the available special items in the vending machine.
     */
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

    /**
     * Adds an ActionListener to the set prices button.
     *
     * @param listener The ActionListener to be added to the set prices button.
     */
    public void addSetPricesButtonListener(ActionListener listener) {
        setPricesButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the back button.
     *
     * @param listener The ActionListener to be added to the back button.
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
