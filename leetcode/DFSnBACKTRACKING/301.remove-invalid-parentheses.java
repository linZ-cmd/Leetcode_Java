/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (39.92%)
 * Likes:    1590
 * Dislikes: 70
 * Total Accepted:    138.1K
 * Total Submissions: 345.3K
 * Testcase Example:  '"()())()"'
 *
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Example 1:
 * 
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ")("
 * Output: [""]
 * 
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int open = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') left++;
            if (s.charAt(i)==')') {
                if (left>0) left --;
                else right++;
            }
        }
        dfs(s,res, new StringBuilder(),left,right,open,0,'.');
        return res;
    }

    public void dfs(String s, List<String> res, StringBuilder sb, int left, int right, int open, int index, char lastSkip) {
        if (index==s.length() && left==0 && right==0 && open==0) {
            res.add(sb.toString());
            return;
        }
        if (index==s.length() || left<0 || right<0 || open<0) return;
        int leng = sb.length();
        if (s.charAt(index)=='(') {
            dfs(s,res,sb,left-1,right,open,index+1,'('); //not use (
            sb.append('(');
            if(lastSkip != '(') dfs(s,res,sb,left,right,open+1,index+1,'.'); //use (
        } else if (s.charAt(index)==')') {
            dfs(s,res,sb,left,right-1,open,index+1,')'); //not use)
            sb.append(')');
            if(lastSkip != ')') dfs(s,res,sb,left,right,open-1,index+1,'.'); //use )
        } else {
            dfs(s,res,sb.append(s.charAt(index)),left,right,open,index+1,'.');
        }
        sb.setLength(leng);
    }
}

