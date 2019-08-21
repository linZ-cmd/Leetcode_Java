/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (53.08%)
 * Likes:    313
 * Dislikes: 123
 * Total Accepted:    105.8K
 * Total Submissions: 199.1K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    public int totalNQueens(int n) {
        int[] pos = new int[n+1];
        dfs(n, pos, 0);
        return pos[n];
    }

    public void dfs(int n, int[] pos, int row) {
        if (row == n) {
            pos[n] ++;
            return;
        }

        for (int i=0; i<n; i++) {
            boolean hasQueen = true;
            for (int j=0; j<row; j++) {
                if (pos[j] == i || Math.abs(pos[j]-i) == Math.abs(row-j)) {
                    hasQueen = false;
                    break;
                }
            }
            if (hasQueen) {
                pos[row] = i;
                dfs(n, pos, row+1);
            }
        }
    }
}

