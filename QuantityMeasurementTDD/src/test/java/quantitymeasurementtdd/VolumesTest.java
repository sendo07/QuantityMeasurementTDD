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

public class VolumesTest {
    private QuantityMeasurement quantityMeasurement;
    private Quantity firstQuantity, secondQuantity;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenGallonAndLitres_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(GALLON, 1.00);
        secondQuantity = new Quantity(LITRE, 3.78);
        boolean compareVolumes = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareVolumes, is(true));
    }

    @Test
    public void givenGallonAndLitres_WhenCompared_ShouldReturnFalse() {
        firstQuantity = new Quantity(GALLON, 1.00);
        secondQuantity = new Quantity(LITRE, 100.00);
        boolean compareVolumes = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareVolumes, is(false));
    }

    @Test
    public void givenLitresAndMillilitres_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(LITRE, 1.00);
        secondQuantity = new Quantity(MILLILITRE, 1000.00);
        boolean compareVolumes = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareVolumes, is(true));
    }

    @Test
    public void givenGallonsAndLitres_WhenAdded_ShouldReturnCorrectResult() {
        firstQuantity = new Quantity(GALLON, 1.00);
        secondQuantity = new Quantity(LITRE, 3.78);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(7.57, 0.1)));
    }

    @Test
    public void givenLitreAndMillilitres_WhenAdded_ShouldReturnCorrectResult() {
        firstQuantity = new Quantity(LITRE, 1.00);
        secondQuantity = new Quantity(MILLILITRE, 1000.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, is(closeTo(2, 0.1)));
    }

    @Test
    public void givenLitreAndMillilitres_WhenAddedAndComparedWithWrongResult_ShouldFail() {
        firstQuantity = new Quantity(LITRE, 1.00);
        secondQuantity = new Quantity(MILLILITRE, 1000.00);
        double result = quantityMeasurement.add(firstQuantity, secondQuantity);
        Assert.assertThat(result, not(closeTo(10, 0.1)));
    }
}
