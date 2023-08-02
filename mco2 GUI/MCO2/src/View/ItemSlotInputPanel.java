package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ItemSlotInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel slotsLabel;
    private JTextField slotsTextField;
    private JButton continueButton;

    public ItemSlotInputPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Vending Machine Configuration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        slotsLabel = new JLabel("Number of Slots:");
        slotsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        slotsTextField = new JTextField(10); // Set the input field width
        slotsTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        slotsTextField.setHorizontalAlignment(SwingConstants.CENTER); // Center the text in the box

        // Use GridBagConstraints to center the components vertically
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 0, 5, 0); // Add some spacing between components
        inputPanel.add(slotsLabel, gbc);
        inputPanel.add(slotsTextField, gbc);

        continueButton = new JButton("Continue"); // Initialize the button
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continueButton.setBackground(new Color(50, 150, 50)); // Green background color
        continueButton.setForeground(Color.WHITE); // White text color
        continueButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add some padding
        continueButton.setFocusPainted(false); // Remove focus border

        // Set button styles
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        continueButton.setFont(buttonFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);
        buttonPanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getSlotsTextField() {
        return slotsTextField;
    }

    public void addContinueButtonListener(ActionListener listener) {
        continueButton.addActionListener(listener);
    }
}
