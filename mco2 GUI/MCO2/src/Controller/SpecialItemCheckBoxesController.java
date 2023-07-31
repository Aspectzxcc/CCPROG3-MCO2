package Controller;

import java.util.ArrayList;
import View.SpecialItemCheckBoxesPanel;

public class SpecialItemCheckBoxesController {
    private SpecialItemCheckBoxesPanel specialItemCheckBoxesPanel;

    public SpecialItemCheckBoxesController(SpecialItemCheckBoxesPanel specialItemCheckBoxesPanel) {
        this.specialItemCheckBoxesPanel = specialItemCheckBoxesPanel;

        // Add action listeners for the buttons in the panel
        this.specialItemCheckBoxesPanel.addBackButtonListener(e -> backActionPerformed());
        this.specialItemCheckBoxesPanel.addCreateButtonListener(e -> createActionPerformed());
    }

    private void backActionPerformed() {
        specialItemCheckBoxesPanel.getCardLayout().show(specialItemCheckBoxesPanel.getMainPanel(), "StartingMenu");
    }

    private void createActionPerformed() {
        specialItemCheckBoxesPanel.getCardLayout().show(specialItemCheckBoxesPanel.getMainPanel(), "CreateSpecialVendingMachine");
    }

    public ArrayList<String> getSelectedSpecialItems() {
    ArrayList<String> selectedItems = new ArrayList<>();

    // Checkboxes for bread options
    for (int i = 0; i < specialItemCheckBoxesPanel.getBreadOptionsCheckBoxes().length; i++) {
        if (specialItemCheckBoxesPanel.getBreadOptionsCheckBoxes()[i].isSelected()) {
            selectedItems.add(specialItemCheckBoxesPanel.getBreadOptionsCheckBoxes()[i].getText());
        }
    }

    // Checkboxes for meat options
    for (int i = 0; i < specialItemCheckBoxesPanel.getMeatOptionsCheckBoxes().length; i++) {
        if (specialItemCheckBoxesPanel.getMeatOptionsCheckBoxes()[i].isSelected()) {
            selectedItems.add(specialItemCheckBoxesPanel.getMeatOptionsCheckBoxes()[i].getText());
        }
    }

    // Checkboxes for cheese options
    for (int i = 0; i < specialItemCheckBoxesPanel.getCheeseOptionsCheckBoxes().length; i++) {
        if (specialItemCheckBoxesPanel.getCheeseOptionsCheckBoxes()[i].isSelected()) {
            selectedItems.add(specialItemCheckBoxesPanel.getCheeseOptionsCheckBoxes()[i].getText());
        }
    }

    // Checkboxes for vegetable options
    for (int i = 0; i < specialItemCheckBoxesPanel.getVegetableOptionsCheckBoxes().length; i++) {
        if (specialItemCheckBoxesPanel.getVegetableOptionsCheckBoxes()[i].isSelected()) {
            selectedItems.add(specialItemCheckBoxesPanel.getVegetableOptionsCheckBoxes()[i].getText());
        }
    }

    // Checkboxes for sauce options
    for (int i = 0; i < specialItemCheckBoxesPanel.getSauceOptionsCheckBoxes().length; i++) {
        if (specialItemCheckBoxesPanel.getSauceOptionsCheckBoxes()[i].isSelected()) {
            selectedItems.add(specialItemCheckBoxesPanel.getSauceOptionsCheckBoxes()[i].getText());
        }
    }

    return selectedItems;
    }
}
