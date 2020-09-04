package quantitymeasurementtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.closeTo;
import static quantitymeasurementtdd.Unit.*;

public class LengthsTest {

    private QuantityMeasurement quantityMeasurement;
    private Quantity firstQuantity, secondQuantity;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void given0Feetand0Feet_ShouldReturnEqual() {
        firstQuantity = new Quantity(FEET, 0.0);
        secondQuantity = new Quantity(FEET, 0.0);
        Assert.assertThat(firstQuantity, is(secondQuantity));
    }

    @Test
    public void given0Feetand0Feet_WhenCheckingForReference_ShouldReturnNotEquals() {
        firstQuantity = new Quantity(FEET, 0.0);
        secondQuantity = new Quantity(FEET, 0.0);
        boolean isSameReference = firstQuantity == secondQuantity;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    public void given0Feetand1Feet_ShouldReturnNotEqual() {
        firstQuantity = new Quantity(FEET, 0.0);
        secondQuantity = new Quantity(FEET, 1.0);
        Assert.assertThat(firstQuantity, not(secondQuantity));
    }

    @Test
    public void given0Feetand1Feet_WhenComparedForType_ShouldReturnEqual() {
        Quantity feet1 = new Quantity(FEET, 0.0);
        Quantity feet2 = new Quantity(FEET, 1.0);
        boolean isSameType = feet1.getClass() == feet2.getClass();
        Assert.assertThat(isSameType, is(true));
    }

    @Test
    public void given0Inchand0Inch_ShouldReturnEquals() {
        Quantity inch1 = new Quantity(INCH, 0.0);
        Quantity inch2 = new Quantity(INCH, 0.0);
        Assert.assertThat(inch1, is(inch2));
    }

    @Test
    public void given0Inchand0Inch_WhenCheckingForReference_ShouldReturnNotEquals() {
        Quantity inch1 = new Quantity(INCH, 0.0);
        Quantity inch2 = new Quantity(INCH, 0.0);
        boolean isSameReference = inch1 == inch2;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    public void given0Inchand1Inch_ShouldReturnNotEquals() {
        Quantity inch1 = new Quantity(INCH, 0.0);
        Quantity inch2 = new Quantity(INCH, 1.0);
        Assert.assertThat(inch1, not(inch2));
    }

    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqual() {
        Quantity feet1 = new Quantity(FEET, 1.0);
        Quantity inch1 = new Quantity(INCH, 1.0);
        Assert.assertThat(feet1, not(inch1));
    }

    @Test
    public void given0FeetAnd0Inch_ShouldReturnEqualLength() {
        Quantity feet1 = new Quantity(FEET, 0.0);
        Quantity inch1 = new Quantity(INCH, 0.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertThat(compareCheck, is(true));
    }

    @Test
    public void given1FeetAnd0Inch_WhenCompared_ShouldReturnNotEqualLength() {
        Quantity feet1 = new Quantity(FEET, 1.0);
        Quantity inch1 = new Quantity(INCH, 1.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertThat(compareCheck, is(false));
    }

    @Test
    public void given1FeetAnd1Feet_WhenCompared_ShouldReturnEqualLength() {
        Quantity feet1 = new Quantity(FEET, 0.0);
        Quantity feet2 = new Quantity(FEET, 0.0);
        boolean compareLengths = quantityMeasurement.compare(feet1, feet2);
        Assert.assertThat(compareLengths, is(true));
    }


    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnTrueIfCorrect() {
        Quantity feet1 = new Quantity(FEET, 1.0);
        Quantity inch1 = new Quantity(INCH, 12.0);
        boolean feetInInches = quantityMeasurement.compare(feet1, inch1);
        Assert.assertThat(feetInInches, is(true));
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnFalseIfIncorrect() {
        Quantity feet1 = new Quantity(FEET, 1.0);
        Quantity inch1 = new Quantity(INCH, 10.0);
        boolean feetInInches = quantityMeasurement.compare(feet1, inch1);
        Assert.assertThat(feetInInches, is(false));
    }

    @Test
    public void givenLengthInFeetAndYards_WhenCompared_ShouldReturnTrueIfCorrect() {
        Quantity feet1 = new Quantity(FEET, 3.0);
        Quantity yard1 = new Quantity(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(feet1, yard1);
        Assert.assertThat(checkLengths, is(true));
    }

    @Test
    public void given1FeetAnd1Yard_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(FEET, 1.0);
        secondQuantity = new Quantity(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(checkLengths, is(false));
    }

    @Test
    public void given1InchAnd1Yard_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(INCH, 1.0);
        secondQuantity = new Quantity(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(checkLengths, is(false));
    }

    @Test
    public void given1YardAnd36Inches_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(INCH, 36.0);
        secondQuantity = new Quantity(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(checkLengths, is(true));
    }

    @Test
    public void given2InchesAnd5Cm_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(INCH, 2.0);
        secondQuantity = new Quantity(CENTIMETERS, 5.0);
        boolean checkLengths = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(checkLengths, is(true));
    }

    @Test
    public void given2InchesAnd2Cm_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(INCH, 2.0);
        secondQuantity = new Quantity(CENTIMETERS, 2.0);
        boolean checkLengths = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(checkLengths, is(false));
    }

    @Test
    public void given2InchAnd2Inch_WhenAdded_ShouldReturn4Inch() {
        firstQuantity = new Quantity(INCH, 2.00);
        secondQuantity = new Quantity(INCH, 2.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(4.00, 0.1)));
    }

    @Test
    public void given1FeetAnd2Inch_WhenTestedWithIncorrectResult_ShouldFail() {
        firstQuantity = new Quantity(FEET, 1.00);
        secondQuantity = new Quantity(INCH, 2.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, not(closeTo(10.00, 0.1)));
    }

    @Test
    public void given1FeetAnd2Inch_WhenAdded_ShouldReturn14Inch() {
        firstQuantity = new Quantity(FEET, 1.00);
        secondQuantity = new Quantity(INCH, 2.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(14.00, 0.1)));
    }

    @Test
    public void given1FeetAnd1Feet_WhenAdded_ShouldReturn24Inch() {
        firstQuantity = new Quantity(FEET, 1.00);
        secondQuantity = new Quantity(FEET, 1.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(24.00, 0.1)));
    }

    @Test
    public void givenInchesAndCm_WhenAdded_ShouldReturn3Inch() {
        firstQuantity = new Quantity(INCH, 2.00);
        secondQuantity = new Quantity(CENTIMETERS, 2.50);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(3.00, 0.1)));
    }
}
