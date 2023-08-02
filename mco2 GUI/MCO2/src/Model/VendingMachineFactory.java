package Model;

public class VendingMachineFactory {
    private VendingMachine normalVM;
    private SpecialVendingMachine specialVM;
    private boolean isCreated;
    private boolean isSpecial;

    public VendingMachineFactory() {
        normalVM = new VendingMachine();
        specialVM = new SpecialVendingMachine();
        isCreated = true; // auto set to true for debugging purposes
        isSpecial = true; // auto set to false for debugging purposes
    }

    // Getters
    public boolean isCreated() {
        return isCreated;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public VendingMachine getNormalVM() {
        return normalVM;
    } 

    public SpecialVendingMachine getSpecialVM() {
        return specialVM;
    }
    
    // Setters
    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

    public void setSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

    public void setNormalVM(VendingMachine normalVM) {
        this.normalVM = normalVM;
    }

    public void setSpecialVM(SpecialVendingMachine specialVM) {
        this.specialVM = specialVM;
    }
}
