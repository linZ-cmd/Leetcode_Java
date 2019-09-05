/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (42.06%)
 * Likes:    1045
 * Dislikes: 41
 * Total Accepted:    175.4K
 * Total Submissions: 416.4K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j<=2 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    dp[j][i] = true;
                }
            }
        }
        dfs(res, s, new ArrayList<String>(), dp, 0);
        return res;
    }

    public void dfs(List<List<String>> res, String s, ArrayList<String> path, boolean[][] dp, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(path));
        }

        for (int i=index;i<s.length();i++) {
            if (dp[i][index]) {
                String substr = s.substring(index, i+1);
                path.add(substr);
                dfs(res, s, path, dp, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

