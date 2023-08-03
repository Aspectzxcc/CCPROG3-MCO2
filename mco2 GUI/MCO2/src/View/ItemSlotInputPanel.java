package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The ItemSlotInputPanel class represents a panel for entering the number of slots in the vending machine configuration.
 * It provides a text field to input the number of slots and a "Continue" button to proceed to the next step.
 */
public class ItemSlotInputPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel slotsLabel;
    private JTextField slotsTextField;
    private JButton continueButton;

    /**
     * Creates a new ItemSlotInputPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
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
     * Gets the text field used for entering the number of slots.
     *
     * @return the slots text field
     */
    public JTextField getSlotsTextField() {
        return slotsTextField;
    }

    /**
     * Adds an ActionListener to the Continue button.
     *
     * @param listener the ActionListener to add
     */
    public void addContinueButtonListener(ActionListener listener) {
        continueButton.addActionListener(listener);
    }
}
