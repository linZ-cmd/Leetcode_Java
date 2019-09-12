/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (57.81%)
 * Likes:    1926
 * Dislikes: 85
 * Total Accepted:    523.7K
 * Total Submissions: 897.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    // iterative
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     Stack<TreeNode> s = new Stack();
    //     TreeNode cur = root;

    //     while (cur!=null || !s.isEmpty()) {
    //         while (cur!=null) {
    //             s.push(cur);
    //             cur = cur.left;
    //         }
    //         TreeNode temp = s.pop();
    //         res.add(temp.val);
    //         cur = temp.right;
    //     }
    //     return res;
    // }
}

