/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.95%)
 * Likes:    1583
 * Dislikes: 1446
 * Total Accepted:    532.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // find the shortest string
        String minStr = strs[0];
        for (String str: strs) {
            minStr = str.length()<minStr.length() ? str : minStr;
        }
        //if does not match, cut length by 1
        for (String str:strs) {
            while (str.indexOf(minStr)!= 0) {
                minStr = minStr.substring(0, minStr.length()-1);
            }
        }
        return minStr;
    }
}

