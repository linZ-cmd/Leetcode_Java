/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (17.42%)
 * Likes:    634
 * Dislikes: 2378
 * Total Accepted:    303.2K
 * Total Submissions: 1.7M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
class Solution {
    // public String reverseWords(String s) {
    //     int wordIndex = 0;
    //     int index = 0;
    //     char[] charArr = s.toCharArray();

    //     while (index<s.length()) {
    //         while (index<s.length() && charArr[index] == ' ') index ++;
    //         wordIndex = index;
    //         while (index<s.length() && charArr[index] != ' ') index ++;
    //         reverseWord(charArr, wordIndex, index-1);
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     index = s.length()-1;
    //     while(index>=0) {
    //         while (index>=0 && charArr[index] != ' ') {
    //             sb.append(charArr[index]);
    //             index--;
    //         }
    //         sb.append(' ');
    //         while (index>=0 && charArr[index] == ' ') {
    //             index--;
    //         }
    //     }
    //     return sb.toString().trim();
    // }

    // public void reverseWord(char[] charArr, int begin, int end) {
    //     while (begin < end) {
    //         char temp = charArr[begin];
    //         charArr[begin] = charArr[end];
    //         charArr[end] = temp;
    //         begin ++;
    //         end --;
    //     }
    // }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        while (i>=0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i;
            while (j>=0 && s.charAt(j) != ' ') j--;
            String str = s.substring(j+1, i+1);
            sb.append(str);
            sb.append(' ');
            i = j-1;
        }
        return sb.toString().trim();
    }
}


