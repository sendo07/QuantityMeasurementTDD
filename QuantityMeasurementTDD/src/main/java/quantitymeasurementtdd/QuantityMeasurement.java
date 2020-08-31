package quantitymeasurementtdd;

import java.util.function.BiFunction;
import java.util.function.Function;

public class QuantityMeasurement {
    public BiFunction<Double, Double, Boolean> compareQuantity = (feet, inches) -> this.feetToInches.apply(feet).equals(inches);
    private Function<Double, Double> feetToInches = feet -> feet * 12;
}
