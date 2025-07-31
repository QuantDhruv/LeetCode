import java.util.*;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> current = new HashSet<>();
            current.add(num);

            for (int val : prev) {
                current.add(val | num);
            }

            result.addAll(current);
            prev = current;
        }

        return result.size();
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.subarrayBitwiseORs(new int[]{0}));        // Output: 1
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 1, 2}));  // Output: 3
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 2, 4}));  // Output: 6
    }
}
