package Controller;

import View.ItemCheckBoxesPanel;
import View.ItemSlotInputPanel;
import javax.swing.JOptionPane;
import View.ItemQuantityInputPanel;

import java.util.ArrayList;

/**
 * The controller class that manages interactions with the ItemCheckBoxesPanel.
 * This class handles actions performed by the user on the ItemCheckBoxesPanel,
 * such as selecting items and continuing to the next step.
 */
public class ItemCheckBoxesController {
    private ItemSlotInputPanel itemSlotInputPanel;
    private ItemCheckBoxesPanel itemCheckBoxesPanel;
    private ItemQuantityInputPanel itemQuantityInputPanel;

    /**
     * Constructor for the ItemCheckBoxesController class.
     * Initializes the controller and sets up action listeners for the buttons in the ItemCheckBoxesPanel.
     *
     * @param itemSlotInputPanel The ItemSlotInputPanel instance representing the panel for inputting the number of slots in the vending machine.
     * @param itemCheckBoxesPanel The ItemCheckBoxesPanel instance representing the panel for selecting items to add to the vending machine.
     * @param itemQuantityInputPanel The ItemQuantityInputPanel instance representing the panel for inputting item quantities.
     */
    public ItemCheckBoxesController(ItemSlotInputPanel itemSlotInputPanel, ItemCheckBoxesPanel itemCheckBoxesPanel, ItemQuantityInputPanel 
    itemQuantityInputPanel) {
        this.itemSlotInputPanel = itemSlotInputPanel;
        this.itemCheckBoxesPanel = itemCheckBoxesPanel;
        this.itemQuantityInputPanel = itemQuantityInputPanel;

        this.itemCheckBoxesPanel.addBackButtonListener(e -> backButtonActionPerformed());
        this.itemCheckBoxesPanel.addContinueButtonListener(e -> continueActionPerformed());
    }

    /**
     * Action performed when the user clicks the back button.
     * Shows the previous panel in the card layout (StartingMenu).
     */
    private void backButtonActionPerformed() {
        itemCheckBoxesPanel.getCardLayout().show(itemCheckBoxesPanel.getMainPanel(), "StartingMenu");
    }

    /**
     * Action performed when the user clicks the continue button.
     * Validates the number of selected items and the number of available slots.
     * If the input is valid, moves to the next panel (ItemQuantityInput).
     */
    private void continueActionPerformed() {
        int selectedItemCount = 0;
        if (itemCheckBoxesPanel.getClassicBLTCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getTurkeyClubCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getHamAndCheeseCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getChickenSaladCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getTunaSaladCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getVeggieDelightCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getItalianSubCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getGrilledChickenPaniniCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getEggSaladCheckBox().isSelected()) selectedItemCount++;
        if (itemCheckBoxesPanel.getRoastBeefAndCheddarCheckBox().isSelected()) selectedItemCount++;

        int slotCount = Integer.parseInt(itemSlotInputPanel.getSlotsTextField().getText());

        if (selectedItemCount == slotCount) {
            itemQuantityInputPanel.setSelectedItems(getSelectedItems());
            itemQuantityInputPanel.createQuantityInputFields();
                
            itemCheckBoxesPanel.getCardLayout().show(itemCheckBoxesPanel.getMainPanel(), "ItemQuantityInput");
        } else if (selectedItemCount > slotCount) {
            // Show an error message that the user has selected more items than available slots
            JOptionPane.showMessageDialog(itemCheckBoxesPanel, "You have selected more items than available slots.");
        } else {
            // Show an error message that the user has selected less items than available slots
            JOptionPane.showMessageDialog(itemCheckBoxesPanel, "You have selected less items than available slots.");
        }
    }

    /**
     * Helper method to get the list of selected items from the ItemCheckBoxesPanel.
     *
     * @return An ArrayList of Strings representing the names of the selected items.
     */
    private ArrayList<String> getSelectedItems() {
        ArrayList<String> selectedItems = new ArrayList<>();
        if (itemCheckBoxesPanel.getClassicBLTCheckBox().isSelected()) {
            selectedItems.add("Classic BLT");
        }
        if (itemCheckBoxesPanel.getTurkeyClubCheckBox().isSelected()) {
            selectedItems.add("Turkey Club");
        }
        if (itemCheckBoxesPanel.getHamAndCheeseCheckBox().isSelected()) {
            selectedItems.add("Ham and Cheese");
        }
        if (itemCheckBoxesPanel.getChickenSaladCheckBox().isSelected()) {
            selectedItems.add("Chicken Salad");
        }
        if (itemCheckBoxesPanel.getTunaSaladCheckBox().isSelected()) {
            selectedItems.add("Tuna Salad");
        }
        if (itemCheckBoxesPanel.getVeggieDelightCheckBox().isSelected()) {
            selectedItems.add("Veggie Delight");
        }
        if (itemCheckBoxesPanel.getItalianSubCheckBox().isSelected()) {
            selectedItems.add("Italian Sub");
        }
        if (itemCheckBoxesPanel.getGrilledChickenPaniniCheckBox().isSelected()) {
            selectedItems.add("Grilled Chicken Panini");
        }
        if (itemCheckBoxesPanel.getEggSaladCheckBox().isSelected()) {
            selectedItems.add("Egg Salad");
        }
        if (itemCheckBoxesPanel.getRoastBeefAndCheddarCheckBox().isSelected()) {
            selectedItems.add("Roast Beef and Cheddar");
        }
    
        return selectedItems;
    }
}
