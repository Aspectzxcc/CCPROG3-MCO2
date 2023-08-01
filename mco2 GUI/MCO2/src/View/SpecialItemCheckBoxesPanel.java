package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialItemCheckBoxesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton createButton;
    private JLabel breadLabel;
    private JLabel meatLabel;
    private JLabel cheeseLabel;
    private JLabel vegetableLabel;
    private JLabel sauceLabel;
    private JCheckBox[] breadCheckBoxes;
    private JCheckBox[] meatCheckBoxes;
    private JCheckBox[] cheeseCheckBoxes;
    private JCheckBox[] vegetableCheckBoxes;
    private JCheckBox[] sauceCheckBoxes;

    public SpecialItemCheckBoxesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Back button
        backButton = new JButton("Back");
        add(backButton, BorderLayout.NORTH);

        // Create button
        createButton = new JButton("Create Special Vending Machine");
        add(createButton, BorderLayout.SOUTH);

        // Create a panel for the options using GridBagLayout
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 10, 5, 10); // Add some padding to the components

        // Checkboxes for bread options
        JPanel breadPanel = new JPanel();
        breadPanel.setLayout(new BoxLayout(breadPanel, BoxLayout.Y_AXIS));
        breadLabel = new JLabel("Bread Options:");
        breadPanel.add(breadLabel);

        String[] breadOptions = {"White Bread", "Whole Wheat Bread", "Multigrain Bread", "Rye Bread", "Baguette", "Ciabatta", "Wrap"};
        breadCheckBoxes = new JCheckBox[breadOptions.length];
        for (int i = 0; i < breadOptions.length; i++) {
            breadCheckBoxes[i] = new JCheckBox(breadOptions[i]);
            breadPanel.add(breadCheckBoxes[i]);
        }
        optionsPanel.add(breadPanel, gbc);

        // Checkboxes for meat options
        JPanel meatPanel = new JPanel();
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS));
        meatLabel = new JLabel("Meat Options:");
        meatPanel.add(meatLabel);

        String[] meatOptions = {"Roast Beef", "Turkey", "Ham", "Chicken", "Tuna", "Bacon", "Salami"};
        meatCheckBoxes = new JCheckBox[meatOptions.length];
        for (int i = 0; i < meatOptions.length; i++) {
            meatCheckBoxes[i] = new JCheckBox(meatOptions[i]);
            meatPanel.add(meatCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(meatPanel, gbc);

        // Checkboxes for cheese options
        JPanel cheesePanel = new JPanel();
        cheesePanel.setLayout(new BoxLayout(cheesePanel, BoxLayout.Y_AXIS));
        cheeseLabel = new JLabel("Cheese Options:");
        cheesePanel.add(cheeseLabel);

        String[] cheeseOptions = {"Cheddar Cheese", "Swiss Cheese", "Provolone Cheese", "Pepper Jack Cheese", "Mozzarella Cheese", "Gouda Cheese", "Blue Cheese"};
        cheeseCheckBoxes = new JCheckBox[cheeseOptions.length];
        for (int i = 0; i < cheeseOptions.length; i++) {
            cheeseCheckBoxes[i] = new JCheckBox(cheeseOptions[i]);
            cheesePanel.add(cheeseCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(cheesePanel, gbc);

        // Checkboxes for vegetable options
        JPanel vegetablePanel = new JPanel();
        vegetablePanel.setLayout(new BoxLayout(vegetablePanel, BoxLayout.Y_AXIS));
        vegetableLabel = new JLabel("Vegetable Options:");
        vegetablePanel.add(vegetableLabel);

        String[] vegetableOptions = {"Lettuce", "Tomato", "Cucumber", "Onion", "Bell Pepper", "Spinach", "Pickles"};
        vegetableCheckBoxes = new JCheckBox[vegetableOptions.length];
        for (int i = 0; i < vegetableOptions.length; i++) {
            vegetableCheckBoxes[i] = new JCheckBox(vegetableOptions[i]);
            vegetablePanel.add(vegetableCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(vegetablePanel, gbc);

        // Checkboxes for sauce options
        JPanel saucePanel = new JPanel();
        saucePanel.setLayout(new BoxLayout(saucePanel, BoxLayout.Y_AXIS));
        sauceLabel = new JLabel("Sauce Options:");
        saucePanel.add(sauceLabel);

        String[] sauceOptions = {"Mayonnaise", "Mustard", "Ketchup", "Ranch Dressing", "BBQ Sauce", "Pesto", "Hummus"};
        sauceCheckBoxes = new JCheckBox[sauceOptions.length];
        for (int i = 0; i < sauceOptions.length; i++) {
            sauceCheckBoxes[i] = new JCheckBox(sauceOptions[i]);
            saucePanel.add(sauceCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(saucePanel, gbc);

        // Add the optionsPanel to the main panel
        add(optionsPanel, BorderLayout.CENTER);
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JCheckBox[] getBreadCheckBoxes() {
        return breadCheckBoxes;
    }

    public JCheckBox[] getMeatCheckBoxes() {
        return meatCheckBoxes;
    }   

    public JCheckBox[] getCheeseCheckBoxes() {
        return cheeseCheckBoxes;
    }

    public JCheckBox[] getVegetableCheckBoxes() {
        return vegetableCheckBoxes;
    }

    public JCheckBox[] getSauceCheckBoxes() {
        return sauceCheckBoxes;
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public boolean isBreadSelected(String breadOption) {
        for (JCheckBox checkBox : breadCheckBoxes) {
            if (checkBox.getText().equals(breadOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isMeatSelected(String meatOption) {
        for (JCheckBox checkBox : meatCheckBoxes) {
            if (checkBox.getText().equals(meatOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheeseSelected(String cheeseOption) {
        for (JCheckBox checkBox : cheeseCheckBoxes) {
            if (checkBox.getText().equals(cheeseOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isVegetableSelected(String vegetableOption) {
        for (JCheckBox checkBox : vegetableCheckBoxes) {
            if (checkBox.getText().equals(vegetableOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSauceSelected(String sauceOption) {
        for (JCheckBox checkBox : sauceCheckBoxes) {
            if (checkBox.getText().equals(sauceOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void resetCheckBoxes() {
        for (JCheckBox checkBox : breadCheckBoxes) {
            checkBox.setSelected(false);
        }

        for (JCheckBox checkBox : meatCheckBoxes) {
            checkBox.setSelected(false);
        }

        for (JCheckBox checkBox : cheeseCheckBoxes) {
            checkBox.setSelected(false);
        }

        for (JCheckBox checkBox : vegetableCheckBoxes) {
            checkBox.setSelected(false);
        }

        for (JCheckBox checkBox : sauceCheckBoxes) {
            checkBox.setSelected(false);
        }
    }
}