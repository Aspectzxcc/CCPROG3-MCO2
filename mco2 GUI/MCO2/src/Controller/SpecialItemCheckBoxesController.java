package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.SpecialItemCheckBoxesPanel;
import View.SpecialItemQuantityInputPanel;

public class SpecialItemCheckBoxesController {
    private SpecialItemCheckBoxesPanel specialItemCheckBoxesPanel;
    private SpecialItemQuantityInputPanel specialItemQuantityInputPanel;

    public SpecialItemCheckBoxesController(SpecialItemCheckBoxesPanel specialItemCheckBoxesPanel, SpecialItemQuantityInputPanel specialItemQuantityInputPanel) {
        this.specialItemCheckBoxesPanel = specialItemCheckBoxesPanel;
        this.specialItemQuantityInputPanel = specialItemQuantityInputPanel;

        // Add action listeners for the buttons in the panel
        this.specialItemCheckBoxesPanel.addBackButtonListener(e -> backActionPerformed());
        this.specialItemCheckBoxesPanel.addCreateButtonListener(e -> createActionPerformed());
    }

    private void backActionPerformed() {
        specialItemCheckBoxesPanel.getCardLayout().show(specialItemCheckBoxesPanel.getMainPanel(), "StartingMenu");
    }

    private void createActionPerformed() {
        ArrayList<String> selectedItems = getSelectedSpecialItems();

        if (selectedItems.size() < 5) {
            // Show an error message if any of the checkboxes are not selected
            JOptionPane.showMessageDialog(specialItemCheckBoxesPanel,
                    "Please select an option for each category.",
                    "Selection Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        specialItemQuantityInputPanel.setSelectedSpecialItems(selectedItems);
        specialItemQuantityInputPanel.createQuantityInputFields();

        specialItemCheckBoxesPanel.getCardLayout().show(specialItemCheckBoxesPanel.getMainPanel(), "SpecialItemQuantityInput");
    }

    public ArrayList<String> getSelectedSpecialItems() {
        ArrayList<String> selectedItems = new ArrayList<>();

        for (int i = 0; i < specialItemCheckBoxesPanel.getBreadCheckBoxes().length; i++) {
            if (specialItemCheckBoxesPanel.getBreadCheckBoxes()[i].isSelected()) {
                selectedItems.add(specialItemCheckBoxesPanel.getBreadCheckBoxes()[i].getText());
            }
        }

        for (int i = 0; i < specialItemCheckBoxesPanel.getMeatCheckBoxes().length; i++) {
            if (specialItemCheckBoxesPanel.getMeatCheckBoxes()[i].isSelected()) {
                selectedItems.add(specialItemCheckBoxesPanel.getMeatCheckBoxes()[i].getText());
            }
        }

        for (int i = 0; i < specialItemCheckBoxesPanel.getCheeseCheckBoxes().length; i++) {
            if (specialItemCheckBoxesPanel.getCheeseCheckBoxes()[i].isSelected()) {
                selectedItems.add(specialItemCheckBoxesPanel.getCheeseCheckBoxes()[i].getText());
            }
        }

        for (int i = 0; i < specialItemCheckBoxesPanel.getVegetableCheckBoxes().length; i++) {
            if (specialItemCheckBoxesPanel.getVegetableCheckBoxes()[i].isSelected()) {
                selectedItems.add(specialItemCheckBoxesPanel.getVegetableCheckBoxes()[i].getText());
            }
        }

        for (int i = 0; i < specialItemCheckBoxesPanel.getSauceCheckBoxes().length; i++) {
            if (specialItemCheckBoxesPanel.getSauceCheckBoxes()[i].isSelected()) {
                selectedItems.add(specialItemCheckBoxesPanel.getSauceCheckBoxes()[i].getText());
            }
        }

        return selectedItems;
    }
}
