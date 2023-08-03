package Controller;

import Model.VendingMachineFactory;
import View.CreateVendingMachinePanel;

/**
 * The controller class that manages interactions with the CreateVendingMachinePanel.
 * This class handles actions performed by the user on the CreateVendingMachinePanel,
 * such as choosing to create a regular or special vending machine.
 */
public class CreateVendingMachineController {
    private CreateVendingMachinePanel createVendingMachinePanel;
    private VendingMachineFactory vendingMachineFactory;

    /**
     * Constructor for the CreateVendingMachineController class.
     * Initializes the controller and sets up action listeners for the buttons in the CreateVendingMachinePanel.
     *
     * @param createVendingMachinePanel The CreateVendingMachinePanel instance representing the panel for creating a vending machine.
     * @param vendingMachineFactory The VendingMachineFactory instance used to create the vending machine.
     */
    public CreateVendingMachineController(CreateVendingMachinePanel createVendingMachinePanel, VendingMachineFactory vendingMachineFactory) {
        this.createVendingMachinePanel = createVendingMachinePanel;
        this.vendingMachineFactory = vendingMachineFactory;

        this.createVendingMachinePanel.addRegularVendingMachineButtonListener(e -> createRegularActionPerformed());
        this.createVendingMachinePanel.addSpecialVendingMachineButtonListener(e -> createSpecialActionPerformed());
    }

    /**
     * Action performed when the user clicks the "Create Regular Vending Machine" button.
     * Sets the vending machine type to regular and moves to the next panel (ItemSlotInput).
     */
    private void createRegularActionPerformed() {
        vendingMachineFactory.setSpecial(false);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }

     /**
     * Action performed when the user clicks the "Create Special Vending Machine" button.
     * Sets the vending machine type to special and moves to the next panel (ItemSlotInput).
     */
    private void createSpecialActionPerformed() {
        vendingMachineFactory.setSpecial(true);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }
}
