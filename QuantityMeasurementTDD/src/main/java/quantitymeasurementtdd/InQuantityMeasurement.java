package quantitymeasurementtdd;

public interface InQuantityMeasurement {
    public boolean compare(Quantity firstQuantity, Quantity secondQuantity);
    public double add(Quantity firstQuantity, Quantity secondQuantity);
}
