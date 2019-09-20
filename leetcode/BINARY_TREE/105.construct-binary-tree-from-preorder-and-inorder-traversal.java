/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (42.44%)
 * Likes:    2071
 * Dislikes: 56
 * Total Accepted:    255.4K
 * Total Submissions: 591.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preOrderIndex, int inorderStart, int inOrderEnd) {
        if (inorderStart>inOrderEnd || preOrderIndex>=preorder.length) return null;
        int rootVal = preorder[preOrderIndex];
        int inOrderIndex = inorderStart;
        for (int i=inorderStart; i<=inOrderEnd; i++) {
            if (inorder[i] == rootVal) {
                inOrderIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftTreeLength = inOrderIndex - inorderStart;

        root.left = helper(preorder, inorder, preOrderIndex+1, inorderStart, inOrderIndex-1);
        root.right = helper(preorder, inorder, preOrderIndex+leftTreeLength+1, inOrderIndex+1, inOrderEnd);
        return root;
    }
}

