/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
 *
 * https://leetcode.com/problems/count-univalue-subtrees/description/
 *
 * algorithms
 * Medium (49.68%)
 * Likes:    333
 * Dislikes: 75
 * Total Accepted:    45.7K
 * Total Submissions: 91.2K
 * Testcase Example:  '[5,1,5,5,5,null,5]'
 *
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * Example :
 * 
 * 
 * Input:  root = [5,1,5,5,5,null,5]
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           1   5
 * ⁠          / \   \
 * ⁠         5   5   5
 * 
 * Output: 4
 * 
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
    int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    
    boolean helper(TreeNode root) {
        if (root == null) return true;
            
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if (left && right && 
           (root.left == null || root.val == root.left.val) && 
           (root.right == null || root.val == root.right.val)) {
            count++;
            return true;
        }
        
        return false;
    }
}

