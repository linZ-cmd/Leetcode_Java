/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (32.12%)
 * Likes:    738
 * Dislikes: 307
 * Total Accepted:    148.5K
 * Total Submissions: 461.9K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }

    public void dfs(List<String> res, String s, StringBuilder sb, int ipIndex, int strIndex) {
        if (ipIndex > 4) return;
        if (ipIndex == 4 && strIndex == s.length()) {
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
            return;
        }

        for (int i=0; i<3; i++) {
            if (strIndex + i < s.length()) {
                String subStr = s.substring(strIndex, strIndex+i
                +1);
                if (isValid(subStr)) {
                    int curLength = sb.length();
                    sb.append(subStr);
                    sb.append('.');
                    dfs(res, s, sb, ipIndex+1, strIndex+1+i);
                    sb.setLength(curLength);
                }
            }
        }
    }

    public boolean isValid(String str) {
        if (str.charAt(0)=='0') return str.length() == 1;
        int num = Integer.parseInt(str);
        if (num>0 && num<=255) return true;
        return false;
    }
}

