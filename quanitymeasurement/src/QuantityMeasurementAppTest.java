import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    @Test
    void testEquality() {
        assertTrue(new QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityLength(12.0, LengthUnit.INCH)));
    }

    @Test
    void testConversion() {
        assertEquals(12.0,
                new QuantityLength(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCH).getValue(),
                EPS);
    }

    @Test
    void testAddition() {
        assertEquals(2.0,
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCH))
                        .getValue(),
                EPS);
    }

    @Test
    void testAddition_TargetUnit() {
        assertEquals(24.0,
                QuantityLength.add(
                        new QuantityLength(1.0, LengthUnit.FEET),
                        new QuantityLength(12.0, LengthUnit.INCH),
                        LengthUnit.INCH).getValue(),
                EPS);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        });
    }
}