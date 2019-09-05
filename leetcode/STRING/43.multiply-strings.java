/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (31.28%)
 * Likes:    1142
 * Dislikes: 516
 * Total Accepted:    219.8K
 * Total Submissions: 700.2K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
      String n1 = new StringBuilder(num1).reverse().toString(); // reverse num1 and num2
      String n2 = new StringBuilder(num2).reverse().toString();
      int[] mul = new int[n1.length()+n2.length()]; // create an array to save multiply answers
      for(int i=0; i<n1.length(); i++) {
        for(int j=0; j<n2.length(); j++) {
          mul[i+j] += (n1.charAt(i)-'0') *(n2.charAt(j)-'0');
        }
      }
      StringBuilder ans = new StringBuilder();
      for(int k=0; k<mul.length; k++) { //
        int digit = mul[k]%10;
        int carry = mul[k]/10;
        if(k<mul.length-1) mul[k+1] += carry;
        ans.insert(0,digit);
      }
      while(ans.charAt(0) == '0'&&ans.length()>1) { // check if prefix of answer is 0, remove 0
        ans.deleteCharAt(0);
      }
      return ans.toString();
    }
}

//* better runtime solution
// class Solution {
//     public String multiply(String num1, String num2) {
//         int m = num1.length(), n = num2.length();
//         int[] pos = new int[m + n];
       
//         for(int i = m - 1; i >= 0; i--) {
//             for(int j = n - 1; j >= 0; j--) {
//                 int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
//                 int p1 = i + j, p2 = i + j + 1;
//                 int sum = mul + pos[p2];
    
//                 pos[p1] += sum / 10;
//                 pos[p2] = (sum) % 10;
//             }
//         }  
        
//         StringBuilder sb = new StringBuilder();
//         for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
//         return sb.length() == 0 ? "0" : sb.toString();
//     }
// }

