package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;

        new StartingMenuController(vendingMachineGUI.getStartingMenuPanel(), vendingMachineGUI, vendingMachineFactory);
        new CreateVendingMachineController(vendingMachineGUI.getCreateVendingMachinePanel());
        new ItemSlotInputController(vendingMachineGUI.getItemSlotInputPanel());
        new ItemCheckBoxesController(vendingMachineGUI.getItemSlotInputPanel(), vendingMachineGUI.getItemCheckBoxesPanel(), vendingMachineGUI.getItemQuantityInputPanel());
        new ItemQuantityInputController(vendingMachineGUI.getCreateVendingMachinePanel(), vendingMachineGUI.getItemQuantityInputPanel(), vendingMachineFactory);
        new SpecialItemRadioButtonsController(vendingMachineGUI.getSpecialItemRadioButtonsPanel(), vendingMachineGUI.getSpecialItemQuantityInputPanel());
        new SpecialItemQuantityInputController(vendingMachineGUI.getSpecialItemQuantityInputPanel(), vendingMachineFactory);
    }
}
