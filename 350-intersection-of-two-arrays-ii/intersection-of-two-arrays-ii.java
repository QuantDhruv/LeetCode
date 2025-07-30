import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Map to store frequency of elements in nums1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // List to collect results
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                resultList.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // decrease count
            }
        }

        // Convert List to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    // Optional main method for testing locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = sol.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]
    }
}
