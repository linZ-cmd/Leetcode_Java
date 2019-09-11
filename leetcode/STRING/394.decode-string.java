import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (45.79%)
 * Likes:    1810
 * Dislikes: 97
 * Total Accepted:    125K
 * Total Submissions: 270.9K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 * 
 * 
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        String str = "";

        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                numStack.push(num);
                strStack.push(str);
                num = 0;
                str = "";
            } else if (s.charAt(i) == ']') {
                StringBuilder newStr = new StringBuilder();
                int count = numStack.pop();
                String preStr = strStack.pop();
                newStr.append(preStr);
                for (int j=0; j<count; j++) {
                    newStr.append(str);
                }
                str = newStr.toString();
            } else {
                str += s.charAt(i);
            }
        }
        return str;
    }
}

