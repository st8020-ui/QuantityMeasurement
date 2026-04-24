public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(f1.add(f2)); // 2.0 FEET

        QuantityLength i1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength i2 = new QuantityLength(1.0, LengthUnit.FEET);

        System.out.println(i1.add(i2)); // 24.0 INCH

        QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength y2 = new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println(y1.add(y2)); // 2.0 YARDS
    }
}