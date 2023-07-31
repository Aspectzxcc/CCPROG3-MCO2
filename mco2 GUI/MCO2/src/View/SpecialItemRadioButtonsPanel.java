package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialItemRadioButtonsPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton createButton;
    private JLabel breadLabel;
    private JLabel meatLabel;
    private JLabel cheeseLabel;
    private JLabel vegetableLabel;
    private JLabel sauceLabel;
    private JRadioButton[] breadOptionsRadioButtons;
    private JRadioButton[] meatOptionsRadioButtons;
    private JRadioButton[] cheeseOptionsRadioButtons;
    private JRadioButton[] vegetableOptionsRadioButtons;
    private JRadioButton[] sauceOptionsRadioButtons;
    private ButtonGroup breadButtonGroup;
    private ButtonGroup meatButtonGroup;
    private ButtonGroup cheeseButtonGroup;
    private ButtonGroup vegetableButtonGroup;
    private ButtonGroup sauceButtonGroup;

    public SpecialItemRadioButtonsPanel(CardLayout cardLayout, JPanel mainPanel) {
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

        // Radio buttons for bread options
        JPanel breadPanel = new JPanel();
        breadPanel.setLayout(new BoxLayout(breadPanel, BoxLayout.Y_AXIS));
        breadLabel = new JLabel("Bread Options:");
        breadPanel.add(breadLabel);

        String[] breadOptions = {"White Bread", "Whole Wheat Bread", "Multigrain Bread", "Rye Bread", "Baguette", "Ciabatta", "Wrap"};
        breadOptionsRadioButtons = new JRadioButton[breadOptions.length];
        breadButtonGroup = new ButtonGroup();
        for (int i = 0; i < breadOptions.length; i++) {
            breadOptionsRadioButtons[i] = new JRadioButton(breadOptions[i]);
            breadPanel.add(breadOptionsRadioButtons[i]);
            breadButtonGroup.add(breadOptionsRadioButtons[i]);
        }
        optionsPanel.add(breadPanel, gbc);

        // Radio buttons for meat options
        JPanel meatPanel = new JPanel();
        meatPanel.setLayout(new BoxLayout(meatPanel, BoxLayout.Y_AXIS));
        meatLabel = new JLabel("Meat Options:");
        meatPanel.add(meatLabel);

        String[] meatOptions = {"Roast Beef", "Turkey", "Ham", "Chicken", "Tuna", "Bacon", "Salami"};
        meatOptionsRadioButtons = new JRadioButton[meatOptions.length];
        meatButtonGroup = new ButtonGroup();
        for (int i = 0; i < meatOptions.length; i++) {
            meatOptionsRadioButtons[i] = new JRadioButton(meatOptions[i]);
            meatPanel.add(meatOptionsRadioButtons[i]);
            meatButtonGroup.add(meatOptionsRadioButtons[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(meatPanel, gbc);

        // Radio buttons for cheese options
        JPanel cheesePanel = new JPanel();
        cheesePanel.setLayout(new BoxLayout(cheesePanel, BoxLayout.Y_AXIS));
        cheeseLabel = new JLabel("Cheese Options:");
        cheesePanel.add(cheeseLabel);

        String[] cheeseOptions = {"Cheddar Cheese", "Swiss Cheese", "Provolone Cheese", "Pepper Jack Cheese", "Mozzarella Cheese", "Gouda Cheese", "Blue Cheese"};
        cheeseOptionsRadioButtons = new JRadioButton[cheeseOptions.length];
        cheeseButtonGroup = new ButtonGroup();
        for (int i = 0; i < cheeseOptions.length; i++) {
            cheeseOptionsRadioButtons[i] = new JRadioButton(cheeseOptions[i]);
            cheesePanel.add(cheeseOptionsRadioButtons[i]);
            cheeseButtonGroup.add(cheeseOptionsRadioButtons[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(cheesePanel, gbc);

        // Radio buttons for vegetable options
        JPanel vegetablePanel = new JPanel();
        vegetablePanel.setLayout(new BoxLayout(vegetablePanel, BoxLayout.Y_AXIS));
        vegetableLabel = new JLabel("Vegetable Options:");
        vegetablePanel.add(vegetableLabel);

        String[] vegetableOptions = {"Lettuce", "Tomato", "Cucumber", "Onion", "Bell Pepper", "Spinach", "Pickles"};
        vegetableOptionsRadioButtons = new JRadioButton[vegetableOptions.length];
        vegetableButtonGroup = new ButtonGroup();
        for (int i = 0; i < vegetableOptions.length; i++) {
            vegetableOptionsRadioButtons[i] = new JRadioButton(vegetableOptions[i]);
            vegetablePanel.add(vegetableOptionsRadioButtons[i]);
            vegetableButtonGroup.add(vegetableOptionsRadioButtons[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(vegetablePanel, gbc);

        // Radio buttons for sauce options
        JPanel saucePanel = new JPanel();
        saucePanel.setLayout(new BoxLayout(saucePanel, BoxLayout.Y_AXIS));
        sauceLabel = new JLabel("Sauce Options:");
        saucePanel.add(sauceLabel);

        String[] sauceOptions = {"Mayonnaise", "Mustard", "Ketchup", "Ranch Dressing", "BBQ Sauce", "Pesto", "Hummus"};
        sauceOptionsRadioButtons = new JRadioButton[sauceOptions.length];
        sauceButtonGroup = new ButtonGroup();
        for (int i = 0; i < sauceOptions.length; i++) {
            sauceOptionsRadioButtons[i] = new JRadioButton(sauceOptions[i]);
            saucePanel.add(sauceOptionsRadioButtons[i]);
            sauceButtonGroup.add(sauceOptionsRadioButtons[i]);
        }
        gbc.gridx++; // Move to the next column
        gbc.gridy = 0; // Reset the row to the top
        optionsPanel.add(saucePanel, gbc);

        // Add the optionsPanel to the main panel
        add(optionsPanel, BorderLayout.CENTER);
    }

    public ButtonGroup getBreadButtonGroup() {
        return breadButtonGroup;
    }

    public ButtonGroup getMeatButtonGroup() {
        return meatButtonGroup;
    }

    public ButtonGroup getCheeseButtonGroup() {
        return cheeseButtonGroup;
    }

    public ButtonGroup getVegetableButtonGroup() {
        return vegetableButtonGroup;
    }

    public ButtonGroup getSauceButtonGroup() {
        return sauceButtonGroup;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
    
    public void resetRadioButtons() {
        breadButtonGroup.clearSelection();
        meatButtonGroup.clearSelection();
        cheeseButtonGroup.clearSelection();
        vegetableButtonGroup.clearSelection();
        sauceButtonGroup.clearSelection();
    }
}

