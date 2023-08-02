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
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        vendingButton = new JButton("Vending Features");
        maintenanceButton = new JButton("Maintenance Features");
        exitButton = new JButton("Exit to Starting Menu");

        // Customize the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        vendingButton.setFont(buttonFont);
        maintenanceButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        vendingButton.setBackground(new Color(243, 175, 95)); // Set button background color
        vendingButton.setForeground(Color.WHITE); // Set button text color

        maintenanceButton.setBackground(new Color(153, 204, 255)); // different color
        maintenanceButton.setForeground(Color.WHITE);

        exitButton.setBackground(new Color(100, 255, 193));
        exitButton.setForeground(Color.WHITE);

        // Remove focus border when the button is clicked
        vendingButton.setFocusPainted(false); 
        maintenanceButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        // Add the buttons to the panel
        add(vendingButton);
        add(maintenanceButton);
        add(exitButton);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
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
