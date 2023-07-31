package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemQuantityInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel titleLabel;
    private JButton submitButton;
    private JTextField[] quantityTextFields;
    private ArrayList<String> selectedItems;
    private ArrayList<Integer> itemQuantities;

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
        add(titleLabel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(selectedItems.size(), 2));

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }

    public JTextField[] getQuantityTextFields() {
        return quantityTextFields;
    }

    public ArrayList<Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void setSelectedItems(ArrayList<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void setItemQuantities(ArrayList<Integer> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

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

    public void reset() {
        selectedItems.clear();
        itemQuantities.clear();
        inputPanel.removeAll();
        revalidate();
        repaint();
    }
}
