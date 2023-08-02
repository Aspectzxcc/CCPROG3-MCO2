package View;

import Model.CashRegister;
import Model.SpecialItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getItemTable() {
        return itemTable;
    }

    // Getters for the option indicators
    public JLabel getBreadLabel() {
        return breadLabel;
    }

    public JLabel getMeatLabel() {
        return meatLabel;
    }

    public JLabel getCheeseLabel() {
        return cheeseLabel;
    }

    public JLabel getVegetableLabel() {
        return vegetableLabel;
    }

    public JLabel getSauceLabel() {
        return sauceLabel;
    }

    // Method to set the data for the item table
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

    // Method to update the inserted money label
    public void updateInsertedMoney(int insertedMoney) {
        insertedMoneyLabel.setText("Inserted Money: " + insertedMoney + " PHP");
    }

    // Method to check if an option indicator is already set
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


    // Method to update the option indicators for the custom sandwich
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

    // Method to reset the option indicators for the custom sandwich
    public void resetOptionIndicators() {
        breadLabel.setText("Bread: None");
        meatLabel.setText("Meat: None");
        cheeseLabel.setText("Cheese: None");
        vegetableLabel.setText("Vegetable: None");
        sauceLabel.setText("Sauce: None");
    }

    // Method to update the total calories label
    public void updateTotalCalories(int totalCalories) {
        totalCaloriesLabel.setText("Total Calories: " + totalCalories);
    }

    public void addTotalCalories(int calories) {
        int totalCalories = Integer.parseInt(totalCaloriesLabel.getText().replace("Total Calories: ", ""));
        totalCalories += calories;
        updateTotalCalories(totalCalories);
    }

    public void addCurrencyButtonListener(ActionListener listener) {
        for (JButton currencyButton : currencyButtons) {
            currencyButton.addActionListener(listener);
        }
    }

    public void addBuyItemButtonListener(ActionListener listener) {
        buyItemButton.addActionListener(listener);
    }

    public void addCreateCustomSandwichButtonListener(ActionListener listener) {
        createCustomSandwichButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
