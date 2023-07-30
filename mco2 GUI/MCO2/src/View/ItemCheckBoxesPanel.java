package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ItemCheckBoxesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JCheckBox classicBLTCheckBox;
    private JCheckBox turkeyClubCheckBox;
    private JCheckBox hamAndCheeseCheckBox;
    private JCheckBox chickenSaladCheckBox;
    private JCheckBox tunaSaladCheckBox;
    private JCheckBox veggieDelightCheckBox;
    private JCheckBox italianSubCheckBox;
    private JCheckBox grilledChickenPaniniCheckBox;
    private JCheckBox eggSaladCheckBox;
    private JCheckBox roastBeefAndCheddarCheckBox;
    private JButton continueButton;

    public ItemCheckBoxesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Select Items for the Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(5, 2));

        classicBLTCheckBox = new JCheckBox("Classic BLT");
        turkeyClubCheckBox = new JCheckBox("Turkey Club");
        hamAndCheeseCheckBox = new JCheckBox("Ham and Cheese");
        chickenSaladCheckBox = new JCheckBox("Chicken Salad");
        tunaSaladCheckBox = new JCheckBox("Tuna Salad");
        veggieDelightCheckBox = new JCheckBox("Veggie Delight");
        italianSubCheckBox = new JCheckBox("Italian Sub");
        grilledChickenPaniniCheckBox = new JCheckBox("Grilled Chicken Panini");
        eggSaladCheckBox = new JCheckBox("Egg Salad");
        roastBeefAndCheddarCheckBox = new JCheckBox("Roast Beef and Cheddar");

        checkBoxPanel.add(classicBLTCheckBox);
        checkBoxPanel.add(turkeyClubCheckBox);
        checkBoxPanel.add(hamAndCheeseCheckBox);
        checkBoxPanel.add(chickenSaladCheckBox);
        checkBoxPanel.add(tunaSaladCheckBox);
        checkBoxPanel.add(veggieDelightCheckBox);
        checkBoxPanel.add(italianSubCheckBox);
        checkBoxPanel.add(grilledChickenPaniniCheckBox);
        checkBoxPanel.add(eggSaladCheckBox);
        checkBoxPanel.add(roastBeefAndCheddarCheckBox);

        JPanel buttonPanel = new JPanel();
        continueButton = new JButton("Continue");
        buttonPanel.add(continueButton);

        add(checkBoxPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addContinueButtonListener(ActionListener listener) {
        continueButton.addActionListener(listener);
    }
}
