import java.util.ArrayList;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (56.62%)
 * Likes:    2259
 * Dislikes: 68
 * Total Accepted:    414.3K
 * Total Submissions: 731.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (nums == null || nums.length == 0) return res;
        //backtracking
        dfs(nums, res, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> path) {
        //ending condition
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (path.contains(nums[i])) continue;
            //add
            path.add(nums[i]);
            //dfs
            dfs(nums, res, path);
            //remove
            path.remove(path.size()-1);
        }
    }
}

