import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class for arithmetic sequences.
 *
 * Formulas:
 *   nth term:     term = a1 + (n - 1) * d
 *   sequence sum: sum  = n/2 * (a1 + nth term)
 */
public final class ArithmeticSequence {

    // Default number of decimals (change here if needed)
    private static final int DEFAULT_DECIMALS = 2;

    private ArithmeticSequence() {
        // Prevent instantiation
    }

    /**
     * Calculates the n-th term of an arithmetic sequence.
     *
     * @param first starting value (a1)
     * @param diff  common difference (d)
     * @param n     position (must be >= 1)
     * @return value of the n-th term, rounded to DEFAULT_DECIMALS
     * @throws IllegalArgumentException if n < 1
     */
    public static double nthTerm(double first, double diff, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        }
        double result = first + (n - 1) * diff;
        return round(result, DEFAULT_DECIMALS);
    }

    /**
     * Calculates the sum of the sequence up to the n-th term.
     *
     * @param first starting value (a1)
     * @param diff  common difference (d)
     * @param n     number of terms (must be >= 1)
     * @return sum of the sequence up to n, rounded to DEFAULT_DECIMALS
     * @throws IllegalArgumentException if n < 1
     */
    public static double sequenceSum(double first, double diff, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        }
        double last = nthTerm(first, diff, n);
        double result = (n * (first + last)) / 2.0;
        return round(result, DEFAULT_DECIMALS);
    }

    /**
     * Rounds a value to the given number of decimals.
     * Change DEFAULT_DECIMALS to adjust global precision.
     */
    private static double round(double value, int decimals) {
        return new BigDecimal(value)
                .setScale(decimals, RoundingMode.HALF_UP)
                .doubleValue();
    }
}

