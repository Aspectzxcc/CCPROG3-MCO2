package Model;

public class Money {
    static private int[] validDenominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    private int denomination;

    public Money(int denomination) {
        boolean isValidDenomination = false;
        for (int validDenomination : validDenominations) {
            if (denomination == validDenomination) {
                isValidDenomination = true;
                break;
            }
        }
        if (!isValidDenomination) {
            throw new IllegalArgumentException("Invalid denomination. The denomination must be one of: 1, 5, 10, 20, 50, 100, 200, 500, 1000.");
        }
        this.denomination = denomination;
    }

    static public int[] getValidDenominations() {
        return validDenominations;
    }

    public int getDenomination() {
        return denomination;
    }

    @Override
    public String toString() {
        return "₱" + denomination;
    }
}

