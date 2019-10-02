/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.42%)
 * Likes:    1024
 * Dislikes: 22
 * Total Accepted:    169.7K
 * Total Submissions: 413.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length-1, 0, postorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int rootIndex, int startIndex, int endIndex) {
        // invalid check
        if (rootIndex<0 || endIndex<startIndex) return null;
        // find root in inorder array
        int rootVal = postorder[rootIndex];

        int pos = startIndex;
        for (int i=startIndex; i<=endIndex; i++) {
            if (inorder[i] == rootVal) {
                pos = i;
                break;
            }
        }

        //build root node
        int rightTreeLength = endIndex-pos;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, postorder, rootIndex-rightTreeLength-1, startIndex, pos-1);
        root.right = helper(inorder, postorder, rootIndex-1, pos+1, endIndex);

        return root;
    }
}

