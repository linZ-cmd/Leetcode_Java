/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (32.62%)
 * Likes:    1028
 * Dislikes: 1484
 * Total Accepted:    487.5K
 * Total Submissions: 1.5M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()) return -1; 
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int p = 0; //the number of characters matched
        for (int i=0; i<haystack.length(); i++) {
            while (p>0 && haystack.charAt(i)!=needle.charAt(p)) {
                p = next[p-1];
            }
            if (haystack.charAt(i) == needle.charAt(p)) {
                p++;
            }
            if (p == needle.length()) {
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    public int[] getNext(String s) {
        int length = s.length();
        int[] next = new int[length];
        int k = 0; //the number of characters matched
        for (int i=1; i<length; i++) {
            while (k>0 && s.charAt(i)!=s.charAt(k)) {
                k = next[k-1];
            }
            if (s.charAt(i) == s.charAt(k)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}

