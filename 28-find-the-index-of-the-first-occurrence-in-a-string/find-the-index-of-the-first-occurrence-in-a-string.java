public class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Loop through each possible starting index
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // Found the first occurrence
            }
        }

        return -1; // Not found
    }

    // // For testing
    // public static void main(String[] args) {
    //     Solution sol = new Solution();

    //     System.out.println(sol.strStr("sadbutsad", "sad"));     // Output: 0
    //     System.out.println(sol.strStr("leetcode", "leeto"));    // Output: -1
    //     System.out.println(sol.strStr("hello", "ll"));          // Output: 2
    // }
}
