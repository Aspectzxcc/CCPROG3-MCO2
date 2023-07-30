package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;
    private StartingMenuController startingMenuController;
    private CreateVendingMachineController createVendingMachineController;

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;

        startingMenuController = new StartingMenuController(vendingMachineGUI.getStartingMenuPanel());
        createVendingMachineController = new CreateVendingMachineController(vendingMachineGUI.getCreateVendingMachinePanel());
    }




}
