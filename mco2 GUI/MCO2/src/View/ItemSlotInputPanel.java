package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        slotsLabel = new JLabel("Number of Slots:");
        slotsTextField = new JTextField();
        continueButton = new JButton("Continue");

        inputPanel.add(slotsLabel);
        inputPanel.add(slotsTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
