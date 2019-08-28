/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.71%)
 * Likes:    4159
 * Dislikes: 385
 * Total Accepted:    632.1K
 * Total Submissions: 2.3M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    int maxLength = 0;
    int left = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        for (int i=0; i<s.length()-1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(left, left+maxLength);
    }

    public void extendPalindrome(String s, int l, int r) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (maxLength < r-l-1) {
            left = l+1;
            maxLength = r-l-1;
        }
    }
}

