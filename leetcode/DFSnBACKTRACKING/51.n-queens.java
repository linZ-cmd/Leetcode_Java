/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (40.63%)
 * Likes:    1080
 * Dislikes: 47
 * Total Accepted:    152.5K
 * Total Submissions: 374.8K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, n, 0, new int[n]);
        return res;
    }

    public void dfs (List<List<String>> res, int n, int row, int[] sol) {
        if (row == n) {
            List<String> solList = arrayToList(sol);
            res.add(new ArrayList<String>(solList));
            return;
        }

        for (int i=0; i<n; i++) {
            boolean hasQueen = true;
            for (int j=0; j<row; j++) {
                if (sol[j] == i || Math.abs(j-row) == Math.abs(sol[j]-i)) {
                    hasQueen = false;
                    break;
                }
            }
            if (hasQueen) {
                sol[row] = i;
                dfs(res, n, row+1, sol);
            }
        }
    }

    public List<String> arrayToList (int[] arr) {
        List<String> res = new ArrayList<>();
        int n = arr.length;
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            int target = arr[i];
            for (int j=0; j<n; j++) {
                if (j != target) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}

