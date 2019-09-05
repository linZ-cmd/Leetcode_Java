/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (40.04%)
 * Likes:    1105
 * Dislikes: 211
 * Total Accepted:    330.1K
 * Total Submissions: 820.6K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(i>=0 || j>=0 || carry>0) {
            int digitA = i<0 ? 0 : a.charAt(i--) - '0';
            int digitB = j<0 ? 0 : b.charAt(j--) - '0';
            res.append((digitA+digitB+carry)%2);
            carry = (digitA+digitB+carry)/2; 
        }

        return res.reverse().toString();
    }
}

