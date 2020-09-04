package quantitymeasurementtdd;

import static quantitymeasurementtdd.QuantityMeasurementException.ExceptionType.NULL_VALUE;

public class QuantityMeasurement {
    public boolean compare(Length l1, Length l2) {
        try {
            return Double.compare
                    (l1.getValue() * l1.getUnit().getBaseUnitConversion(),
                            l2.getValue() * l2.getUnit().getBaseUnitConversion()) == 0;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(e.getMessage(), NULL_VALUE);
        }
    }
}
