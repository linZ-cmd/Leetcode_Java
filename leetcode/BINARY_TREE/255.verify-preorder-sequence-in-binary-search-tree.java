/*
 * @lc app=leetcode id=255 lang=java
 *
 * [255] Verify Preorder Sequence in Binary Search Tree
 *
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
 *
 * algorithms
 * Medium (44.09%)
 * Likes:    417
 * Dislikes: 43
 * Total Accepted:    39.4K
 * Total Submissions: 89K
 * Testcase Example:  '[5,2,6,1,3]'
 *
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Consider the following binary search tree: 
 * 
 * 
 * ⁠    5
 * ⁠   / \
 * ⁠  2   6
 * ⁠ / \
 * ⁠1   3
 * 
 * Example 1:
 * 
 * 
 * Input: [5,2,6,1,3]
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: [5,2,1,3,6]
 * Output: true
 * 
 * Follow up:
 * Could you do it using only constant space complexity?
 * 
 */
class Solution {
    // recursive
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    public boolean helper(int[] preorder, int start, int end) {
        if (end - start <= 1) return true;

        int breakpoint = start+1;
        for (int i=start+1; i<=end; i++) {
            if (preorder[i] < preorder[start]) breakpoint++;
            else break;
        }
        for (int i=breakpoint; i<=end; i++) {
            if (preorder[i] < preorder[start]) return false;
        }

        return helper(preorder, start+1, breakpoint-1) && helper(preorder, breakpoint, end);
    }

    // iterative
    // public boolean verifyPreorder(int[] preorder) {
    //     int min = Integer.MIN_VALUE;
    //     for (int i = 0; i < preorder.length; ++i) {
    //         if (preorder[i] < min) return false;
    //         for (int j = i - 1; j >= 0 && preorder[j] < preorder[i]; --j) {
    //             min = Math.max(min, preorder[j]);
    //         }
    //     }
    //     return true;
    // }

}

