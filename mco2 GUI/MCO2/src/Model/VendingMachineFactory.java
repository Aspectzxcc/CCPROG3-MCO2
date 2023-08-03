package Model;

/**
 * The VendingMachineFactory class is responsible for creating instances of vending machines.
 * It provides methods to create normal vending machines and special vending machines.
 */
public class VendingMachineFactory {
    private VendingMachine normalVM;
    private SpecialVendingMachine specialVM;
    private boolean isCreated;
    private boolean isSpecial;

    /**
     * Creates a new VendingMachineFactory with default settings.
     * The factory is not associated with any vending machines initially.
     */
    public VendingMachineFactory() {
        normalVM = new VendingMachine();
        specialVM = new SpecialVendingMachine();
        isCreated = false; // set to true for debugging purposes
        isSpecial = false; // set to false for debugging purposes
    }

    /**
     * Checks if a vending machine has been created.
     *
     * @return true if a vending machine has been created, false otherwise
     */
    public boolean isCreated() {
        return isCreated;
    }

    /**
     * Checks if the vending machine is a special vending machine.
     *
     * @return true if the vending machine is a special vending machine, false otherwise
     */
    public boolean isSpecial() {
        return isSpecial;
    }

    /**
     * Gets the normal vending machine instance.
     *
     * @return the normal vending machine instance
     */
    public VendingMachine getNormalVM() {
        return normalVM;
    } 

    /**
     * Gets the special vending machine instance.
     *
     * @return the special vending machine instance
     */
    public SpecialVendingMachine getSpecialVM() {
        return specialVM;
    }
    
    /**
     * Sets the flag to indicate if a vending machine has been created.
     *
     * @param isCreated true if a vending machine has been created, false otherwise
     */
    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

    /**
     * Sets the flag to indicate if the vending machine is a special vending machine.
     *
     * @param isSpecial true if the vending machine is a special vending machine, false otherwise
     */
    public void setSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    /**
     * Sets the normal vending machine instance.
     *
     * @param normalVM the normal vending machine instance to set
     */
    public void setNormalVM(VendingMachine normalVM) {
        this.normalVM = normalVM;
    }

    /**
     * Sets the special vending machine instance.
     *
     * @param specialVM the special vending machine instance to set
     */
    public void setSpecialVM(SpecialVendingMachine specialVM) {
        this.specialVM = specialVM;
    }
}
