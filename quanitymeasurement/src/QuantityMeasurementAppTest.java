import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(2.0, LengthUnit.FEET));

        assertEquals(3.0, result.convertTo(LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCH));

        assertEquals(2.0, result.convertTo(LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength result =
                new QuantityLength(12.0, LengthUnit.INCH)
                        .add(new QuantityLength(1.0, LengthUnit.FEET));

        assertEquals(24.0, result.convertTo(LengthUnit.INCH).value, EPS);
    }

    @Test
    void testAddition_YardPlusFeet() {
        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.YARDS)
                        .add(new QuantityLength(3.0, LengthUnit.FEET));

        assertEquals(2.0, result.convertTo(LengthUnit.YARDS).value, EPS);
    }

    @Test
    void testAddition_CentimeterPlusInch() {
        QuantityLength result =
                new QuantityLength(2.54, LengthUnit.CENTIMETER)
                        .add(new QuantityLength(1.0, LengthUnit.INCH));

        assertEquals(5.08,
                result.convertTo(LengthUnit.CENTIMETER).value,
                1e-2);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        assertEquals(a.add(b).toFeet(), b.add(a).toFeet(), EPS);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength result =
                new QuantityLength(5.0, LengthUnit.FEET)
                        .add(new QuantityLength(0.0, LengthUnit.INCH));

        assertEquals(5.0, result.convertTo(LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength result =
                new QuantityLength(5.0, LengthUnit.FEET)
                        .add(new QuantityLength(-2.0, LengthUnit.FEET));

        assertEquals(3.0, result.convertTo(LengthUnit.FEET).value, EPS);
    }

    @Test
    void testAddition_NullOperand() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, LengthUnit.FEET).add(null);
        });
    }
}