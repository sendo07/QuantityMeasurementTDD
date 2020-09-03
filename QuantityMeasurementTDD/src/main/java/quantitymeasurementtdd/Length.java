package quantitymeasurementtdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.function.Function;

@Getter
@EqualsAndHashCode
public class Length {

    private Unit unit;
    private double value;

    public Length(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public Function<Double, Double> getFeetInInches = (value) -> value * 12;
}
