/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 *
 * https://leetcode.com/problems/strobogrammatic-number/description/
 *
 * algorithms
 * Easy (42.75%)
 * Likes:    136
 * Dislikes: 326
 * Total Accepted:    57.1K
 * Total Submissions: 133.3K
 * Testcase Example:  '"69"'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input:  "69"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  "88"
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input:  "962"
 * Output: false
 * 
 */
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
       
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!map.containsKey(num.charAt(l))) return false;
            if (map.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}

