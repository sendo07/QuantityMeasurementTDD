package quantitymeasurementtdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static quantitymeasurementtdd.Unit.FEET;
import static quantitymeasurementtdd.Unit.INCH;

public class QuantityMeasurementExceptionTest {

    private QuantityMeasurement quantityMeasurement;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test(expected = QuantityMeasurementException.class)
    public void givenNullValues_ShouldThrowNullPointerException() {
        Length feet1 = new Length(FEET, null);
        Length inch2 = new Length(INCH, 1.0);
        boolean checkForNull = quantityMeasurement.compare(feet1, inch2);
        expectedException.expectMessage("null");
    }
}
