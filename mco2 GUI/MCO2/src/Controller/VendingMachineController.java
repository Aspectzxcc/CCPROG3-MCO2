package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;
    private StartingMenuController startingMenuController;
    private CreateVendingMachineController createVendingMachineController;
    private ItemSlotInputController itemSlotInputController;
    private ItemCheckBoxesController itemCheckBoxesController;
    private SpecialItemCheckBoxesController specialItemCheckBoxesController;
    private CreateRegularVendingMachineController createRegularVendingMachineController;

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;

        startingMenuController = new StartingMenuController(vendingMachineGUI.getStartingMenuPanel(), vendingMachineGUI);
        createVendingMachineController = new CreateVendingMachineController(vendingMachineGUI.getCreateVendingMachinePanel());
        itemSlotInputController = new ItemSlotInputController(vendingMachineGUI.getItemSlotInputPanel());
        itemCheckBoxesController = new ItemCheckBoxesController(vendingMachineGUI.getCreateVendingMachinePanel(), 
        vendingMachineGUI.getItemSlotInputPanel(), vendingMachineGUI.getItemCheckBoxesPanel(), 
        vendingMachineGUI.getCreateRegularVendingMachinePanel());
        specialItemCheckBoxesController = new SpecialItemCheckBoxesController(vendingMachineGUI.getSpecialItemCheckBoxesPanel());
        createRegularVendingMachineController = new CreateRegularVendingMachineController(vendingMachineGUI.getCreateRegularVendingMachinePanel(), 
        vendingMachineFactory);
    }
}
