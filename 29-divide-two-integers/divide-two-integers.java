public class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: Overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Get sign of result (true if negative)
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        // Keep subtracting divisor from dividend
        while (a >= b) {
            long temp = b;
            int count = 1;

            // Double the divisor until it's too big
            while (a >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            a -= temp;        // Subtract the biggest chunk
            result += count;  // Add how many times we subtracted
        }

        return isNegative ? -result : result;
    }
}
