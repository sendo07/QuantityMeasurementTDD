package quantitymeasurementtdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static quantitymeasurementtdd.QuantityMeasurementException.ExceptionType.NULL_VALUE;

public class QuantityMeasurement implements InQuantityMeasurement {
    @Override
    public boolean compare(Quantity quantity1, Quantity quantity2) throws QuantityMeasurementException {
        checkException(quantity1, quantity2);
        double[] convertedToCommonBase = valuesConvertedToCommonBase(quantity1, quantity2);
        return Double.compare(Math.round(convertedToCommonBase[0]), Math.round(convertedToCommonBase[1])) == 0;
    }

    @Override
    public double add(Quantity quantity1, Quantity quantity2) throws QuantityMeasurementException{
        checkException(quantity1, quantity2);
        return Arrays.stream(this.valuesConvertedToCommonBase(quantity1, quantity2)).sum();
    }

    private double[] valuesConvertedToCommonBase(Quantity quantity1, Quantity quantity2) {
        double value1 = (quantity1.getValue() * quantity1.getUnit().getBaseUnitConversion());
        double value2 = (quantity2.getValue() * quantity2.getUnit().getBaseUnitConversion());
        return new double[] {value1, value2};
    }

    private void checkException(Quantity quantity1, Quantity quantity2) {
        try {
            List<Quantity> quantities = new ArrayList<>(Arrays.asList(quantity1, quantity2));
            quantities.forEach(quantity -> quantity.getValueOptional()
                            .orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(e.getMessage(), NULL_VALUE);
        }
    }
}
