package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The SpecialItemQuantityInputPanel class represents the panel for inputting quantities of selected special items
 * in the vending machine configuration.
 */
public class SpecialItemQuantityInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel titleLabel;
    private JButton submitButton;
    private JTextField[] quantityTextFields;
    private ArrayList<String> selectedSpecialItems;
    private ArrayList<Integer> specialItemQuantities;

    /**
     * Creates a new SpecialItemQuantityInputPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public SpecialItemQuantityInputPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.selectedSpecialItems = new ArrayList<>();
        this.specialItemQuantities = new ArrayList<>();
        quantityTextFields = new JTextField[selectedSpecialItems.size()];

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Vending Machine Configuration - Special Items");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add some padding
        add(titleLabel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(selectedSpecialItems.size(), 2, 10, 10)); // Add spacing between components
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); // Add some padding

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        submitButton.setBackground(new Color(0, 128, 0)); // Dark green background color
        submitButton.setForeground(Color.WHITE); // White text color
        submitButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        submitButton.setFocusPainted(false); // Remove focus border
        buttonPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
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
     * Gets the list of selected special items.
     *
     * @return the list of selected special items
     */
    public ArrayList<String> getSelectedSpecialItems() {
        return selectedSpecialItems;
    }

    /**
     * Gets the array of quantity input text fields.
     *
     * @return the array of quantity input text fields
     */
    public JTextField[] getQuantityTextFields() {
        return quantityTextFields;
    }

    /**
     * Gets the list of special item quantities.
     *
     * @return the list of special item quantities
     */
    public ArrayList<Integer> getSpecialItemQuantities() {
        return specialItemQuantities;
    }

    /**
     * Sets the special item quantities.
     *
     * @param specialItemQuantities the special item quantities to set
     */
    public void setSpecialItemQuantities(ArrayList<Integer> specialItemQuantities) {
        this.specialItemQuantities = specialItemQuantities;
    }

    /**
     * Adds an ActionListener to the submit button.
     *
     * @param listener the ActionListener to add
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Creates the quantity input fields for selected special items.
     */
    public void createQuantityInputFields() {
        quantityTextFields = new JTextField[selectedSpecialItems.size()];

        for (int i = 0; i < selectedSpecialItems.size(); i++) {
            String itemName = selectedSpecialItems.get(i);
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
     * Sets the list of selected special items.
     *
     * @param selectedSpecialItems the list of selected special items to set
     */
    public void setSelectedSpecialItems(ArrayList<String> selectedSpecialItems) {
        this.selectedSpecialItems = selectedSpecialItems;
    }

    /**
     * Resets the panel by clearing the selected special items and their quantities, and removing the input fields.
     */
    public void reset() {
        selectedSpecialItems = new ArrayList<>();
        specialItemQuantities = new ArrayList<>();
        quantityTextFields = new JTextField[selectedSpecialItems.size()];
        inputPanel.removeAll();
        inputPanel.revalidate();
        inputPanel.repaint();
    }
}
