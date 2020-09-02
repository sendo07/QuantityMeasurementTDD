package quantitymeasurementtdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.function.Function;

@Getter
@EqualsAndHashCode
public class Feet {

    private double value;

    public Feet(double value) {
        this.value = value;
    }

    public Function<Double, Double> getFeetInInches = (value) -> value * 12;
}
