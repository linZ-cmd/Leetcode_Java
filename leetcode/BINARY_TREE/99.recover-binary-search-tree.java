import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (35.34%)
 * Likes:    939
 * Dislikes: 52
 * Total Accepted:    127.8K
 * Total Submissions: 358.4K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prevNode = null;
        TreeNode p = null;
        TreeNode q = null;
        while(cur != null){
            if(cur.left == null){
                if(prevNode != null && prevNode.val >= cur.val){
                    if(p == null) p = prevNode;
                    q = cur;
                }
                // Set prev node for scanning
                prevNode = cur;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if(prevNode != null && prevNode.val >= cur.val) {
                        if(p == null) p = prevNode;
                        q = cur;
                    }
                    // Set prev node for scanning
                    prevNode = cur;
                    cur = cur.right;
                }
            }
        }
        swap(p, q);
    }

    private void swap(TreeNode p, TreeNode q){
        if(p == null || q == null) return;
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}

