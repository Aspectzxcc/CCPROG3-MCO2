package View;

import Model.CashRegister;
import Model.SpecialItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The SpecialVendingFeaturesPanel class represents a panel for displaying special items and custom sandwich options.
 * It includes a JTable, option indicators, labels for inserted money and total calories, currency buttons, buy item button,
 * create custom sandwich button, and back button.
 */
public class SpecialVendingFeaturesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JButton buyItemButton;
    private JButton createCustomSandwichButton;
    private JButton backButton;
    private JButton[] currencyButtons;
    private JLabel insertedMoneyLabel;
    private JLabel totalCaloriesLabel;
    private JLabel breadLabel;
    private JLabel meatLabel;
    private JLabel cheeseLabel;
    private JLabel vegetableLabel;
    private JLabel sauceLabel;

    /**
     * Creates a new SpecialVendingFeaturesPanel with the specified CardLayout and mainPanel.
     *
     * @param cardLayout The CardLayout used for navigation.
     * @param mainPanel  The main panel containing this SpecialVendingFeaturesPanel.
     */
    public SpecialVendingFeaturesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Initialize the item table
        String[] columnNames = {"Item", "Price (PHP)", "Type", "Calories", "Stock"};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(itemTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Initialize the West panel for option indicators
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize the option indicators using JLabels
        breadLabel = new JLabel("Bread: None");
        meatLabel = new JLabel("Meat: None");
        cheeseLabel = new JLabel("Cheese: None");
        vegetableLabel = new JLabel("Vegetable: None");
        sauceLabel = new JLabel("Sauce: None");

        westPanel.add(breadLabel);
        westPanel.add(meatLabel);
        westPanel.add(cheeseLabel);
        westPanel.add(vegetableLabel);
        westPanel.add(sauceLabel);

        // Add the West panel to the SpecialVendingFeaturesPanel
        add(westPanel, BorderLayout.WEST);

        // Initialize the South panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Arrange components left-to-right
        insertedMoneyLabel = new JLabel("Inserted Money: 0 PHP");
        southPanel.add(insertedMoneyLabel);
        totalCaloriesLabel = new JLabel("Total Calories: 0");
        southPanel.add(totalCaloriesLabel);

        // Initialize the customize sandwich button
        createCustomSandwichButton = new JButton("Create Custom Sandwich");
        // Add the customize sandwich button to the South panel
        southPanel.add(createCustomSandwichButton);

        // Add the South panel to the SpecialVendingFeaturesPanel
        add(southPanel, BorderLayout.SOUTH);

        // Initialize the back button
        backButton = new JButton("Back to Vending Features");
        // Add the back button to the North panel
        add(backButton, BorderLayout.NORTH);

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

        // Initialize the buy item button
        buyItemButton = new JButton("Buy Item");

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
        createCustomSandwichButton.setBackground(buttonBackground);
        createCustomSandwichButton.setForeground(buttonForeground);
        createCustomSandwichButton.setFont(buttonFont);
        createCustomSandwichButton.setFocusPainted(false);
        createCustomSandwichButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Customize the exit button
        backButton.setBackground(new Color(235, 240, 200));
        backButton.setFont(buttonFont);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Create a panel to hold the currency panel and the buy item button
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(currencyPanel, BorderLayout.NORTH);
        eastPanel.add(buyItemButton, BorderLayout.SOUTH);

        add(eastPanel, BorderLayout.EAST);
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
     * Gets the main panel containing this SpecialVendingFeaturesPanel.
     *
     * @return The main panel containing this SpecialVendingFeaturesPanel.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets the JTable displaying special items' data.
     *
     * @return The JTable displaying special items' data.
     */
    public JTable getItemTable() {
        return itemTable;
    }

    /**
     * Gets the JLabel representing the bread option indicator.
     *
     * @return The JLabel representing the bread option indicator.
     */
    public JLabel getBreadLabel() {
        return breadLabel;
    }

    /**
     * Gets the JLabel representing the meat option indicator.
     *
     * @return The JLabel representing the meat option indicator.
     */
    public JLabel getMeatLabel() {
        return meatLabel;
    }

    /**
     * Gets the JLabel representing the cheese option indicator.
     *
     * @return The JLabel representing the cheese option indicator.
     */
    public JLabel getCheeseLabel() {
        return cheeseLabel;
    }

    /**
     * Gets the JLabel representing the vegetable option indicator.
     *
     * @return The JLabel representing the vegetable option indicator.
     */
    public JLabel getVegetableLabel() {
        return vegetableLabel;
    }

    /**
     * Gets the JLabel representing the sauce option indicator.
     *
     * @return The JLabel representing the sauce option indicator.
     */
    public JLabel getSauceLabel() {
        return sauceLabel;
    }

    /**
     * Sets the data for the item table with special items.
     *
     * @param specialItemsList The list of ArrayLists representing the available special items in the vending machine.
     */
    public void setItemData(ArrayList<ArrayList<SpecialItem>> specialItemsList) {
        // Clear the existing data from the table
        tableModel.setRowCount(0);
    
        // Add the new data to the table
        for (ArrayList<SpecialItem> specialItems : specialItemsList) {
            if (!specialItems.isEmpty() && isOptionIndicatorSet(specialItems.get(0).getType())) {
                SpecialItem specialItem = specialItems.get(0);
                String itemName = specialItem.getItemName();
                int itemPrice = specialItem.getPrice();
                String itemType = specialItem.getType();
                int itemCalorie = specialItem.getCalories();
                int stock = specialItems.size();
                tableModel.addRow(new Object[]{itemName, itemPrice, itemType, itemCalorie, stock});
            }
        }
    }

    /**
     * Updates the inserted money label with the given amount.
     *
     * @param insertedMoney The amount of money inserted.
     */
    public void updateInsertedMoney(int insertedMoney) {
        insertedMoneyLabel.setText("Inserted Money: " + insertedMoney + " PHP");
    }

    /**
     * Checks if an option indicator for a specific type is already set.
     *
     * @param optionType The type of the option (e.g., "Bread", "Meat").
     * @return true if the option indicator is already set, false otherwise.
     */
    public boolean isOptionIndicatorSet(String optionType) {
        switch (optionType) {
            case "Bread":
                return breadLabel.getText().equals("Bread: None");
            case "Meat":
                return meatLabel.getText().equals("Meat: None");
            case "Cheese":
                return cheeseLabel.getText().equals("Cheese: None");
            case "Vegetable":
                return vegetableLabel.getText().equals("Vegetable: None");
            case "Sauce":
                return sauceLabel.getText().equals("Sauce: None");
            default:
                return false;
        }
    }


    /**
     * Updates the option indicators for the custom sandwich with the given option type and name.
     *
     * @param optionType The type of the option (e.g., "Bread", "Meat").
     * @param optionName The name of the option (e.g., "Whole Wheat", "Chicken").
     */
    public void updateOptionIndicator(String optionType, String optionName) {
        switch (optionType) {
            case "Bread":
                breadLabel.setText("Bread: " + optionName);
                break;
            case "Meat":
                meatLabel.setText("Meat: " + optionName);
                break;
            case "Cheese":
                cheeseLabel.setText("Cheese: " + optionName);
                break;
            case "Vegetable":
                vegetableLabel.setText("Vegetable: " + optionName);
                break;
            case "Sauce":
                sauceLabel.setText("Sauce: " + optionName);
                break;
        }
    }

    /**
     * Resets all option indicators for the custom sandwich to their initial state.
     */
    public void resetOptionIndicators() {
        breadLabel.setText("Bread: None");
        meatLabel.setText("Meat: None");
        cheeseLabel.setText("Cheese: None");
        vegetableLabel.setText("Vegetable: None");
        sauceLabel.setText("Sauce: None");
    }

    /**
     * Updates the total calories label with the given total calories amount.
     *
     * @param totalCalories The total calories amount.
     */
    public void updateTotalCalories(int totalCalories) {
        totalCaloriesLabel.setText("Total Calories: " + totalCalories);
    }

    /**
     * Adds the specified amount of calories to the total calories label.
     *
     * @param calories The calories amount to be added.
     */
    public void addTotalCalories(int calories) {
        int totalCalories = Integer.parseInt(totalCaloriesLabel.getText().replace("Total Calories: ", ""));
        totalCalories += calories;
        updateTotalCalories(totalCalories);
    }

    /**
     * Adds an ActionListener to the currency buttons.
     *
     * @param listener The ActionListener to be added to the currency buttons.
     */
    public void addCurrencyButtonListener(ActionListener listener) {
        for (JButton currencyButton : currencyButtons) {
            currencyButton.addActionListener(listener);
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
     * Adds an ActionListener to the create custom sandwich button.
     *
     * @param listener The ActionListener to be added to the create custom sandwich button.
     */
    public void addCreateCustomSandwichButtonListener(ActionListener listener) {
        createCustomSandwichButton.addActionListener(listener);
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
