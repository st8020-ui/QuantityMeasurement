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

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to base unit (feet)
    private double toFeet() {
        return unit.convertToBaseUnit(value);
    }

    // ✅ UC5: Conversion
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double feet = this.toFeet();
        double converted = targetUnit.convertFromBaseUnit(feet);

        return new QuantityLength(converted, targetUnit);
    }

    // ✅ UC6: Add (same unit as this)
    public QuantityLength add(QuantityLength other) {
        return add(this, other, this.unit);
    }

    // ✅ UC7: Add with target unit
    public static QuantityLength add(
            QuantityLength a,
            QuantityLength b,
            LengthUnit targetUnit) {

        if (a == null || b == null)
            throw new IllegalArgumentException("Operands cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumFeet = a.toFeet() + b.toFeet();
        double result = targetUnit.convertFromBaseUnit(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    // ✅ UC3: Equality
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