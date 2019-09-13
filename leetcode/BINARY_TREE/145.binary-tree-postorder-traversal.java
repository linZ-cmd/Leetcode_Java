import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (49.63%)
 * Likes:    1088
 * Dislikes: 56
 * Total Accepted:    287.6K
 * Total Submissions: 573.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    // //iterative
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     Stack<TreeNode> s = new Stack<>();
    //     TreeNode cur = root;
    //     TreeNode pre = null;

    //     while (cur != null || !s.empty()) {
    //         while (cur != null) {
    //             s.push(cur);
    //             cur = cur.left;
    //         }
    //         cur = s.peek();
    //         if (cur.right == null || pre == cur.right) {
    //             s.pop();
    //             res.add(cur.val);
    //             pre = cur;
    //             cur = null;
    //         } else {
    //             cur = cur.right;
    //         }
    //     }
    //     return res;
    // }
}

