import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (61.53%)
 * Likes:    1551
 * Dislikes: 59
 * Total Accepted:    578.9K
 * Total Submissions: 933.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
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
    // public int maxDepth(TreeNode root) {
    //     if (root == null)  return 0;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    // }

    //iterative
    public int maxDepth(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return res;
    }
}

