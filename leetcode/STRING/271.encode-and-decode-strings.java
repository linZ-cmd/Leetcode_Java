/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 *
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 *
 * algorithms
 * Medium (27.39%)
 * Likes:    272
 * Dislikes: 98
 * Total Accepted:    43.6K
 * Total Submissions: 157.7K
 * Testcase Example:  '["Hello","World"]'
 *
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original
 * list of strings.
 * 
 * Machine 1 (sender) has the function:
 * 
 * 
 * string encode(vector<string> strs) {
 * ⁠ // ... your code
 * ⁠ return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * 
 * 
 * vector<string> decode(string s) {
 * ⁠ //... your code
 * ⁠ return strs;
 * }
 * 
 * 
 * So Machine 1 does:
 * 
 * 
 * string encoded_string = encode(strs);
 * 
 * 
 * and Machine 2 does:
 * 
 * 
 * vector<string> strs2 = decode(encoded_string);
 * 
 * 
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters.
 * Do not use class member/global/static variables to store states. Your encode
 * and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You
 * should implement your own encode/decode algorithm.
 * 
 * 
 */
// public class Codec {     //use length+delimiter+string to encode and decode
//     // Encodes a list of strings to a single string.
//     public String encode(List<String> strs) {
//         StringBuilder res = new StringBuilder();
//         for (String str : strs) {
//             int size = str.length();
//             res.append(size);
//             res.append(":");
//             res.append(str);
//         }
//         return res.toString();
//     }

//     // Decodes a single string to a list of strings.
//     public List<String> decode(String s) {
//         List<String> res = new ArrayList<>();
//         int i = 0;
//         while (i<s.length()) {
//             char c = s.charAt(i);
//             int delimiter = s.indexOf(":", i);
//             int size = Integer.valueOf(s.substring(i, delimiter));
//             String str = s.substring(delimiter+1, delimiter+1+size);
//             res.add(str);
//             i = delimiter + 1 + size;
//         }
//         return res;
//     }
// }

public class Codec {     //use escape character to encode and decode
    // Encodes a list of strings to a single string.

    // use escape character `/` to escape valid `#` and `/`
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            for (int i=0 ;i<str.length(); i++) {
                char c = str.charAt(i);
                if (c == '/') {
                    res.append("//");
                }else if (c == '#') {
                    res.append("/#");
                }else {
                    res.append(c);
                }
            }
            res.append('#');
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder substr = new StringBuilder();
        int i = 0;
        while (i<s.length()) {
            char c = s.charAt(i);
            if (c == '/') {
                i ++;
                substr.append(s.charAt(i));
            } else if (c == '#') {
                res.add(substr.toString());
                substr = new StringBuilder();
            } else {
                substr.append(c);
            }
            i++;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

