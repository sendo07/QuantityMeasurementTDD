package quantitymeasurementtdd;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Unit {
    // CommonBase for Length is Inch
    FEET(12.00),
    INCH(1.00),
    YARD(36.00),
    CENTIMETERS(0.39);

    private final Double baseUnitConversion;

    Unit(Double baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }
}
