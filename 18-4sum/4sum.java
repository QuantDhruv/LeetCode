import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to handle duplicates and use two pointers
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Fix the first two numbers using two loops
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Use two pointers for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Calculate the sum of the four numbers
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers
                        left++;
                        right--;
                    } else if (sum < target) {
                        // If sum is too small, move left pointer to increase it
                        left++;
                    } else {
                        // If sum is too big, move right pointer to decrease it
                        right--;
                    }
                }
            }
        }

        // Return the list of all unique quadruplets
        return result;
    }
}
