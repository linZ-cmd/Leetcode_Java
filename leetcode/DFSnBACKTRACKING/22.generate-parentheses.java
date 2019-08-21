/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.30%)
 * Likes:    3100
 * Dislikes: 192
 * Total Accepted:    374.3K
 * Total Submissions: 663.9K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(res, n, new StringBuilder(), 0, 0);
        System.out.println(res);
        return res;
    }

    public void dfs(List<String> res, int n, StringBuilder sb, int left, int right) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        int 
        curLength = sb.length();
        if (left < n) {
            sb.append('(');
            dfs(res, n, sb, left+1, right);
            sb.setLength(curLength);
        }
        if (right < left) {
            sb.append(')');
            dfs(res, n, sb, left, right+1);
            sb.setLength(curLength);
        }
    }
}

