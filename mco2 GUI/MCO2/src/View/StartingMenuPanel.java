package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartingMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton createVendingMachineBtn;
    private JButton testVendingMachineBtn;
    private JButton exitButton;

    public StartingMenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(3, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))  ;

        createVendingMachineBtn = new JButton("Create Vending Machine");
        testVendingMachineBtn = new JButton("Test Vending Machine");
        exitButton = new JButton("Exit");

        add(createVendingMachineBtn);
        add(testVendingMachineBtn);
        add(exitButton);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addCreateVendingMachineButtonListener(ActionListener listener) {
        createVendingMachineBtn.addActionListener(listener);
    }

    public void addTestVendingMachineButtonListener(ActionListener listener) {
        testVendingMachineBtn.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
