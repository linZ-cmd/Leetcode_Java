import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (54.27%)
 * Likes:    2199
 * Dislikes: 54
 * Total Accepted:    397.7K
 * Total Submissions: 732.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠[3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, res, 0, new ArrayList<Integer>());
        System.out.println(res);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> subset) {
            res.add(new ArrayList<Integer>(subset));

        for (int i=index; i<nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, res, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}

