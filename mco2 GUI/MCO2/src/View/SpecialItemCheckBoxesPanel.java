package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialItemCheckBoxesPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton createButton;
    private JCheckBox[] breadOptionsCheckBoxes;
    private JCheckBox[] meatOptionsCheckBoxes;
    private JCheckBox[] cheeseOptionsCheckBoxes;
    private JCheckBox[] vegetableOptionsCheckBoxes;
    private JCheckBox[] sauceOptionsCheckBoxes;

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
        JLabel breadLabel = new JLabel("Bread Options:");
        breadPanel.add(breadLabel);

        String[] breadOptions = {"White Bread", "Whole Wheat Bread", "Multigrain Bread", "Rye Bread", "Baguette", "Ciabatta", "Wrap"};
        breadOptionsCheckBoxes = new JCheckBox[breadOptions.length];
        for (int i = 0; i < breadOptions.length; i++) {
            breadOptionsCheckBoxes[i] = new JCheckBox(breadOptions[i]);
            breadPanel.add(breadOptionsCheckBoxes[i]);
        }
        optionsPanel.add(breadPanel, gbc);

        // Checkboxes for meat options
        JPanel meatPanel = new JPanel();
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS));
        JLabel meatLabel = new JLabel("Meat Options:");
        meatPanel.add(meatLabel);

        String[] meatOptions = {"Roast Beef", "Turkey", "Ham", "Chicken", "Tuna", "Bacon", "Salami"};
        meatOptionsCheckBoxes = new JCheckBox[meatOptions.length];
        for (int i = 0; i < meatOptions.length; i++) {
            meatOptionsCheckBoxes[i] = new JCheckBox(meatOptions[i]);
            meatPanel.add(meatOptionsCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(meatPanel, gbc);

        // Checkboxes for cheese options
        JPanel cheesePanel = new JPanel();
        cheesePanel.setLayout(new BoxLayout(cheesePanel, BoxLayout.Y_AXIS));
        JLabel cheeseLabel = new JLabel("Cheese Options:");
        cheesePanel.add(cheeseLabel);

        String[] cheeseOptions = {"Cheddar Cheese", "Swiss Cheese", "Provolone Cheese", "Pepper Jack Cheese", "Mozzarella Cheese", "Gouda Cheese", "Blue Cheese"};
        cheeseOptionsCheckBoxes = new JCheckBox[cheeseOptions.length];
        for (int i = 0; i < cheeseOptions.length; i++) {
            cheeseOptionsCheckBoxes[i] = new JCheckBox(cheeseOptions[i]);
            cheesePanel.add(cheeseOptionsCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(cheesePanel, gbc);

        // Checkboxes for vegetable options
        JPanel vegetablePanel = new JPanel();
        vegetablePanel.setLayout(new BoxLayout(vegetablePanel, BoxLayout.Y_AXIS));
        JLabel vegetableLabel = new JLabel("Vegetable Options:");
        vegetablePanel.add(vegetableLabel);

        String[] vegetableOptions = {"Lettuce", "Tomato", "Cucumber", "Onion", "Bell Pepper", "Spinach", "Pickles"};
        vegetableOptionsCheckBoxes = new JCheckBox[vegetableOptions.length];
        for (int i = 0; i < vegetableOptions.length; i++) {
            vegetableOptionsCheckBoxes[i] = new JCheckBox(vegetableOptions[i]);
            vegetablePanel.add(vegetableOptionsCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(vegetablePanel, gbc);

        // Checkboxes for sauce options
        JPanel saucePanel = new JPanel();
        saucePanel.setLayout(new BoxLayout(saucePanel, BoxLayout.Y_AXIS));
        JLabel sauceLabel = new JLabel("Sauce Options:");
        saucePanel.add(sauceLabel);

        String[] sauceOptions = {"Mayonnaise", "Mustard", "Ketchup", "Ranch Dressing", "BBQ Sauce", "Pesto", "Hummus"};
        sauceOptionsCheckBoxes = new JCheckBox[sauceOptions.length];
        for (int i = 0; i < sauceOptions.length; i++) {
            sauceOptionsCheckBoxes[i] = new JCheckBox(sauceOptions[i]);
            saucePanel.add(sauceOptionsCheckBoxes[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(saucePanel, gbc);

        // Add the optionsPanel to the main panel
        add(optionsPanel, BorderLayout.CENTER);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JCheckBox[] getBreadOptionsCheckBoxes() {
        return breadOptionsCheckBoxes;
    }

    public JCheckBox[] getMeatOptionsCheckBoxes() {
        return meatOptionsCheckBoxes;
    }

    public JCheckBox[] getCheeseOptionsCheckBoxes() {
        return cheeseOptionsCheckBoxes;
    }
    
    public JCheckBox[] getVegetableOptionsCheckBoxes() {
        return vegetableOptionsCheckBoxes;
    }

    public JCheckBox[] getSauceOptionsCheckBoxes() {
        return sauceOptionsCheckBoxes;
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
    
    public void resetCheckBoxes(){
        for (JCheckBox checkBox : breadOptionsCheckBoxes) {
            checkBox.setSelected(false);
        }
        for (JCheckBox checkBox : meatOptionsCheckBoxes) {
            checkBox.setSelected(false);
        }
        for (JCheckBox checkBox : cheeseOptionsCheckBoxes) {
            checkBox.setSelected(false);
        }
        for (JCheckBox checkBox : vegetableOptionsCheckBoxes) {
            checkBox.setSelected(false);
        }
        for (JCheckBox checkBox : sauceOptionsCheckBoxes) {
            checkBox.setSelected(false);
        }
    }
}
