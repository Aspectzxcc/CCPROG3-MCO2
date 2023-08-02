package Controller;

import Model.VendingMachineFactory;
import View.VendingMachineGUI;

/**
 * The controller class that manages interactions between the model and the view for the Vending Machine Factory Simulator.
 * This class connects various controllers with their corresponding panels in the GUI.
 */

public class VendingMachineController{
    private VendingMachineFactory vendingMachineFactory;
    private VendingMachineGUI vendingMachineGUI;

     /**
     * Constructor for the VendingMachineController class.
     * Initializes the VendingMachineFactory and VendingMachineGUI instances and creates various controllers.
     *
     * @param vendingMachineFactory The VendingMachineFactory instance representing the model.
     * @param vendingMachineGUI     The VendingMachineGUI instance representing the main GUI.
     */

    public VendingMachineController(VendingMachineFactory vendingMachineFactory, VendingMachineGUI vendingMachineGUI) {
        this.vendingMachineFactory = vendingMachineFactory;
        this.vendingMachineGUI = vendingMachineGUI;

        // Create Controllers

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

        // Maintenance Controllers
        new MaintenanceFeaturesController(vendingMachineGUI.getMaintenanceFeaturesPanel(), 
        vendingMachineGUI.getRestockItemsPanel(), vendingMachineGUI.getSpecialRestockPanel(), 
        vendingMachineGUI.getSetItemPricesPanel(), vendingMachineGUI.getSpecialSetPricesPanel(), 
        vendingMachineGUI.getCollectMoneyPanel(), vendingMachineGUI.getReplenishMoneyPanel(), 
        vendingMachineGUI.getPrintTransactionsPanel(), vendingMachineFactory);
        new RestockItemsController(vendingMachineGUI.getRestockItemsPanel(), vendingMachineFactory);
        new SpecialRestockController(vendingMachineGUI.getSpecialRestockPanel(), vendingMachineFactory);
        new SetItemPricesController(vendingMachineGUI.getSetItemPricesPanel(), vendingMachineFactory);
        new SpecialSetPricesController(vendingMachineGUI.getSpecialSetPricesPanel(), vendingMachineFactory);
        new CollectMoneyController(vendingMachineGUI.getCollectMoneyPanel(), vendingMachineFactory);
        new ReplenishMoneyController(vendingMachineGUI.getReplenishMoneyPanel(), vendingMachineFactory);
        new PrintTransactionsController(vendingMachineGUI.getPrintTransactionsPanel());
    }

    /**
     * Get the VendingMachineFactory instance associated with this controller.
     *
     * @return The VendingMachineFactory instance.
     */

    public VendingMachineFactory getVendingMachineFactory() {
        return vendingMachineFactory;
    }

    /**
     * Get the VendingMachineGUI instance associated with this controller.
     *
     * @return The VendingMachineGUI instance.
     */

    public VendingMachineGUI getVendingMachineGUI() {
        return vendingMachineGUI;
    }

}
