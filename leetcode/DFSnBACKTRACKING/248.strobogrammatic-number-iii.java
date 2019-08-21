/*
 * @lc app=leetcode id=248 lang=java
 *
 * [248] Strobogrammatic Number III
 *
 * https://leetcode.com/problems/strobogrammatic-number-iii/description/
 *
 * algorithms
 * Hard (37.16%)
 * Likes:    128
 * Dislikes: 116
 * Total Accepted:    21.5K
 * Total Submissions: 57.7K
 * Testcase Example:  '"50"\n"100"'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to count the total strobogrammatic numbers that exist in
 * the range of low <= num <= high.
 * 
 * Example:
 * 
 * 
 * Input: low = "50", high = "100"
 * Output: 3 
 * Explanation: 69, 88, and 96 are three strobogrammatic numbers.
 * 
 * Note:
 * Because the range might be a large number, the low and high numbers are
 * represented as string.
 * 
 */
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        char[] opt1 = {'1','8','0','6','9'};
        char[] opt2 = {'1','8','0','9','6'};
        int count = 0;
        for (int i=low.length();i<=high.length();i++) {
            char[] num = new char[i];
            count += dfs(opt1, opt2, num, i, 0, low, high);
        }
        return count;
    }

    public int dfs(char[] opt1, char[] opt2, char[] num, int length, int index, String low, String high) {
        int left = index;
        int right = length-index-1;
        int count = 0;
        if (left>right) {
            String number = new String(num);
            if ((number.compareTo(low) < 0 && number.length()==low.length())
             || (number.compareTo(high)>0 && number.length()==high.length())) return 0;
             else return 1;
        }
        if (left == right) {
            for (int i=0; i<3; i++) {
                num[left] = opt1[i];
                count += dfs(opt1, opt2, num, length, index+1, low, high);
            }
        } else {
            for (int i=0; i<5; i++) {
                if (index == 0 && i == 2) continue;
                num[left] = opt1[i];
                num[right] = opt2[i];
                count += dfs(opt1, opt2, num, length, index+1, low, high);
            }
        }
        return count;
    }
}

