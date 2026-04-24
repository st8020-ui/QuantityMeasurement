public class QuantityMeasurementApp {
    public static void main(String[] args) {

        System.out.println(
                new QuantityLength(1.0, LengthUnit.YARDS)
                        .equals(new QuantityLength(3.0, LengthUnit.FEET))
        ); // true

        System.out.println(
                new QuantityLength(1.0, LengthUnit.YARDS)
                        .equals(new QuantityLength(36.0, LengthUnit.INCH))
        ); // true

        System.out.println(
                new QuantityLength(1.0, LengthUnit.CENTIMETER)
                        .equals(new QuantityLength(0.393701, LengthUnit.INCH))
        ); // true
    }
}
    // Inner class Feet

