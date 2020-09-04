package quantitymeasurementtdd;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Unit {
    FEET(12.00),
    INCH(1.00),
    YARD(36.00);

    private final Double baseUnitConversion;

    Unit(Double baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }
}
