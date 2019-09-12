import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (52.17%)
 * Likes:    911
 * Dislikes: 45
 * Total Accepted:    374.3K
 * Total Submissions: 712.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    // // iterative
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     Stack<TreeNode> s = new Stack<>();
    //     if (root != null) s.push(root);

    //     while (!s.isEmpty()) {
    //         TreeNode cur = s.pop();
    //         res.add(cur.val);
    //         if (cur.right != null) s.push(cur.right);
    //         if (cur.left != null) s.push(cur.left);
    //     }
    //     return res;
    // }
}

