package quantitymeasurementtdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

import static quantitymeasurementtdd.Unit.FEET;
import static quantitymeasurementtdd.Unit.INCH;

@Getter
@EqualsAndHashCode
@ToString
public class Quantity {

    private Unit unit;
    private Double value;

    public Quantity(Unit unit, Double value) {
        this.unit = unit;
        this.value = value;
    }

    public Optional<Double> getValueOptional() {
        return Optional.ofNullable(this.value);
    }

    public boolean compare(Quantity that) {
        if (this.unit.equals(FEET) && that.unit.equals(FEET))
            return Double.compare(this.value, that.value) == 0;
        if (this.unit.equals(FEET) && that.unit.equals(INCH))
            return Double.compare(this.value * FEET.getBaseUnitConversion(), that.value) == 0;
        return false;
    }
}
