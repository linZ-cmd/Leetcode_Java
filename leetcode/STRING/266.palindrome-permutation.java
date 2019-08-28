import java.util.Set;

/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 *
 * https://leetcode.com/problems/palindrome-permutation/description/
 *
 * algorithms
 * Easy (60.38%)
 * Likes:    221
 * Dislikes: 42
 * Total Accepted:    70.3K
 * Total Submissions: 116.3K
 * Testcase Example:  '"code"'
 *
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "code"
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: "aab"
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: "carerac"
 * Output: true
 * 
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet();
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            Character cha = s.charAt(i);
            if (set.contains(cha)) {
                set.remove(cha);
                count --;
            } else {
                set.add(cha);
                count++;
            }
        }
        return count <2;
    }
}
// class Solution {
//     public boolean canPermutePalindrome(String s) {
//       int[] map = new int[256];
//       for(Character c: s.toCharArray()) {
//         map[c] ++;
//       }
//       int count = 0;
//       for(int i=0; i<map.length; i++) {
//         if (count >1) return false;
//         if (map[i]%2 == 0) continue;
//         else {count++;}
//       }
//       return true;
//     }
// }

