import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 *
 * https://leetcode.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (50.48%)
 * Likes:    1306
 * Dislikes: 43
 * Total Accepted:    417.9K
 * Total Submissions: 823.4K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * Example 1:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:     1         1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:     1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * Output: false
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
    // recursive
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == q) return true;
    //     if (p == null || q == null) return false;
    //     if (p.val != q.val) return false;
        
    //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // }
    // iterative
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (p!=null) s1.push(p);
        if (q!=null) s2.push(q);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode temp1 = s1.pop();
            TreeNode temp2 = s2.pop();

            if (temp1.val!=temp2.val) return false;

            if (temp1.left!=null) s1.push(temp1.left);
            if (temp2.left!=null) s2.push(temp2.left);
            if (s1.size()!=s2.size()) return false;

            if (temp1.right!=null) s1.push(temp1.right);
            if (temp2.right!=null) s2.push(temp2.right);
            if (s1.size()!=s2.size()) return false;
        }
        return s1.size() == s2.size();
    }

}

