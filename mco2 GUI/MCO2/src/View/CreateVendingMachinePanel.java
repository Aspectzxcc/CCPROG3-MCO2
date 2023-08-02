package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateVendingMachinePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton regularVendingMachineButton;
    private JButton specialVendingMachineButton;

    public CreateVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        JLabel titleLabel = new JLabel("Create Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create panels for choosing regular or special vending machine
        JPanel chooseTypePanel = new JPanel();
        chooseTypePanel.setLayout(new GridLayout(1, 2, 20, 0));
        chooseTypePanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        regularVendingMachineButton = new JButton("Regular Vending Machine");
        regularVendingMachineButton.setFont(new Font("Arial", Font.PLAIN, 20));
        regularVendingMachineButton.setForeground(Color.WHITE); // Dark red text color
        regularVendingMachineButton.setBackground(new Color(255, 0, 0)); // Light orange button color
        chooseTypePanel.add(regularVendingMachineButton);

        specialVendingMachineButton = new JButton("Special Vending Machine");
        specialVendingMachineButton.setFont(new Font("Arial", Font.PLAIN, 20));
        specialVendingMachineButton.setForeground(Color.WHITE); // Dark red text color
        specialVendingMachineButton.setBackground(new Color(33, 150, 243)); // Light orange button color
        chooseTypePanel.add(specialVendingMachineButton);

        // Set button styles
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        regularVendingMachineButton.setFont(buttonFont);
        specialVendingMachineButton.setFont(buttonFont);

        add(chooseTypePanel, BorderLayout.CENTER);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addRegularVendingMachineButtonListener(ActionListener listener) {
        regularVendingMachineButton.addActionListener(listener);
    }

    public void addSpecialVendingMachineButtonListener(ActionListener listener) {
        specialVendingMachineButton.addActionListener(listener);
    }
}
