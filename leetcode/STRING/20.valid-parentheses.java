import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.00%)
 * Likes:    3299
 * Dislikes: 155
 * Total Accepted:    681.2K
 * Total Submissions: 1.8M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '{' ||c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                Character temp = stack.pop();
                if (temp != getPair(c)) return false;
            }
        }
        return stack.size() ==0;
    }

    public Character getPair(Character c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else if (c == ']') {
            return '[';
        }
        return 's';
    }
}

