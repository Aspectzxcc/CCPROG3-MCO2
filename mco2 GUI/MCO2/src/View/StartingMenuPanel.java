package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartingMenuPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton createVendingMachineBtn;
    private JButton testVendingMachineBtn;
    private JButton exitBtn;

    public StartingMenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridLayout(3, 1));

        createVendingMachineBtn = new JButton("Create Vending Machine");
        testVendingMachineBtn = new JButton("Test Vending Machine");
        exitBtn = new JButton("Exit");

        add(createVendingMachineBtn);
        add(testVendingMachineBtn);
        add(exitBtn);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addCreateVendingMachineBtnListener(ActionListener listener) {
        createVendingMachineBtn.addActionListener(listener);
    }

    public void addTestVendingMachineBtnListener(ActionListener listener) {
        testVendingMachineBtn.addActionListener(listener);
    }

    public void addExitBtnListener(ActionListener listener) {
        exitBtn.addActionListener(listener);
    }

}
