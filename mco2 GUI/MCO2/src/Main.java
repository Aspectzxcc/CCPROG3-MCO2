import Model.VendingMachineFactory;
import Controller.VendingMachineController;
import View.VendingMachineGUI;

public class Main {
    public static void main(String[] args) {
        // Create instances of the Model, View, and Controller
        VendingMachineFactory vendingMachineFactory = new VendingMachineFactory();
        VendingMachineGUI vendingMachineGUI = new VendingMachineGUI();
        VendingMachineController controller = new VendingMachineController(vendingMachineFactory, vendingMachineGUI);

        // Set the controller for the GUI
        vendingMachineGUI.setController(controller);
    }
}
