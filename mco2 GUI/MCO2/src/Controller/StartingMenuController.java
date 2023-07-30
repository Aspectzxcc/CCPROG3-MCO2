package Controller;

import View.StartingMenuPanel;

public class StartingMenuController {
    private StartingMenuPanel startingMenuPanel;

    public StartingMenuController(StartingMenuPanel startingMenuPanel) {
        this.startingMenuPanel = startingMenuPanel;

        this.startingMenuPanel.addCreateVendingMachineBtnListener(e -> createActionPerformed());
        this.startingMenuPanel.addTestVendingMachineBtnListener(e -> testActionPerformed());
    }

    private void createActionPerformed() {
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "CreateVendingMachine");
    }

    private void testActionPerformed() {
        startingMenuPanel.getCardLayout().show(startingMenuPanel.getMainPanel(), "TestVendingMachine");
    }
}
