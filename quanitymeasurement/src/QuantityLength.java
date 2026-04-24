public class QuantityLength {

    final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    double toFeet() {
        return unit.toFeet(value);
    }

    // 🔥 UC6: Addition (instance method)
    public QuantityLength add(QuantityLength other) {

        if (other == null)
            throw new IllegalArgumentException("Other length cannot be null");

        double sumFeet = this.toFeet() + other.toFeet();

        // Convert result back to this object's unit
        double resultValue = this.unit.fromFeet(sumFeet);

        return new QuantityLength(resultValue, this.unit);
    }

    // 🔥 Optional static version (flexible API)
    public static QuantityLength add(QuantityLength a, QuantityLength b, LengthUnit targetUnit) {

        if (a == null || b == null || targetUnit == null)
            throw new IllegalArgumentException("Invalid input");

        double sumFeet = a.toFeet() + b.toFeet();
        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }


    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        // Step 1: convert current value → feet
        double valueInFeet = this.unit.toFeet(this.value);

        // Step 2: convert feet → target unit
        double convertedValue = targetUnit.fromFeet(valueInFeet);

        return new QuantityLength(convertedValue, targetUnit);
    }
}