public enum LengthUnit { FEET(1.0),

    INCH(1.0 / 12.0),          // 1 inch = 1/12 feet

    YARDS(3.0),                // 1 yard = 3 feet

    CENTIMETER(0.393701 / 12.0); // 1 cm = 0.393701 inch → convert to feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }

}
