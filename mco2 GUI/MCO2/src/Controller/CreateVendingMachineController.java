package Controller;

import View.CreateVendingMachinePanel;
import View.ItemSlotInputPanel;

public class CreateVendingMachineController {
    private CreateVendingMachinePanel createVendingMachinePanel;

    public CreateVendingMachineController(CreateVendingMachinePanel createVendingMachinePanel) {
        this.createVendingMachinePanel = createVendingMachinePanel;

        this.createVendingMachinePanel.addRegularVendingMachineBtnListener(e -> createRegularActionPerformed());
        this.createVendingMachinePanel.addSpecialVendingMachineBtnListener(e -> createSpecialActionPerformed());
    }

    private void createRegularActionPerformed() {
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }

    private void createSpecialActionPerformed() {
        createVendingMachinePanel.getCardLayout().show(createVendingMachinePanel.getMainPanel(), "ItemSlotInput");
    }
}
