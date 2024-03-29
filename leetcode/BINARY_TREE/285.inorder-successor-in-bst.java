import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
 *
 * https://leetcode.com/problems/inorder-successor-in-bst/description/
 *
 * algorithms
 * Medium (35.62%)
 * Likes:    787
 * Dislikes: 54
 * Total Accepted:    116.1K
 * Total Submissions: 321.7K
 * Testcase Example:  '[2,1,3]\n1'
 *
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * The successor of a node p is the node with the smallest key greater than
 * p.val.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the
 * return value is of TreeNode type.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the
 * answer is null.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
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
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        
        while (root!=null) {
            if (root.val>p.val) {
                res = root;
                root = root.left;
            } else root = root.right;
        }
        return res;
    }


    // using stack
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;

        while(root!=null || !s.isEmpty()) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (pre == p) return root;
            pre = root;
            root = root.right;
        }
        return null;
    }

}

