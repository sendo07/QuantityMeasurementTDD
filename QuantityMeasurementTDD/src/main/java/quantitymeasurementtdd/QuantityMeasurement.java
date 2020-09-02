package quantitymeasurementtdd;

import java.util.function.BiFunction;

public class QuantityMeasurement <E extends Inch> {
    public BiFunction<Object, Object, Boolean> compareQuantityByInternalValue = (feet, inches) -> feet.equals(inches);
}
