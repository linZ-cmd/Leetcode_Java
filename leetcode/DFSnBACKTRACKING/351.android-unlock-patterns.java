/*
 * @lc app=leetcode id=351 lang=java
 *
 * [351] Android Unlock Patterns
 *
 * https://leetcode.com/problems/android-unlock-patterns/description/
 *
 * algorithms
 * Medium (46.46%)
 * Likes:    282
 * Dislikes: 324
 * Total Accepted:    31.6K
 * Total Submissions: 68K
 * Testcase Example:  '1\n1'
 *
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤
 * n ≤ 9, count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * 
 * 
 * 
 * Rules for a valid pattern:
 * 
 * 
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through
 * any other keys, the other keys must have previously selected in the pattern.
 * No jumps through non selected key is allowed.
 * The order of keys used matters.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Explanation:
 * 
 * 
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * 
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * 
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * 
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected
 * in the pattern
 * 
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected
 * in the pattern.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * Input: m = 1, n = 1
 * Output: 9
 * 
 * 
 * 
 */
class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] passThrough = new int[10][10];
        boolean[] visited = new boolean[10];
        passThrough[1][3] = passThrough[3][1] = 2;
        passThrough[1][7] = passThrough[7][1] = 4;
        passThrough[1][9] = passThrough[9][1] = 5;
        passThrough[2][8] = passThrough[8][2] = 5;
        passThrough[3][7] = passThrough[7][3] = 5;
        passThrough[4][6] = passThrough[6][4] = 5;
        passThrough[7][9] = passThrough[9][7] = 8;
        passThrough[3][9] = passThrough[9][3] = 6;
        return 4*dfs(m,n,passThrough,1,1,visited)
        + 4*dfs(m,n,passThrough,2,1,visited)
        + dfs(m,n,passThrough,5,1,visited);
    }

    public int dfs(int m, int n, int[][] passThrough, int num, int leng, boolean[] visited) {
        int res = 0;
        if (leng >= m) res++;
        if (leng >= n) return res;
        visited[num] = true;
        for (int i=1;i<=9;i++){
            if (!visited[i] && (passThrough[num][i] == 0 || visited[passThrough[num][i]])) {
                res += dfs(m,n,passThrough,i,leng+1,visited);
            }
        }
        visited[num] = false;
        return res;
    }
}

