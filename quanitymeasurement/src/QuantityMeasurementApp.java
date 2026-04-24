public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = QuantityLength.convert(value, from, to);
        System.out.println("Converted: " + result);
    }

    public static void demonstrateLengthConversion(QuantityLength length, LengthUnit to) {
        QuantityLength converted = length.convertTo(to);
        System.out.println("Converted: " + converted);
    }

    public static void demonstrateLengthEquality(QuantityLength q1, QuantityLength q2) {
        System.out.println("Equal: " + q1.equals(q2));
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH); // 12
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET); // 9

        QuantityLength q = new QuantityLength(36.0, LengthUnit.INCH);
        demonstrateLengthConversion(q, LengthUnit.YARDS); // 1

        demonstrateLengthEquality(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCH)
        );
    }
}