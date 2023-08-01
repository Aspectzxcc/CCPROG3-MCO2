package Controller;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import View.SpecialItemQuantityInputPanel;
import View.SpecialItemRadioButtonsPanel;

public class SpecialItemRadioButtonsController {
    private SpecialItemRadioButtonsPanel specialItemRadioButtonsPanel;
    private SpecialItemQuantityInputPanel specialItemQuantityInputPanel;

    public SpecialItemRadioButtonsController(SpecialItemRadioButtonsPanel specialItemRadioButtonsPanel, SpecialItemQuantityInputPanel specialItemQuantityInputPanel) {
        this.specialItemRadioButtonsPanel = specialItemRadioButtonsPanel;
        this.specialItemQuantityInputPanel = specialItemQuantityInputPanel;

        // Add action listeners for the buttons in the panel
        this.specialItemRadioButtonsPanel.addBackButtonListener(e -> backActionPerformed());
        this.specialItemRadioButtonsPanel.addCreateButtonListener(e -> createActionPerformed());
    }

    private void backActionPerformed() {
        specialItemRadioButtonsPanel.getCardLayout().show(specialItemRadioButtonsPanel.getMainPanel(), "StartingMenu");
    }

    private void createActionPerformed() {
        ArrayList<String> selectedItems;

        selectedItems = getSelectedSpecialItems();

        specialItemQuantityInputPanel.setSelectedSpecialItems(selectedItems);
        specialItemQuantityInputPanel.createQuantityInputFields();

        specialItemRadioButtonsPanel.getCardLayout().show(specialItemRadioButtonsPanel.getMainPanel(), "SpecialItemQuantityInput");
    }

    public ArrayList<String> getSelectedSpecialItems() {
        ArrayList<String> selectedItems = new ArrayList<>();
    
        ButtonGroup breadButtonGroup = specialItemRadioButtonsPanel.getBreadButtonGroup();
        ButtonGroup meatButtonGroup = specialItemRadioButtonsPanel.getMeatButtonGroup();
        ButtonGroup cheeseButtonGroup = specialItemRadioButtonsPanel.getCheeseButtonGroup();
        ButtonGroup vegetableButtonGroup = specialItemRadioButtonsPanel.getVegetableButtonGroup();
        ButtonGroup sauceButtonGroup = specialItemRadioButtonsPanel.getSauceButtonGroup();
    
        // Explicitly check for null values and handle the case where no button is selected
        String bread = getSelectedButtonText(breadButtonGroup);
        String meat = getSelectedButtonText(meatButtonGroup);
        String cheese = getSelectedButtonText(cheeseButtonGroup);
        String vegetable = getSelectedButtonText(vegetableButtonGroup);
        String sauce = getSelectedButtonText(sauceButtonGroup);
    
        if (bread == null || meat == null || cheese == null || vegetable == null || sauce == null) {
            // Show an error message if any of the radio buttons are not selected
            JOptionPane.showMessageDialog(specialItemRadioButtonsPanel,
                    "Please select an option for each category.",
                    "Selection Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    
        selectedItems.add(bread);
        selectedItems.add(meat);
        selectedItems.add(cheese);
        selectedItems.add(vegetable);
        selectedItems.add(sauce);
    
        return selectedItems;
    }
    
    
    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null; // Return null if no button is selected
    }
}
