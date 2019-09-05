import java.util.Map;

/*
 * @lc app=leetcode id=267 lang=java
 *
 * [267] Palindrome Permutation II
 *
 * https://leetcode.com/problems/palindrome-permutation-ii/description/
 *
 * algorithms
 * Medium (34.15%)
 * Likes:    281
 * Dislikes: 38
 * Total Accepted:    28.5K
 * Total Submissions: 83.3K
 * Testcase Example:  '"aabb"'
 *
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * Example 1:
 * 
 * 
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * 
 * Example 2:
 * 
 * 
 * Input: "abc"
 * Output: []
 * 
 */
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (char c: sArr) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c)+1);
        }
        int count = 0;
        char center = 'a';
        for (char c: map.keySet()) {
            int num = map.get(c);
            if (num%2!=0) {
                count++;
                center = c;
            }
            if (count>1) return res;
        }
        char[] tempArray = new char[s.length()];
        if (count>0) {
            tempArray[s.length()/2] = center;
            map.put(center, map.get(center)-1);
            dfs(map, res, tempArray, s.length()/2-1,s.length()/2+1);
        }else {
            dfs(map, res, tempArray, s.length()/2-1,s.length()/2);
        }
        return res;
    }
// have explored other solutions in leetcode, and an optiomal solution is to use stringbuilder instead of char array
    public void dfs(Map<Character, Integer> map, List<String> res, char[] temp, int left, int right) {
        if (left < 0 ) {
            res.add(new String(temp));
            return;
        }
        for (char c:map.keySet()){
            int num = map.get(c);
            if (num!=0) {
                map.put(c, map.get(c)-2);
                temp[left] = c;
                temp[right] = c;
                dfs(map, res, temp, left-1, right+1);
                map.put(c, map.get(c)+2);
                temp[left] = '.';
                temp[right] = '.';
            }
        }
    }
}

