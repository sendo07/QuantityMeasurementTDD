package quantitymeasurementtdd;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Unit {
    // CommonBaseUnit for Length is Inch
    FEET(12.00),
    INCH(1.00),
    YARD(36.00),
    CENTIMETERS(0.39),

    // CommonBaseUnit for Volumes is Litre
    GALLON(3.78),
    LITRE(1.00),
    MILLILITRE(0.001),

    // CommonBaseUnit for Volumes is Kilograms
    KILOGRAM(1.00),
    GRAM(0.001),
    TONNE(1000.00);

    private final Double baseUnitConversion;

    Unit(Double baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }
}
