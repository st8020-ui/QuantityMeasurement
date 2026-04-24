import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET),
                EPS);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testConversion_CentimeterToInch() {
        assertEquals(1.0,
                QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH),
                1e-3); // tolerance
    }

    @Test
    void testConversion_RoundTrip() {
        double value = 5.0;
        double result = QuantityLength.convert(
                QuantityLength.convert(value, LengthUnit.FEET, LengthUnit.INCH),
                LengthUnit.INCH,
                LengthUnit.FEET
        );

        assertEquals(value, result, EPS);
    }

    @Test
    void testConversion_Zero() {
        assertEquals(0.0,
                QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testConversion_Negative() {
        assertEquals(-12.0,
                QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH),
                EPS);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, null, LengthUnit.FEET);
        });
    }

    @Test
    void testConversion_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);
        });
    }
}