package quantitymeasurementtdd;

public class QuantityMeasurement {
    public boolean compare(Length l1, Length l2) {
        return Double.compare
                (l1.getValue() * l1.getUnit().getBaseUnitConversion(),
                l2.getValue() * l2.getUnit().getBaseUnitConversion()) == 0;
    }
}
