package quantitymeasurementtdd;

import java.util.Arrays;

import static quantitymeasurementtdd.QuantityMeasurementException.ExceptionType.NULL_VALUE;

public class QuantityMeasurement implements InQuantityMeasurement {
    @Override
    public boolean compare(Length length1, Length length2) {
        try {
            checkException(length1, length2);
            double[] convertedToCommonBase = valuesConvertedToCommonBase(length1, length2);
            return Double.compare((int) convertedToCommonBase[0], (int) convertedToCommonBase[1]) == 0;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(e.getMessage(), NULL_VALUE);
        }
    }

    @Override
    public double add(Length length1, Length length2) {
        return Arrays.stream(this.valuesConvertedToCommonBase(length1, length2)).sum();
    }

    private double[] valuesConvertedToCommonBase(Length length1, Length length2) {
        double value1 = Math.round(length1.getValue() * length1.getUnit().getBaseUnitConversion());
        double value2 = Math.round(length2.getValue() * length2.getUnit().getBaseUnitConversion());
        return new double[] {value1, value2};
    }

    private void checkException(Length length1, Length length2) {
        if (length1.getValue() == null || length2.getValue() == null)
            throw new NullPointerException("null");
    }
}
