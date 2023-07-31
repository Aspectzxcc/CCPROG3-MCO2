package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateRegularVendingMachinePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel titleLabel;
    private JLabel quantityLabel;
    private JButton submitButton;
    private ArrayList<String> selectedItems;
    private JTextField[] quantityTextFields;
    private ArrayList<Integer> itemQuantities;

    public CreateRegularVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.selectedItems = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();

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

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateQuantities()) {
                    for (int i = 0; i < quantityTextFields.length; i++) {
                        String quantityText = quantityTextFields[i].getText();
                        int quantity = Integer.parseInt(quantityText);
                        itemQuantities.add(quantity);
                     }

                }
            }
        });
    }

    public ArrayList<Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
    

    private boolean validateQuantities() {
        for (int i = 0; i < quantityTextFields.length; i++) {
            String quantityText = quantityTextFields[i].getText();
            try {
                int quantity = Integer.parseInt(quantityText);
                if (quantity < 10) {
                    JOptionPane.showMessageDialog(this, "Quantity for " + selectedItems.get(i) + " must be 10 or more.");
                    return false;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity for " + selectedItems.get(i) + ".");
                return false;
            }
        }
        return true;
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
    

    public void setSelectedItems(ArrayList<String> selectedItems) {
        this.selectedItems = selectedItems;
    }
}
