public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = this.toBase();
        double converted = targetUnit.convertFromBaseUnit(base);

        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(this, other, this.unit);
    }

    public static QuantityWeight add(
            QuantityWeight a,
            QuantityWeight b,
            WeightUnit targetUnit) {

        if (a == null || b == null)
            throw new IllegalArgumentException("Operands cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sum = a.toBase() + b.toBase();
        double result = targetUnit.convertFromBaseUnit(sum);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}