package quantitymeasurementtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QuantityMeasurementTest {

    private QuantityMeasurement quantityMeasurement;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnTrueIfCorrect() {
        boolean result = quantityMeasurement.compareQuantity.apply(1.00, 12.00);
        Assert.assertTrue(result);
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnFalseIfIncorrect() {
        boolean result = quantityMeasurement.compareQuantity.apply(1.00, 10.00);
        Assert.assertFalse(result);
    }
}
