 /*
 * @lc app=leetcode id=333 lang=java
 *
 * [333] Largest BST Subtree
 *
 * https://leetcode.com/problems/largest-bst-subtree/description/
 *
 * algorithms
 * Medium (33.56%)
 * Likes:    411
 * Dislikes: 42
 * Total Accepted:    35.1K
 * Total Submissions: 103.5K
 * Testcase Example:  '[10,5,15,1,8,null,7]'
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree
 * (BST), where largest means subtree with largest number of nodes in it.
 * 
 * Note:
 * A subtree must include all of its descendants.
 * 
 * Example:
 * 
 * 
 * Input: [10,5,15,1,8,null,7]
 * 
 * ⁠  10 
 * ⁠  / \ 
 * ⁠ 5  15 
 * ⁠/ \   \ 
 * 1   8   7
 * 
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 * ⁠            The return value is the subtree's size, which is 3.
 * 
 * 
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;
        
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        traverse(root);
        return max;
    }
    
    private Result traverse(TreeNode root) {
        if (root == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
