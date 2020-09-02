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

    @Test
    public void given0Feetand0Feet_ShouldReturnEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void given0Feetand1Feet_ShouldReturnNotEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void given0Inchand0Inch_ShouldReturnEquals() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(0.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void given0Inchand1Inch_ShouldReturnNotEquals() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(1.0);
        Assert.assertNotEquals(inch1, inch2);
    }
}
