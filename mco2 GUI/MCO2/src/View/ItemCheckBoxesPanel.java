package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ItemCheckBoxesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;
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
        setBackground(new Color(230, 230, 255)); // Set the background color to a light blue

        // Back button 
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(128, 0, 0)); // Dark red background color
        backButton.setForeground(Color.WHITE); // White text color
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        backButton.setFocusPainted(false); // Remove focus border

        JPanel titlePanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Select Items for the Vending Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(backButton, BorderLayout.WEST); // Add the back button to the left of the title

        add(titlePanel, BorderLayout.NORTH);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(5, 2));
        checkBoxPanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        // Initialize the checkboxes
        classicBLTCheckBox = new JCheckBox("Classic BLT");
        classicBLTCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        turkeyClubCheckBox = new JCheckBox("Turkey Club");
        turkeyClubCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        hamAndCheeseCheckBox = new JCheckBox("Ham and Cheese");
        hamAndCheeseCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        chickenSaladCheckBox = new JCheckBox("Chicken Salad");
        chickenSaladCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        tunaSaladCheckBox = new JCheckBox("Tuna Salad");
        tunaSaladCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        veggieDelightCheckBox = new JCheckBox("Veggie Delight");
        veggieDelightCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        italianSubCheckBox = new JCheckBox("Italian Sub");
        italianSubCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        grilledChickenPaniniCheckBox = new JCheckBox("Grilled Chicken Panini");
        grilledChickenPaniniCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        eggSaladCheckBox = new JCheckBox("Egg Salad");
        eggSaladCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        roastBeefAndCheddarCheckBox = new JCheckBox("Roast Beef and Cheddar");
        roastBeefAndCheddarCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add checkboxes to the panel
        checkBoxPanel.add(turkeyClubCheckBox);
        checkBoxPanel.add(classicBLTCheckBox);
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
        continueButton.setFont(new Font("Arial", Font.PLAIN, 16));
        continueButton.setBackground(new Color(50, 150, 50)); // Green background color
        continueButton.setForeground(Color.WHITE); // White text color
        continueButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add some padding
        continueButton.setFocusPainted(false); // Remove focus border

        // Add a hover effect when the mouse enters the button
        continueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(40, 130, 40)); // Darker green on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(50, 150, 50)); // Restore the original green on exit
            }
        });

        buttonPanel.add(continueButton);
        buttonPanel.setBackground(new Color(235, 240, 240)); // Light gray background color

        add(checkBoxPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public JCheckBox getClassicBLTCheckBox() {
        return classicBLTCheckBox;
    }

    public JCheckBox getTurkeyClubCheckBox() {
        return turkeyClubCheckBox;
    }

    public JCheckBox getHamAndCheeseCheckBox() {
        return hamAndCheeseCheckBox;
    }

    public JCheckBox getChickenSaladCheckBox() {
        return chickenSaladCheckBox;
    }

    public JCheckBox getTunaSaladCheckBox() {
        return tunaSaladCheckBox;
    }

    public JCheckBox getVeggieDelightCheckBox() {
        return veggieDelightCheckBox;
    }

    public JCheckBox getItalianSubCheckBox() {
        return italianSubCheckBox;
    }

    public JCheckBox getGrilledChickenPaniniCheckBox() {
        return grilledChickenPaniniCheckBox;
    }

    public JCheckBox getEggSaladCheckBox() {
        return eggSaladCheckBox;
    }

    public JCheckBox getRoastBeefAndCheddarCheckBox() {
        return roastBeefAndCheddarCheckBox;
    }

    public void resetCheckBoxes() {
        classicBLTCheckBox.setSelected(false);
        turkeyClubCheckBox.setSelected(false);
        hamAndCheeseCheckBox.setSelected(false);
        chickenSaladCheckBox.setSelected(false);
        tunaSaladCheckBox.setSelected(false);
        veggieDelightCheckBox.setSelected(false);
        italianSubCheckBox.setSelected(false);
        grilledChickenPaniniCheckBox.setSelected(false);
        eggSaladCheckBox.setSelected(false);
        roastBeefAndCheddarCheckBox.setSelected(false);
    }

    public void addContinueButtonListener(ActionListener listener) {
        continueButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
