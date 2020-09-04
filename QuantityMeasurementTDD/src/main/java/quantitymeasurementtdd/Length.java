package quantitymeasurementtdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

import static quantitymeasurementtdd.Unit.FEET;
import static quantitymeasurementtdd.Unit.INCH;

@Getter
@EqualsAndHashCode
@ToString
public class Length {

    private static final double FEET_TO_INCH = 12;
    private Unit unit;
    private Double value;

    public Length(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public Function<Double, Double> getFeetInInches = (value) -> value * 12;

    public boolean compare(Length that) {
        if (this.unit.equals(FEET) && that.unit.equals(FEET))
            return Double.compare(this.value, that.value) == 0;
        if (this.unit.equals(FEET) && that.unit.equals(INCH))
            return Double.compare(this.value * FEET_TO_INCH, that.value) == 0;
        return false;
    }
}
