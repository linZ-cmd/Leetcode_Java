/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (42.50%)
 * Likes:    2448
 * Dislikes: 327
 * Total Accepted:    427.1K
 * Total Submissions: 1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(res, digits, new StringBuilder(), 0);
        return res;
    }

    public void dfs(List<String> res, String digits, StringBuilder sb, int digitIndex) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i=digitIndex; i<digits.length(); i++) {
            String charsStr = helper(digits.charAt(i));
            for (int j=0; j<charsStr.length(); j++) {
                int curLength = sb.length();
                sb.append(charsStr.charAt(j));
                dfs(res, digits, sb, i+1);
                sb.setLength(curLength);
            }
        }
    }

    public String helper(char cha) {
        if (cha == '2') {
            return "abc";
        }
        if (cha == '3') {
            return "def";
        }
        if (cha == '4') {
            return "ghi";
        }
        if (cha == '5') {
            return "jkl";
        }
        if (cha == '6') {
            return "mno";
        }
        if (cha == '7') {
            return "pqrs";
        }
        if (cha == '8') {
            return "tuv";
        }
        if (cha == '9') {
            return "wxyz";
        }
        return "";
    }
}

