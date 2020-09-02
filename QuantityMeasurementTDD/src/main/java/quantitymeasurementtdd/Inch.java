package quantitymeasurementtdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Inch {
    private double value;

    public Inch(double value) {
        this.value = value;
    }
}
