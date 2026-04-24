import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    @Test
    void testLengthEquality() {
        assertTrue(new QuantityLength(1.0, LengthUnit.FEET)
                .equals(new QuantityLength(12.0, LengthUnit.INCH)));
    }

    @Test
    void testWeightEquality() {
        assertTrue(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));
    }

    @Test
    void testWeightConversion() {
        assertEquals(2.20462,
                new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.POUND).getValue(),
                EPS);
    }
}