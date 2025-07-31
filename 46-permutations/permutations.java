import java.util.*;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // Make a copy of the current path
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path, used, result);

            // Backtrack
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // Optional: Test locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = sol.permute(nums);
        
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
