/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.68%)
 * Likes:    1563
 * Dislikes: 1803
 * Total Accepted:    282K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int leng = s.length();
        int[] dp = new int[leng+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=1; i<leng; i++) {
            int cur = s.charAt(i) - '0';
            int prev = s.charAt(i-1) - '0';
            int num = prev*10+cur;
            if (cur == 0) {
                if (prev == 0) return 0;
                if (num <= 26) {
                    dp[i+1] = dp[i-1];
                } else return 0;
            } else {
                if (prev == 0) dp[i+1] = dp[i];
                else {
                    if (prev != 0 && num<=26) dp[i+1]=dp[i-1]+dp[i];
                    else dp[i+1] = dp[i];
                }
            }
        }
        return dp[leng];
    }
}

