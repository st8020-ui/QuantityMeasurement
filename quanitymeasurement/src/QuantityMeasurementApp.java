public class QuantityMeasurementApp {
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {

            // Same reference check (Reflexive)
            if (this == obj) return true;

            // Null or different class check
            if (obj == null || getClass() != obj.getClass()) return false;

            // Type casting
            Feet other = (Feet) obj;

            // Compare using Double.compare
            return Double.compare(this.value, other.value) == 0;
        }

        // (Optional but recommended when overriding equals)
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to test
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        boolean result = f1.equals(f2);

        System.out.println("Equal (" + result + ")");
    }
}
    // Inner class Feet

