package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateVendingMachinePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton regularVendingMachineBtn;
    private JButton specialVendingMachineBtn;

    public CreateVendingMachinePanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create panels for choosing regular or special vending machine
        JPanel chooseTypePanel = new JPanel();
        chooseTypePanel.setLayout(new GridLayout(1, 2));

        regularVendingMachineBtn = new JButton("Regular Vending Machine");
        specialVendingMachineBtn = new JButton("Special Vending Machine");

        chooseTypePanel.add(regularVendingMachineBtn);
        chooseTypePanel.add(specialVendingMachineBtn);

        add(chooseTypePanel, BorderLayout.CENTER);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addRegularVendingMachineBtnListener(ActionListener listener) {
        regularVendingMachineBtn.addActionListener(listener);
    }

    public void addSpecialVendingMachineBtnListener(ActionListener listener) {
        specialVendingMachineBtn.addActionListener(listener);
    }
}
