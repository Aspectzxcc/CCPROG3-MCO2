package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateVendingMachinePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton regularVendingMachineButton;
    private JButton specialVendingMachineButton;
    private Boolean isSpecial;

    public CreateVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.isSpecial = false;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create panels for choosing regular or special vending machine
        JPanel chooseTypePanel = new JPanel();
        chooseTypePanel.setLayout(new GridLayout(1, 2));

        regularVendingMachineButton = new JButton("Regular Vending Machine");
        specialVendingMachineButton = new JButton("Special Vending Machine");

        chooseTypePanel.add(regularVendingMachineButton);
        chooseTypePanel.add(specialVendingMachineButton);

        add(chooseTypePanel, BorderLayout.CENTER);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public void addRegularVendingMachineButtonListener(ActionListener listener) {
        regularVendingMachineButton.addActionListener(listener);
    }

    public void addSpecialVendingMachineButtonListener(ActionListener listener) {
        specialVendingMachineButton.addActionListener(listener);
    }
}
