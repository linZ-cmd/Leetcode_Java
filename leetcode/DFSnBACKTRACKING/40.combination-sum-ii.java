import java.util.ArrayList;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (42.84%)
 * Likes:    977
 * Dislikes: 50
 * Total Accepted:    239.6K
 * Total Submissions: 559.1K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    public void dfs(int[] cand, int target, List<List<Integer>> res, ArrayList<Integer> path, int index, int sum) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=index; i<cand.length; i++) {
            path.add(cand[i]);
            sum += cand[i];
            dfs(cand, target, res, path, i+1, sum);
            path.remove(path.size()-1);
            sum -= cand[i];
            while (i<cand.length-1 && cand[i] == cand[i+1]) i++;
        }
    }
}

