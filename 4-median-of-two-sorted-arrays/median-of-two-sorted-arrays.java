public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make sure nums1 is the smaller array to keep binary search efficient
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int start = 0;
        int end = m;

        while (start <= end) {
            int part1 = (start + end) / 2;
            int part2 = (m + n + 1) / 2 - part1;

            // Handle edge cases using Integer.MIN_VALUE / MAX_VALUE
            int maxLeft1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int minRight1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];

            int maxLeft2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minRight2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            // Check if we have found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Total length is even
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(maxLeft1, maxLeft2);
                    int minRight = Math.min(minRight1, minRight2);
                    return (maxLeft + minRight) / 2.0;
                } else {
                    // Total length is odd
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move to left in nums1
                end = part1 - 1;
            } else {
                // Move to right in nums1
                start = part1 + 1;
            }
        }

        return 0.0; // This line won't be reached if input is valid
    }
}
