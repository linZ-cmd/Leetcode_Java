/*
 * @lc app=leetcode id=247 lang=java
 *
 * [247] Strobogrammatic Number II
 *
 * https://leetcode.com/problems/strobogrammatic-number-ii/description/
 *
 * algorithms
 * Medium (45.00%)
 * Likes:    251
 * Dislikes: 85
 * Total Accepted:    52.3K
 * Total Submissions: 116K
 * Testcase Example:  '2'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * Example:
 * 
 * 
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 * 
 * 
 */
class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[] num = new char[n];
        char[] opt1 ={'1','8','0','6','9'};
        char[] opt2 ={'1','8','0','9','6'};
        List<String> res = new ArrayList<>();
        dfs(opt1, opt2, n, res, num, 0);
        return res;
    }

    public void dfs(char[] opt1, char[] opt2, int n, List<String> res, char[] num, int index) {
        int left = index;
        int right = n-left-1;
        if (left>right) {
            res.add(new String(num));
            return;
        }
        if (left == right) {
            for (int i=0;i<3;i++) {
                num[left] = opt1[i];
                dfs(opt1, opt2, n, res, num, index+1);
            }
        } else {
            for (int i=0; i<5; i++) {
                if (index==0 && i==2) continue;
                num[left] = opt1[i];
                num[right] = opt2[i];
                dfs(opt1, opt2, n, res, num, index+1);
            }
        }
    }

}
