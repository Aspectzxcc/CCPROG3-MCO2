package Controller;

import Model.VendingMachineFactory;
import View.CreateVendingMachinePanel;

public class CreateVendingMachineController {
    private CreateVendingMachinePanel createVendingMachinePanel;
    private VendingMachineFactory vendingMachineFactory;

    public CreateVendingMachineController(CreateVendingMachinePanel createVendingMachinePanel, VendingMachineFactory vendingMachineFactory) {
        this.createVendingMachinePanel = createVendingMachinePanel;
        this.vendingMachineFactory = vendingMachineFactory;

        this.createVendingMachinePanel.addRegularVendingMachineButtonListener(e -> createRegularActionPerformed());
        this.createVendingMachinePanel.addSpecialVendingMachineButtonListener(e -> createSpecialActionPerformed());
    }

    private void createRegularActionPerformed() {
        vendingMachineFactory.setSpecial(false);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }

    private void createSpecialActionPerformed() {
        vendingMachineFactory.setSpecial(true);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }
}
