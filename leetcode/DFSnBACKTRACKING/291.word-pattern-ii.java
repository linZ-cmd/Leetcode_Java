import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=291 lang=java
 *
 * [291] Word Pattern II
 *
 * https://leetcode.com/problems/word-pattern-ii/description/
 *
 * algorithms
 * Hard (41.48%)
 * Likes:    283
 * Dislikes: 19
 * Total Accepted:    35.4K
 * Total Submissions: 85.3K
 * Testcase Example:  '"abab"\n"redblueredblue"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * 
 * 
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 */
// class Solution {
//     public boolean wordPatternMatch(String pattern, String str) {
//         return dfs(pattern,str,new HashMap<Character, String>(), new HashSet<String>());
//     }

//     public boolean dfs(String pattern, String str, Map<Character, String> map, Set<String> set) {
//         if (pattern.length()==0) return str.length()==0;
//         char pat = pattern.charAt(0);
//         for (int i=0; i<str.length();i++) {
//             String string = str.substring(0,i+1);
//             if (!map.containsKey(pat) && !set.contains(string)) {
//                 map.put(pat, string);
//                 set.add(string);
//                 if (dfs(pattern.substring(1),str.substring(i+1),map,set)) return true;
//                 map.remove(pat, string);
//                 set.remove(string);
//             }else {
//                 if (map.containsKey(pat) && set.contains(string)) {
//                     if (map.get(pat).equals(string)) {
//                         return dfs(pattern.substring(1),str.substring(i+1),map,set);
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }

public class Solution {
  
    public boolean wordPatternMatch(String pattern, String str) {
      Map<Character, String> map = new HashMap<>();
      Set<String> set = new HashSet<>();
      
      return isMatch(str, 0, pattern, 0, map, set);
    }
    
    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
      // base case
      if (i == str.length() && j == pat.length()) return true;
      if (i == str.length() || j == pat.length()) return false;
      
      // get current pattern character
      char c = pat.charAt(j);
      
      // if the pattern character exists
      if (map.containsKey(c)) {
        String s = map.get(c);
        
        // then check if we can use it to match str[i...i+s.length()]
        if (!str.startsWith(s, i)) {
          return false;
        }
        
        // if it can match, great, continue to match the rest
        return isMatch(str, i + s.length(), pat, j + 1, map, set);
      }
      
      // pattern character does not exist in the map
      for (int k = i; k < str.length(); k++) {
        String p = str.substring(i, k + 1);
  
        if (set.contains(p)) {
          continue;
        }
  
        // create or update it
        map.put(c, p);
        set.add(p);
        
        // continue to match the rest
        if (isMatch(str, k + 1, pat, j + 1, map, set)) {
          return true;
        }
  
        // backtracking
        map.remove(c);
        set.remove(p);
      }
      
      // we've tried our best but still no luck
      return false;
    }
    
  }

