package quantitymeasurementtdd;

import java.util.function.BiFunction;
import java.util.function.Function;

public class QuantityMeasurement {
    BiFunction<Double, Double, Boolean> compareQuantity = (feet, inches) -> this.feetToInches.apply(feet).equals(inches);
    Function<Double, Double> feetToInches = feet -> feet * 12;
}
