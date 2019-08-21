import java.util.ArrayList;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (52.49%)
 * Likes:    655
 * Dislikes: 32
 * Total Accepted:    130K
 * Total Submissions: 247.6K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, k, n, new ArrayList<Integer>(), 0, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, int count, int target, ArrayList<Integer> path, int sum, int n) {
        if (count == 0 && target == sum) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (count < 0 || sum > target) return;
        for (int i=n; i<=9; i++) {
            path.add(i);
            dfs(res, count-1, target, path, sum+i, i+1);
            path.remove(path.size()-1);
        }
    }
}

