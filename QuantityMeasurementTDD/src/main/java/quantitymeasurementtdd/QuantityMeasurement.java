package quantitymeasurementtdd;

import static quantitymeasurementtdd.QuantityMeasurementException.ExceptionType.NULL_VALUE;

public class QuantityMeasurement {
    public boolean compare(Length length1, Length length2) {
        try {
            return Double.compare
                    (length1.getValue() * length1.getUnit().getBaseUnitConversion(),
                     length2.getValue() * length2.getUnit().getBaseUnitConversion()) == 0;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(e.getMessage(), NULL_VALUE);
        }
    }
}
