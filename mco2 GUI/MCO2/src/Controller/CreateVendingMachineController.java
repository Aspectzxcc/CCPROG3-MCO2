package Controller;

import View.CreateVendingMachinePanel;

public class CreateVendingMachineController {
    private CreateVendingMachinePanel createVendingMachinePanel;

    public CreateVendingMachineController(CreateVendingMachinePanel createVendingMachinePanel) {
        this.createVendingMachinePanel = createVendingMachinePanel;

        this.createVendingMachinePanel.addRegularVendingMachineBtnListener(e -> createRegularActionPerformed());
        this.createVendingMachinePanel.addSpecialVendingMachineBtnListener(e -> createSpecialActionPerformed());
    }

    private void createRegularActionPerformed() {
        createVendingMachinePanel.setIsSpecial(false);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }

    private void createSpecialActionPerformed() {
        createVendingMachinePanel.setIsSpecial(true);
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }
}
