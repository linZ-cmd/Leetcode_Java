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
        char[] array = word.toCharArray();
        dfs(array, res, new StringBuilder(), 0, 0);
        return res;
    }

    public void dfs(char[] word, List<String> res, StringBuilder curWord, int index, int curNum) {
        int length = curWord.length();
        if (index == word.length) {
            if (curNum!=0) curWord.append(Integer.toString(curNum));
            res.add(curWord.toString());
            curWord.setLength(length);
            return;
        }
        dfs(word, res, curWord, index+1, curNum+1);
        if (curNum!=0) curWord.append(Integer.toString(curNum));
        dfs(word, res, curWord.append(word[index]), index+1, 0);
        curWord.setLength(length);
    }
}

