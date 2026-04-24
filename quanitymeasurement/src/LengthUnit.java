public enum LengthUnit {

    FEET(1.0),

    INCH(1.0 / 12.0),          // 1 inch = 1/12 feet

    YARDS(3.0),                // 1 yard = 3 feet

    CENTIMETER(0.393701 / 12.0); // 1 cm = 0.393701 inch → in feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    // Convert ANY unit → feet (base unit)
    public double toFeet(double value) {
        return value * toFeetFactor;
    }

    // Convert feet → ANY unit
    public double fromFeet(double feetValue) {
        return feetValue / toFeetFactor;
    }
}