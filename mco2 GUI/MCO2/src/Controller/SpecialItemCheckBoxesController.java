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
        boolean breadSelected = false;
        boolean meatSelected = false;
        boolean cheeseSelected = false;
        boolean vegetableSelected = false;
        boolean sauceSelected = false;

        // Show an error message if the user has not selected at least one of each option
        for (String item : selectedItems) {
            if (item.equals("White Bread") || item.equals("Whole Weat Bread") || 
            item.equals("Multigrain Bread") || item.equals("Rye Bread") || 
            item.equals("Baguette") || item.equals("Ciabatta") || item.equals("Wrap")) {
                breadSelected = true;
            } else if (item.equals("Roast Beef") || item.equals("Turkey") || item.equals("Ham") || 
            item.equals("Chicken") || item.equals("Tuna") || 
            item.equals("Bacon") || item.equals("Salami")) {
                meatSelected = true;
            } else if (item.equals("Cheddar Cheese") || item.equals("Swiss Cheese") || item.equals("Provolone Cheese") || 
            item.equals("Pepper Jack Cheese") || item.equals("Mozzarella Cheese") || 
            item.equals("Gouda Cheese") || item.equals("Blue Cheese")) {
                cheeseSelected = true;
            } else if (item.equals("Lettuce") || item.equals("Tomato") || item.equals("Cucumber") || 
            item.equals("Onion") || item.equals("Bell Pepper") || 
            item.equals("Spinach") || item.equals("Pickles")) {
                vegetableSelected = true;
            } else if (item.equals("Mayonnaise") || item.equals("Mustard") || item.equals("Ketchup") || 
            item.equals("Ranch Dressing") || item.equals("BBQ Sauce") || 
            item.equals("Pesto") || item.equals("Hummus")) {
                sauceSelected = true;
            }
        }

        if (breadSelected == false || meatSelected == false || cheeseSelected == false || vegetableSelected == false || sauceSelected == false) {
            JOptionPane.showMessageDialog(specialItemCheckBoxesPanel,
                    "Please select at least one of each option.",
                    "Missing Option",
                    JOptionPane.WARNING_MESSAGE);
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
