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
    public void setUp() throws Exception {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnTrueIfCorrect() {
        boolean result = quantityMeasurement.compareQuantity(1, 12);
        Assert.assertTrue(result);
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnFasleIfIncorrect() {
        boolean result = quantityMeasurement.compareQuantity(1, 10);
        Assert.assertFalse(result);
    }
}
