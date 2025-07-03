import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Step 1: Sort the array
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left and right to the next different numbers
                    while (left < right && nums[left] == nums[left + 1]) left++; 
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } else if (total < 0) {
                    left++;  // We need a larger number
                } else {
                    right--; // We need a smaller number
                }
            }
        }

        return result;
    }
}
