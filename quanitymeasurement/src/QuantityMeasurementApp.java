public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength y = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength c = new QuantityLength(2.54, LengthUnit.CENTIMETER);

        // Equality
        System.out.println("1 ft == 12 inch: " + f.equals(i));

        // Conversion
        System.out.println("1 ft in inches: " + f.convertTo(LengthUnit.INCH));
        System.out.println("1 yard in feet: " + y.convertTo(LengthUnit.FEET));

        // Addition (UC6)
        System.out.println("1 ft + 12 inch (feet): " + f.add(i));
        System.out.println("12 inch + 1 ft (inch): " + i.add(f));

        // Addition with target unit (UC7)
        System.out.println("1 ft + 12 inch (inches): " +
                QuantityLength.add(f, i, LengthUnit.INCH));

        System.out.println("1 ft + 12 inch (yards): " +
                QuantityLength.add(f, i, LengthUnit.YARDS));

        // CM example
        System.out.println("2.54 cm in inch: " +
                c.convertTo(LengthUnit.INCH));

        System.out.println("2.54 cm + 1 inch (cm): " +
                QuantityLength.add(c, i, LengthUnit.CENTIMETER));
    }
}