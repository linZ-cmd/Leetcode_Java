import java.util.ArrayList;
import java.util.Collections;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (49.96%)
 * Likes:    2257
 * Dislikes: 70
 * Total Accepted:    375.6K
 * Total Submissions: 751.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, res, target, new ArrayList<Integer>(), 0, 0);
        System.out.println(res);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, int target, ArrayList<Integer> path, int index, int sum) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, res, target, path, i, sum);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }
}

