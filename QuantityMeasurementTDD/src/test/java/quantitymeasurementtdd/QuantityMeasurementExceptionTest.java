package quantitymeasurementtdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static quantitymeasurementtdd.Unit.FEET;
import static quantitymeasurementtdd.Unit.INCH;

public class QuantityMeasurementExceptionTest {

    private QuantityMeasurement quantityMeasurement;
    private Quantity firstQuantity, secondQuantity;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test(expected = QuantityMeasurementException.class)
    public void givenNullValue_ShouldThrowNullPointerException() {
        firstQuantity = new Quantity(FEET, null);
        secondQuantity = new Quantity(INCH, 1.0);
        quantityMeasurement.compare(firstQuantity, secondQuantity);
        expectedException.expectMessage("null");
    }
}
