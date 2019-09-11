/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.28%)
 * Likes:    429
 * Dislikes: 1777
 * Total Accepted:    293.5K
 * Total Submissions: 909.1K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */
class Solution {
    // public int lengthOfLastWord(String s) {
    //     s = s.trim();
    //     int lastIndex = s.lastIndexOf(' ') + 1;
    //     return s.length() - lastIndex;        
    // }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ' && count == 0) continue;
            if (s.charAt(i) == ' ') {
                return count;
            } else count++;
        }
        return count;
    }
}

