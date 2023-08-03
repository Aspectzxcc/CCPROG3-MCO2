package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The SpecialItemCheckBoxesPanel class represents the panel for selecting special item options in the vending machine configuration.
 */
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

    /**
     * Creates a new SpecialItemCheckBoxesPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public SpecialItemCheckBoxesPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(128, 0, 0)); // Dark red background color
        backButton.setForeground(Color.WHITE); // White text color
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        backButton.setFocusPainted(false); // Remove focus border
        add(backButton, BorderLayout.NORTH);

        // Create button
        createButton = new JButton("Create Special Vending Machine");
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setBackground(new Color(0, 128, 0)); // Dark green background color
        createButton.setForeground(Color.WHITE); // White text color
        createButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        createButton.setFocusPainted(false); // Remove focus border
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

    /**
     * Gets the Create button used to create a special vending machine.
     *
     * @return the Create button
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * Gets the Back button used to go back to the previous panel.
     *
     * @return the Back button
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Gets the CardLayout used in the main frame.
     *
     * @return the CardLayout
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Gets the main panel that contains all the panels in the main frame.
     *
     * @return the main panel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets the array of bread options checkboxes.
     *
     * @return the array of bread options checkboxes
     */
    public JCheckBox[] getBreadCheckBoxes() {
        return breadCheckBoxes;
    }

    /**
     * Gets the array of meat options checkboxes.
     *
     * @return the array of meat options checkboxes
     */
    public JCheckBox[] getMeatCheckBoxes() {
        return meatCheckBoxes;
    }

    /**
     * Gets the array of cheese options checkboxes.
     *
     * @return the array of cheese options checkboxes
     */
    public JCheckBox[] getCheeseCheckBoxes() {
        return cheeseCheckBoxes;
    }

    /**
     * Gets the array of vegetable options checkboxes.
     *
     * @return the array of vegetable options checkboxes
     */
    public JCheckBox[] getVegetableCheckBoxes() {
        return vegetableCheckBoxes;
    }

    /**
     * Gets the array of sauce options checkboxes.
     *
     * @return the array of sauce options checkboxes
     */
    public JCheckBox[] getSauceCheckBoxes() {
        return sauceCheckBoxes;
    }

    /**
     * Adds an ActionListener to the Create button.
     *
     * @param listener the ActionListener to add
     */
    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the Back button.
     *
     * @param listener the ActionListener to add
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    /**
     * Checks if a specific bread option is selected.
     *
     * @param breadOption the bread option to check
     * @return true if the bread option is selected, false otherwise
     */
    public boolean isBreadSelected(String breadOption) {
        for (JCheckBox checkBox : breadCheckBoxes) {
            if (checkBox.getText().equals(breadOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific meat option is selected.
     *
     * @param meatOption the meat option to check
     * @return true if the meat option is selected, false otherwise
     */
    public boolean isMeatSelected(String meatOption) {
        for (JCheckBox checkBox : meatCheckBoxes) {
            if (checkBox.getText().equals(meatOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific cheese option is selected.
     *
     * @param cheeseOption the cheese option to check
     * @return true if the cheese option is selected, false otherwise
     */
    public boolean isCheeseSelected(String cheeseOption) {
        for (JCheckBox checkBox : cheeseCheckBoxes) {
            if (checkBox.getText().equals(cheeseOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific vegetable option is selected.
     *
     * @param vegetableOption the vegetable option to check
     * @return true if the vegetable option is selected, false otherwise
     */
    public boolean isVegetableSelected(String vegetableOption) {
        for (JCheckBox checkBox : vegetableCheckBoxes) {
            if (checkBox.getText().equals(vegetableOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a specific sauce option is selected.
     *
     * @param sauceOption the sauce option to check
     * @return true if the sauce option is selected, false otherwise
     */
    public boolean isSauceSelected(String sauceOption) {
        for (JCheckBox checkBox : sauceCheckBoxes) {
            if (checkBox.getText().equals(sauceOption) && checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Resets all the checkboxes to be unselected.
     */
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
