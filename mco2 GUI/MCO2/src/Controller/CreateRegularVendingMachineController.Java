package Controller;

import View.CreateRegularVendingMachinePanel;

public class CreateRegularVendingMachineController {
    private CreateRegularVendingMachinePanel createRegularVendingMachinePanel;
    private ArrayList<Integer> itemQuantities;

    public CreateRegularVendingMachineController(CreateRegularVendingMachinePanel createRegularVendingMachinePanel) {
        this.createRegularVendingMachinePanel = createRegularVendingMachinePanel;
        
        this.createRegularVendingMachinePanel.addSubmitButtonListener(e -> submitActionPerformed());
    }
    
    private void submitActionPerformed() {
        if (createRegularVendingMachinePanel.validateQuantities()) {
            // Update the item quantities when the Submit button is clicked.
            itemQuantities = new ArrayList<>();
            for (int i = 0; i < createRegularVendingMachinePanel.getQuantityTextFields().length; i++) {
                String quantityText = createRegularVendingMachinePanel.getQuantityTextFields()[i].getText();
                int quantity = Integer.parseInt(quantityText);
                itemQuantities.add(quantity);
            }
    
            // The rest of the code remains the same.
            // ... (Rest of the code in the CreateRegularVendingMachineController)
        }
    }
    
}