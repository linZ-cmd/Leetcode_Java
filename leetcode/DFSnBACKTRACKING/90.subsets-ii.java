import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (43.23%)
 * Likes:    1000
 * Dislikes: 50
 * Total Accepted:    216.2K
 * Total Submissions: 500K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> subset, int index) {
        res.add(new ArrayList<>(subset));

                
        for (int i=index; i<nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, res, subset, i+1);
            subset.remove(subset.size()-1);
            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        }
    }
}

