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

public class WeightsTest {
    private QuantityMeasurement quantityMeasurement;
    private Quantity firstQuantity, secondQuantity;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenKilogramAndGrams_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(KILOGRAM, 1.00);
        secondQuantity = new Quantity(GRAM, 1000.00);
        boolean compareWeight = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareWeight, is(true));
    }

    @Test
    public void givenKilogramAndGrams_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(KILOGRAM, 1.00);
        secondQuantity = new Quantity(GRAM, 2000.00);
        boolean compareWeight = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareWeight, is(false));
    }

    @Test
    public void givenKilogramAndTonne_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(KILOGRAM, 1000.00);
        secondQuantity = new Quantity(TONNE, 1.00);
        boolean compareWeight = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareWeight, is(true));
    }

    @Test
    public void givenTonneAndGrams_WhenAdded_ShouldReturnCorrectResult() {
        firstQuantity = new Quantity(TONNE, 1.00);
        secondQuantity = new Quantity(GRAM, 1000.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(1001.00, 0.1)));
    }

    @Test
    public void givenTonneAndGrams_WhenAddedAndComparedWithIncorrectValue_ShouldFail() {
        firstQuantity = new Quantity(TONNE, 1.00);
        secondQuantity = new Quantity(GRAM, 1000.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, not(closeTo(500.00, 0.1)));
    }
}
