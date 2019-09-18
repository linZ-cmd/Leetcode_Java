/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (44.03%)
 * Likes:    2629
 * Dislikes: 57
 * Total Accepted:    460.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
class Solution {
    // recursive
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) return true;
    //     return helper(root.left, root.right);
    // }

    // public boolean helper(TreeNode p, TreeNode q) {
    //     if (p == q) return true;
    //     if (p == null || q == null) return false;
    //     if (p.val!=q.val) return false;
    //     return helper(p.left, q.right) && helper(p.right, q.left);
    // }

    // iterative
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root);
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1.val != node2.val) return false;
            if(node1.left != null)  stack1.push(node1.left);
            if(node2.right != null) stack2.push(node2.right);
            if(stack1.size() != stack2.size()) return false;
            if(node1.right != null) stack1.push(node1.right);
            if(node2.left != null)  stack2.push(node2.left);
            if(stack1.size() != stack2.size()) return false;
        }
        return stack1.size() == stack2.size();
    }
}

