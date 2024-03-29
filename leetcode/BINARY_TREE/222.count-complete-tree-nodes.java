/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (35.58%)
 * Likes:    1212
 * Dislikes: 153
 * Total Accepted:    143.5K
 * Total Submissions: 390.2K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}

// bitwise
// public class Solution {
//     public int countNodes(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int l = leftHeight(root.left);
//         int r = leftHeight(root.right);
//         if (l == r) { // left side is full
//             return countNodes(root.right) + (1<<l);
//         }
//         return countNodes(root.left) + (1<<r);
//     }
//     private int leftHeight(TreeNode node) {
//         int h = 0;
//         while (node != null) {
//             h++;
//             node = node.left;
//         }
// return h; }
// }

