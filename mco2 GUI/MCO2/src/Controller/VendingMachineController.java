package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;

        // Create Controllers
        new StartingMenuController(vendingMachineGUI.getStartingMenuPanel(), vendingMachineGUI, vendingMachineFactory);
        new CreateVendingMachineController(vendingMachineGUI.getCreateVendingMachinePanel(), vendingMachineFactory);
        new ItemSlotInputController(vendingMachineGUI.getItemSlotInputPanel());
        new ItemCheckBoxesController(vendingMachineGUI.getItemSlotInputPanel(), vendingMachineGUI.getItemCheckBoxesPanel(), vendingMachineGUI.getItemQuantityInputPanel());
        new ItemQuantityInputController(vendingMachineGUI.getItemQuantityInputPanel(), vendingMachineFactory);
        new SpecialItemCheckBoxesController(vendingMachineGUI.getSpecialItemCheckBoxesPanel(), vendingMachineGUI.getSpecialItemQuantityInputPanel());
        new SpecialItemQuantityInputController(vendingMachineGUI.getSpecialItemQuantityInputPanel(), vendingMachineFactory);

        // Test Controllers
        new TestMenuController(vendingMachineGUI.getTestMenuPanel(), vendingMachineGUI.getVendingFeaturesPanel(), vendingMachineFactory);
        new VendingFeaturesController(vendingMachineGUI.getVendingFeaturesPanel(), vendingMachineGUI.getSpecialVendingFeaturesPanel(), vendingMachineFactory);
        new SpecialVendingFeaturesController(vendingMachineGUI.getSpecialVendingFeaturesPanel(), vendingMachineFactory);
        
    }

}
