public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 🔹 Create objects
        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength c1 = new QuantityLength(2.54, LengthUnit.CENTIMETER);

        // 🔹 UC3/UC4: Equality
        System.out.println("Equality (1 ft == 12 inch): " + f1.equals(i1));

        // 🔹 UC5: Conversion
        System.out.println("1 ft in inches: " +
                f1.convertTo(LengthUnit.INCH));

        System.out.println("1 yard in feet: " +
                y1.convertTo(LengthUnit.FEET));

        // 🔹 UC6: Addition (result in first unit)
        System.out.println("1 ft + 12 inch (in feet): " +
                f1.add(i1));

        System.out.println("12 inch + 1 ft (in inches): " +
                i1.add(f1));

        // 🔹 UC7: Addition with target unit
        System.out.println("1 ft + 12 inch (in inches): " +
                QuantityLength.add(f1, i1, LengthUnit.INCH));

        System.out.println("1 ft + 12 inch (in yards): " +
                QuantityLength.add(f1, i1, LengthUnit.YARDS));

        // 🔹 Extra: centimeter example
        System.out.println("2.54 cm in inches: " +
                c1.convertTo(LengthUnit.INCH));

        System.out.println("2.54 cm + 1 inch (in cm): " +
                QuantityLength.add(c1, i1, LengthUnit.CENTIMETER));
    }
}