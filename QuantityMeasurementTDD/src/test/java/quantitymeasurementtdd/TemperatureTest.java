package quantitymeasurementtdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static quantitymeasurementtdd.Unit.CELSIUS;
import static quantitymeasurementtdd.Unit.FAHRENHEIT;

public class TemperatureTest {
    private QuantityMeasurement quantityMeasurement;
    private Quantity firstQuantity, secondQuantity;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void givenFahrenheitAndCelsius_WhenCompared_ShouldReturnTrue() {
        firstQuantity = new Quantity(FAHRENHEIT, 212.00);
        secondQuantity = new Quantity(CELSIUS, 100.00);
        boolean compareTemperature = quantityMeasurement.compare(firstQuantity, secondQuantity);
        Assert.assertThat(compareTemperature, is(true));
    }
}
