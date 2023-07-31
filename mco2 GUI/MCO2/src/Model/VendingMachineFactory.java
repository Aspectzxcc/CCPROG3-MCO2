package Model;

public class VendingMachineFactory {
    private VendingMachine normalVM;
    private boolean isCreated;

    public VendingMachineFactory() {
        normalVM = new VendingMachine();
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

    public void setNormalVM(VendingMachine normalVM) {
        this.normalVM = normalVM;
    }
}
