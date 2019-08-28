/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * algorithms
 * Medium (38.65%)
 * Likes:    302
 * Dislikes: 83
 * Total Accepted:    69.6K
 * Total Submissions: 179.3K
 * Testcase Example:  '["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]'
 *
 * Given an input string , reverse the string word by word. 
 * 
 * Example:
 * 
 * 
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * 
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 * 
 */
class Solution {
    public void reverseWords(char[] s) {
        int index = 0;
        int wordStart = 0;
        while (index < s.length) {
            while(index<s.length && s[index]!=' ') index++;
            reverse(s, wordStart, index-1);
            // wordStart = index+1;
            // index = wordStart;
            index ++;
            wordStart = index;
        }
        reverse (s, 0, s.length-1);
    }

    public void reverse(char[] s, int l, int r) {
        while (l<r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}

