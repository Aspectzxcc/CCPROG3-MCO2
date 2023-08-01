package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton vendingButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    public TestMenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(3, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        vendingButton = new JButton("Vending Features");
        maintenanceButton = new JButton("Maintenance Features");
        exitButton = new JButton("Exit to Starting Menu");

        add(vendingButton);
        add(maintenanceButton);
        add(exitButton);
    }

    public void addVendingButtonListener(ActionListener listener) {
        vendingButton.addActionListener(listener);
    }

    public void addMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
