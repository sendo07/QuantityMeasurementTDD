package quantitymeasurementtdd;

public class QuantityMeasurement {
    public boolean compareQuantity(double feet, double inches) {
        double feetToInches = this.feetToInches(feet);
        return feetToInches == inches;
    }

    private double feetToInches(double feet) {
        return feet * 12;
    }
}
