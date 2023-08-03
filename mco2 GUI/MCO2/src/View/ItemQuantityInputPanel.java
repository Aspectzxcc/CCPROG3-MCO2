package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ItemQuantityInputPanel class represents a panel for entering quantities of selected items in the vending machine configuration.
 * It provides text fields for each selected item to input the quantity and a "Submit" button to save the quantities.
 */
public class ItemQuantityInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel titleLabel;
    private JButton submitButton;
    private JTextField[] quantityTextFields;
    private ArrayList<String> selectedItems;
    private ArrayList<Integer> itemQuantities;

    /**
     * Creates a new ItemQuantityInputPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public ItemQuantityInputPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.selectedItems = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        quantityTextFields = new JTextField[selectedItems.size()];

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Vending Machine Configuration - Regular Items");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(selectedItems.size(), 2, 10, 10));
        inputPanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setBackground(new Color(0, 128, 0)); // Dark green background color
        submitButton.setForeground(Color.WHITE); // White text color
        submitButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        submitButton.setFocusPainted(false); // Remove focus border
        buttonPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
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
     * Gets the list of selected items.
     *
     * @return the list of selected items
     */
    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }

    /**
     * Gets the array of quantity text fields.
     *
     * @return the array of quantity text fields
     */
    public JTextField[] getQuantityTextFields() {
        return quantityTextFields;
    }

    /**
     * Gets the list of item quantities.
     *
     * @return the list of item quantities
     */
    public ArrayList<Integer> getItemQuantities() {
        return itemQuantities;
    }

    /**
     * Sets the list of selected items.
     *
     * @param selectedItems the list of selected items
     */
    public void setSelectedItems(ArrayList<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     * Sets the list of item quantities.
     *
     * @param itemQuantities the list of item quantities
     */
    public void setItemQuantities(ArrayList<Integer> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    /**
     * Adds an ActionListener to the Submit button.
     *
     * @param listener the ActionListener to add
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Creates quantity input fields for each selected item.
     */
    public void createQuantityInputFields() {
        quantityTextFields = new JTextField[selectedItems.size()];
    
        for (int i = 0; i < selectedItems.size(); i++) {
            String itemName = selectedItems.get(i);
            JLabel itemLabel = new JLabel(itemName + " Quantity:");
            quantityTextFields[i] = new JTextField();
            quantityTextFields[i].setHorizontalAlignment(SwingConstants.CENTER);
            inputPanel.add(itemLabel);
            inputPanel.add(quantityTextFields[i]);
        }
    
        // Add the inputPanel to the main panel
        add(inputPanel, BorderLayout.CENTER);
    
        // Repaint the panel to reflect the changes
        revalidate();
        repaint();
    }

    /**
     * Resets the panel by clearing the lists and removing the input fields.
     */
    public void reset() {
        selectedItems.clear();
        itemQuantities.clear();
        inputPanel.removeAll();
        revalidate();
        repaint();
    }
}
