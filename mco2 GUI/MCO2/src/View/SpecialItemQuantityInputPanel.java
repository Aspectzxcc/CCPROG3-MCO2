package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecialItemQuantityInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel titleLabel;
    private JButton submitButton;
    private JTextField[] quantityTextFields;
    private ArrayList<String> selectedSpecialItems;
    private ArrayList<Integer> specialItemQuantities;

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
        add(titleLabel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(selectedSpecialItems.size(), 2));

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

    public ArrayList<String> getSelectedSpecialItems() {
        return selectedSpecialItems;
    }

    public JTextField[] getQuantityTextFields() {
        return quantityTextFields;
    }

    public ArrayList<Integer> getSpecialItemQuantities() {
        return specialItemQuantities;
    }

    public void setSpecialItemQuantities(ArrayList<Integer> specialItemQuantities) {
        this.specialItemQuantities = specialItemQuantities;
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

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

    public void setSelectedSpecialItems(ArrayList<String> selectedSpecialItems) {
        this.selectedSpecialItems = selectedSpecialItems;
    }

    public void reset() {
        selectedSpecialItems = new ArrayList<>();
        specialItemQuantities = new ArrayList<>();
        quantityTextFields = new JTextField[selectedSpecialItems.size()];
        inputPanel.removeAll();
        inputPanel.revalidate();
        inputPanel.repaint();
    }
}
