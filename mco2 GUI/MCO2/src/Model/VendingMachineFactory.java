package Model;

public class VendingMachineFactory {
    private VendingMachine normalVM;
    private SpecialVendingMachine specialVM;
    private boolean isCreated;

    public VendingMachineFactory() {
        normalVM = new VendingMachine();
        isCreated = false;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }

    public VendingMachine getNormalVM() {
        return normalVM;
    } 

    public SpecialVendingMachine getSpecialVM() {
        return specialVM;
    }

    public void setNormalVM(VendingMachine normalVM) {
        this.normalVM = normalVM;
    }

    public void setSpecialVM(SpecialVendingMachine specialVM) {
        this.specialVM = specialVM;
    }
}
