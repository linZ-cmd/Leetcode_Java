/*
 * @lc app=leetcode id=320 lang=java
 *
 * [320] Generalized Abbreviation
 *
 * https://leetcode.com/problems/generalized-abbreviation/description/
 *
 * algorithms
 * Medium (49.25%)
 * Likes:    301
 * Dislikes: 32
 * Total Accepted:    39.2K
 * Total Submissions: 79.6K
 * Testcase Example:  '"word"'
 *
 * Write a function to generate the generalized abbreviations of a word. 
 * 
 * Note: The order of the output does not matter.
 * 
 * Example:
 * 
 * 
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        char[] newWord = word.toCharArray();
        dfs(newWord, res, new StringBuilder(), 0, 0);
        return res;
    }
    public void dfs(char[] word, List<String> res, StringBuilder sb, int index, int subLength) {
        int length = sb.length();
        if (index == word.length) {
            if (subLength != 0) sb.append(subLength);
            res.add(sb.toString());
            sb.setLength(length);
            return;
        }
        else {
            dfs(word, res, sb, index+1, subLength+1);
            if (subLength!=0) sb.append(subLength);
            sb.append(word[index]);
            dfs(word, res, sb, index+1,0);
            sb.setLength(length);
        }
    }
}

