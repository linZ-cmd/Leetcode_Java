/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 *
 * https://leetcode.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (27.98%)
 * Likes:    723
 * Dislikes: 87
 * Total Accepted:    79.4K
 * Total Submissions: 282.8K
 * Testcase Example:  '"aacecaaa"'
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * 
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int i=0;
        for (int j=s.length()-1;j>=0;j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == s.length()) return s;
        String res = s.substring(i);
        String rev = new StringBuilder(res).reverse().toString();
        return rev + shortestPalindrome(s.substring(0,i)) + res;
    }
}
