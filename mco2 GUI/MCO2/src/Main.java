import Model.VendingMachineFactory;
import Controller.VendingMachineController;
import View.VendingMachineGUI;

public class Main {
    public static void main(String[] args) {
        // Create instances of the Model, View, and Controller
        VendingMachineFactory vendingMachineFactory = new VendingMachineFactory();
        VendingMachineGUI vendingMachineGUI = new VendingMachineGUI();
        new VendingMachineController(vendingMachineFactory, vendingMachineGUI);
    }
}
