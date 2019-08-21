import java.util.ArrayList;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (49.02%)
 * Likes:    868
 * Dislikes: 50
 * Total Accepted:    218.1K
 * Total Submissions: 444.8K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, res, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int n, int k, List<List<Integer>> res, int index, ArrayList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=index; i<n; i++) {
            path.add(i+1);
            dfs(n,k,res,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

