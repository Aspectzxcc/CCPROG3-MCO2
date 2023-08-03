package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * The CollectMoneyPanel class represents a panel for displaying and collecting payments received.
 * It provides a table to display the denominations and quantities of payments received,
 * as well as buttons for collecting the payments and navigating back.
 */
public class CollectMoneyPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTable paymentTable;
    private DefaultTableModel tableModel;
    private JButton collectButton;
    private JButton backButton;

    /**
     * Creates a new CollectMoneyPanel with the specified CardLayout and main panel.
     *
     * @param cardLayout the CardLayout used to switch between panels in the main frame
     * @param mainPanel  the main panel that contains all the panels in the main frame
     */
    public CollectMoneyPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Initialize the title label
        titleLabel = new JLabel("Payment Received");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set custom font and size
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Initialize the payment table
        String[] columnNames = {"Denomination", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        paymentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        // Initialize the collect button
        collectButton = new JButton("Collect");
        collectButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        collectButton.setBackground(Color.GREEN); // Set button background color
        collectButton.setForeground(Color.WHITE); // Set button text color
        collectButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        collectButton.setFocusPainted(false); // Remove focus border

        // Initialize the back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set custom font and size
        backButton.setBackground(Color.RED); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Add some padding
        backButton.setFocusPainted(false); // Remove focus border

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Align buttons in the center with some spacing
        buttonPanel.add(collectButton);
        buttonPanel.add(backButton);

        // Add components to the panel
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Returns the CardLayout used by this panel.
     *
     * @return the CardLayout
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * Returns the main panel that contains all the panels in the main frame.
     *
     * @return the main panel
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Returns the payment table
     *
     * @return the payment table
     */
    public JTable getPaymentTable() {
        return paymentTable;
    }

    /**
     * Sets the payment received data in the payment table.
     *
     * @param paymentReceived a map containing denominations and their corresponding quantities
     */
    public void setPaymentReceivedData(Map<Integer, Integer> paymentReceived) {
        // Clear the existing data from the table
        tableModel.setRowCount(0);

        // Add the payment received data to the table
        for (int denomination : paymentReceived.keySet()) {
            int quantity = paymentReceived.get(denomination);
            tableModel.addRow(new Object[]{denomination, quantity});
        }
    }

    /**
     * Returns the index of the selected row in the payment table.
     *
     * @return the index of the selected row
     */
    public int getSelectedRow() {
        return paymentTable.getSelectedRow();
    }

    /**
     * Prompts the user to enter the quantity to collect and returns the entered quantity.
     *
     * @return the quantity to collect, or -1 if the input is invalid or cancelled
     */
    public int getQuantityToCollect() {
        String input = JOptionPane.showInputDialog(this, "Enter the quantity to collect:");
        if (input != null && !input.isEmpty()) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                return -1; // Invalid quantity
            }
        }
        return -1; // Cancelled or empty input
    }

    /**
     * Adds an ActionListener to the "Collect" button.
     *
     * @param listener the ActionListener to add
     */
    public void addCollectButtonListener(ActionListener listener) {
        collectButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Back" button.
     *
     * @param listener the ActionListener to add
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
