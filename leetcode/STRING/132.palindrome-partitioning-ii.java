/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (27.99%)
 * Likes:    674
 * Dislikes: 24
 * Total Accepted:    109.2K
 * Total Submissions: 388.4K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using
 * 1 cut.
 * 
 * 
 */
class Solution {
    public int minCut(String s) {
        //use length variable and s.toCharArray will decrease time complexity
        int length = s.length();
        char[] sArr = s.toCharArray();
        boolean[][] isPalindrome = new boolean[length][length];
        int[] minCut = new int[length];

        for (int i=0; i<length; i++) {
            minCut[i] = i;
            for (int j=0;j<=i;j++) {
                if (sArr[i]==sArr[j] && (i-j<2 || isPalindrome[i-1][j+1])) {
                    isPalindrome[i][j] = true;
                    isPalindrome[j][i] = true;

                    if (j == 0) {
                        minCut[i] = 0;
                    }else {
                        minCut[i] = Math.min(minCut[i], minCut[j-1]+1);
                    }
                }
            }
        }
        return minCut[length-1];
    }
}

