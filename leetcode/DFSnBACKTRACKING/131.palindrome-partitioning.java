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
                    dp[j][i] = true;
                    dp[i][j] = true;
                }
            }
        }
        dfs(res, s, dp, new ArrayList<String>(), 0);
        return res;
    }

    public void dfs(List<List<String>> res, String s, boolean[][] dp, ArrayList<String> path, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if (dp[index][i]) {
                String subStr = s.substring(index, i+1);
                path.add(subStr);
                dfs(res, s, dp, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

