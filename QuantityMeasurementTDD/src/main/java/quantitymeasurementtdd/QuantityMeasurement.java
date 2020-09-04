package quantitymeasurementtdd;

import static quantitymeasurementtdd.QuantityMeasurementException.ExceptionType.NULL_VALUE;

public class QuantityMeasurement {
    public boolean compare(Length length1, Length length2) {
        try {
            int value1 = (int) Math.round(length1.getValue() * length1.getUnit().getBaseUnitConversion());
            int value2 = (int) Math.round(length2.getValue() * length2.getUnit().getBaseUnitConversion());
            return Double.compare(value1, value2) == 0;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(e.getMessage(), NULL_VALUE);
        }
    }
}
