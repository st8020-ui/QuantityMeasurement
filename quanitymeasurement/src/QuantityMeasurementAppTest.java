import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    // 🔹 UC7: target = FEET
    @Test
    void testAddition_TargetUnit_Feet() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCH),
                LengthUnit.FEET
        );

        assertEquals(2.0, result.getValue(), EPS);
    }

    // 🔹 target = INCH
    @Test
    void testAddition_TargetUnit_Inches() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCH),
                LengthUnit.INCH
        );

        assertEquals(24.0, result.getValue(), EPS);
    }

    // 🔹 target = YARDS
    @Test
    void testAddition_TargetUnit_Yards() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCH),
                LengthUnit.YARDS
        );

        assertEquals(0.667, result.getValue(), EPS);
    }

    // 🔹 target = CENTIMETER
    @Test
    void testAddition_TargetUnit_Centimeter() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(2.54, LengthUnit.CENTIMETER),
                new QuantityLength(1.0, LengthUnit.INCH),
                LengthUnit.CENTIMETER
        );

        assertEquals(5.08, result.getValue(), EPS);
    }

    // 🔹 Commutativity
    @Test
    void testAddition_Commutativity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength r1 = QuantityLength.add(a, b, LengthUnit.YARDS);
        QuantityLength r2 = QuantityLength.add(b, a, LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), EPS);
    }

    // 🔹 Zero case
    @Test
    void testAddition_WithZero() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(0.0, LengthUnit.INCH),
                LengthUnit.FEET
        );

        assertEquals(5.0, result.getValue(), EPS);
    }

    // 🔹 Negative values
    @Test
    void testAddition_NegativeValues() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(-2.0, LengthUnit.FEET),
                LengthUnit.INCH
        );

        assertEquals(36.0, result.getValue(), EPS);
    }

    // 🔹 Null target unit
    @Test
    void testAddition_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(
                    new QuantityLength(1.0, LengthUnit.FEET),
                    new QuantityLength(12.0, LengthUnit.INCH),
                    null
            );
        });
    }

    // 🔹 Null operand
    @Test
    void testAddition_NullOperand() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(
                    null,
                    new QuantityLength(12.0, LengthUnit.INCH),
                    LengthUnit.FEET
            );
        });
    }
}