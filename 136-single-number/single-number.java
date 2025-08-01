public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 1};
        System.out.println(sol.singleNumber(nums));  // Output: 1
    }
}
