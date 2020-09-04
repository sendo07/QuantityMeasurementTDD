package quantitymeasurementtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static quantitymeasurementtdd.Unit.*;

public class LengthsMeasurementTest {

    private QuantityMeasurement quantityMeasurement;
    private Length feet1, inch1, yard1;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void given0Feetand0Feet_ShouldReturnEqual() {
        Length feet1 = new Length(FEET, 0.0);
        Length feet2 = new Length(FEET, 0.0);
        Assert.assertThat(feet1, is(feet2));
    }

    @Test
    public void given0Feetand0Feet_WhenCheckingForReference_ShouldReturnNotEquals() {
        Length feet1 = new Length(FEET, 0.0);
        Length feet2 = new Length(FEET, 0.0);
        boolean isSameReference = feet1 == feet2;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    public void given0Feetand1Feet_ShouldReturnNotEqual() {
        Length feet1 = new Length(FEET, 0.0);
        Length feet2 = new Length(FEET, 1.0);
        Assert.assertThat(feet1, not(feet2));
    }

    @Test
    public void given0Feetand1Feet_WhenComparedForType_ShouldReturnEqual() {
        Length feet1 = new Length(FEET, 0.0);
        Length feet2 = new Length(FEET, 1.0);
        boolean isSameType = feet1.getClass() == feet2.getClass();
        Assert.assertThat(isSameType, is(true));
    }

    @Test
    public void given0Inchand0Inch_ShouldReturnEquals() {
        Length inch1 = new Length(INCH, 0.0);
        Length inch2 = new Length(INCH, 0.0);
        Assert.assertThat(inch1, is(inch2));
    }

    @Test
    public void given0Inchand0Inch_WhenCheckingForReference_ShouldReturnNotEquals() {
        Length inch1 = new Length(INCH, 0.0);
        Length inch2 = new Length(INCH, 0.0);
        boolean isSameReference = inch1 == inch2;
        Assert.assertThat(isSameReference, is(false));
    }

    @Test
    public void given0Inchand1Inch_ShouldReturnNotEquals() {
        Length inch1 = new Length(INCH, 0.0);
        Length inch2 = new Length(INCH, 1.0);
        Assert.assertThat(inch1, not(inch2));
    }

    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqual() {
        Length feet1 = new Length(FEET, 1.0);
        Length inch1 = new Length(INCH, 1.0);
        Assert.assertThat(feet1, not(inch1));
    }

    @Test
    public void given0FeetAnd0Inch_ShouldReturnEqualLength() {
        Length feet1 = new Length(FEET, 0.0);
        Length inch1 = new Length(INCH, 0.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertThat(compareCheck, is(true));
    }

    @Test
    public void given1FeetAnd0Inch_WhenCompared_ShouldReturnNotEqualLength() {
        Length feet1 = new Length(FEET, 1.0);
        Length inch1 = new Length(INCH, 1.0);
        boolean compareCheck = feet1.compare(inch1);
        Assert.assertThat(compareCheck, is(false));
    }

    @Test
    public void given1FeetAnd1Feet_WhenCompared_ShouldReturnEqualLength() {
        Length feet1 = new Length(FEET, 0.0);
        Length feet2 = new Length(FEET, 0.0);
        boolean compareCheck = feet1.compare(feet2);
        boolean compare = quantityMeasurement.compare(feet1, feet2);
        Assert.assertThat(compare, is(true));
    }


    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnTrueIfCorrect() {
        Length feet1 = new Length(FEET, 1.0);
        Length inch1 = new Length(INCH, 12.0);
        boolean feetInInches = quantityMeasurement.compare(feet1, inch1);
        Assert.assertThat(feetInInches, is(true));
    }

    @Test
    public void givenLengthInFeetAndInches_WhenCompared_ShouldReturnFalseIfIncorrect() {
        Length feet1 = new Length(FEET, 1.0);
        Length inch1 = new Length(INCH, 10.0);
        boolean feetInInches = quantityMeasurement.compare(feet1, inch1);
        Assert.assertThat(feetInInches, is(false));
    }

    @Test
    public void givenLengthInFeetAndYards_WhenCompared_ShouldReturnTrueIfCorrect() {
        Length feet1 = new Length(FEET, 3.0);
        Length yard1 = new Length(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(feet1, yard1);
        Assert.assertThat(checkLengths, is(true));
    }

    @Test
    public void given1FeetAnd1Yard_WhenCompared_ShouldReturnFalse() {
        feet1 = new Length(FEET, 1.0);
        yard1 = new Length(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(feet1, yard1);
        Assert.assertThat(checkLengths, is(false));
    }

    @Test
    public void given1InchAnd1Yard_WhenCompared_ShouldReturnFalse() {
        inch1 = new Length(INCH, 1.0);
        yard1 = new Length(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(inch1, yard1);
        Assert.assertThat(checkLengths, is(false));
    }

    @Test
    public void given1YardAnd36Inches_WhenCompared_ShouldReturnFalse() {
        inch1 = new Length(INCH, 36.0);
        yard1 = new Length(YARD, 1.0);
        boolean checkLengths = quantityMeasurement.compare(inch1, yard1);
        Assert.assertThat(checkLengths, is(true));
    }
}
