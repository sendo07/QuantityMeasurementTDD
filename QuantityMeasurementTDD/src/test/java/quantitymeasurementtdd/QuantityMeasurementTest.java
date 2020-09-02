package quantitymeasurementtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class QuantityMeasurementTest {

    private QuantityMeasurement quantityMeasurement;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    @DisplayName("Should Return True")
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnTrueIfCorrect() {
        Feet feet1 = new Feet(1);
        Inch inch1 = new Inch(12);
        boolean feetInInches = feet1
                                .getFeetInInches.apply(feet1.getValue())
                                .equals(inch1.getValue());
        Assert.assertThat(feetInInches, is(true));
    }

    @Test
    @DisplayName("Should Return False")
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnFalseIfIncorrect() {
        Feet feet1 = new Feet(1);
        Inch inch1 = new Inch(10);
        boolean feetInInches = feet1
                                .getFeetInInches.apply(feet1.getValue())
                                .equals(inch1.getValue());
        Assert.assertThat(feetInInches, is(false));
    }

    @Test
    @DisplayName("Values of the objects should be equal")
    public void given0Feetand0Feet_ShouldReturnEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        Assert.assertThat(feet1, is(feet2));
    }

    @Test
    @DisplayName("Reference of two objects is not same")
    public void given0Feetand0Feet_WhenCheckingForReference_ShouldReturnNotEquals() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        boolean isSameReference = feet1 == feet2;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    @DisplayName("Values of the objects should not be equal")
    public void given0Feetand1Feet_ShouldReturnNotEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        Assert.assertThat(feet1, not(feet2));
    }

    @Test
    @DisplayName("Objects are of the same type")
    public void given0Feetand1Feet_WhenComparedForType_ShouldReturnEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        boolean isSameType = feet1.getClass() == feet2.getClass();
        Assert.assertThat(isSameType, is(true));
    }

    @Test
    @DisplayName("Values of the objects should be equal")
    public void given0Inchand0Inch_ShouldReturnEquals() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(0.0);
        Assert.assertThat(inch1, is(inch2));
    }

    @Test
    @DisplayName("Reference of two objects is not same")
    public void given0Inchand0Inch_WhenCheckingForReference_ShouldReturnNotEquals() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(0.0);
        boolean isSameReference = inch1 == inch2;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    @DisplayName("Values of the objects should not be equal")
    public void given0Inchand1Inch_ShouldReturnNotEquals() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(1.0);
        Assert.assertThat(inch1, not(inch2));
    }
}
