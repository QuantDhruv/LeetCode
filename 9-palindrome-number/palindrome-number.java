public class Solution {
    public boolean isPalindrome(int x) {
        // If x is negative or ends with 0 (but is not 0), it's not a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x = x / 10;
        }

        // Check for both even and odd length numbers
        return x == reversed || x == reversed / 10;
    }
}
