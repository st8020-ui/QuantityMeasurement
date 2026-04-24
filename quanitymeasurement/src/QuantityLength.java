public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    // Getter (IMPORTANT for tests)
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to base (feet)
    private double toFeet() {
        return unit.toFeet(value);
    }

    // ✅ UC5: convert to another unit
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double feet = this.toFeet();
        double converted = targetUnit.fromFeet(feet);

        return new QuantityLength(converted, targetUnit);
    }

    // ✅ UC6: add (result in same unit as THIS object)
    public QuantityLength add(QuantityLength other) {
        return add(this, other, this.unit);
    }

    // ✅ UC7: add with TARGET UNIT
    public static QuantityLength add(
            QuantityLength a,
            QuantityLength b,
            LengthUnit targetUnit) {

        if (a == null || b == null)
            throw new IllegalArgumentException("Operands cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumFeet = a.toFeet() + b.toFeet();
        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    // Equality (UC3)
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toFeet());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}