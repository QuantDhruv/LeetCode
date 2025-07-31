import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Important step to handle duplicates
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Skip duplicates: only allow first occurrence unless the previous duplicate was used
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, result);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // Optional: Test locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = sol.permuteUnique(nums);

        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
