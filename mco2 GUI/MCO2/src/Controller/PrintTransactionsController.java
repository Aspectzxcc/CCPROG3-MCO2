package Controller;

import View.PrintTransactionsPanel;

/**
 * The controller class that manages interactions with the PrintTransactionsPanel.
 * This class handles actions performed by the user on the PrintTransactionsPanel, such as navigating back to the maintenance features panel.
 */
public class PrintTransactionsController {
    private PrintTransactionsPanel printTransactionsPanel;

    /**
     * Constructor for the PrintTransactionsController class.
     * Initializes the controller and sets up action listeners for the buttons in the PrintTransactionsPanel.
     *
     * @param printTransactionsPanel The PrintTransactionsPanel instance representing the panel for printing transactions.
     */
    public PrintTransactionsController(PrintTransactionsPanel printTransactionsPanel) {
        this.printTransactionsPanel = printTransactionsPanel;

        // Add action listener to the back button
        printTransactionsPanel.addBackButtonListener(e -> backButtonActionPerformed());
    }

     /**
     * Action performed when the "Back" button is clicked on the PrintTransactionsPanel.
     * This method switches back to the maintenance features panel.
     */
    private void backButtonActionPerformed() {
        // Move back to the maintenance features panel
        printTransactionsPanel.getCardLayout().show(printTransactionsPanel.getMainPanel(), "MaintenanceFeatures");
    }
}
