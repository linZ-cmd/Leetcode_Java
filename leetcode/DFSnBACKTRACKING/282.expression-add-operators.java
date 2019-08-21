/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (33.25%)
 * Likes:    770
 * Dislikes: 106
 * Total Accepted:    73.9K
 * Total Submissions: 221.8K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] numArr = num.toCharArray();
        dfs(res,new StringBuilder(),numArr,target,0,0,0);
        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, char[] numArr, int target, long preSum, long preNum, int index) {
        if (index==numArr.length&&preSum==target) {
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        long curNum = 0;
        for (int i=index;i<numArr.length;i++) {
            if (numArr[index]=='0'&&i!=index) continue;
                curNum = 10*curNum+(numArr[i]-'0');
            if (index == 0) {
                sb.append(curNum);
                dfs(res, sb, numArr, target, curNum, curNum, i+1);
                sb.setLength(length);
            } else {
                dfs(res, sb.append("+").append(curNum), numArr, target, preSum+curNum, curNum, i+1);
                sb.setLength(length);
                dfs(res, sb.append("-").append(curNum), numArr, target, preSum-curNum, -curNum, i+1);
                sb.setLength(length);
                dfs(res, sb.append("*").append(curNum), numArr, target, preSum-preNum+preNum*curNum, preNum*curNum, i+1);
                sb.setLength(length);
            }
        }
    }
}

