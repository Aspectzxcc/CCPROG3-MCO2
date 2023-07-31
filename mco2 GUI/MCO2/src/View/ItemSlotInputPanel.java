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
        setBackground(Color.WHITE);

        titleLabel = new JLabel("Vending Machine Configuration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));

        slotsLabel = new JLabel("Number of Slots:");
        slotsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        slotsTextField = new JTextField();
        slotsTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        slotsTextField.setHorizontalAlignment(SwingConstants.CENTER); // Center the text in the box
        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));

        inputPanel.add(slotsLabel);
        inputPanel.add(slotsTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);

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
