package Controller;

import View.PrintTransactionsPanel;

public class PrintTransactionsController {
    private PrintTransactionsPanel printTransactionsPanel;

    public PrintTransactionsController(PrintTransactionsPanel printTransactionsPanel) {
        this.printTransactionsPanel = printTransactionsPanel;

        // Add action listener to the back button
        printTransactionsPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        printTransactionsPanel.getCardLayout().show(printTransactionsPanel.getMainPanel(), "MaintenanceFeatures");
    }
}
