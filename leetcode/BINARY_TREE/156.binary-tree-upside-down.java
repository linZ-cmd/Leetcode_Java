/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
 *
 * https://leetcode.com/problems/binary-tree-upside-down/description/
 *
 * algorithms
 * Medium (51.65%)
 * Likes:    201
 * Dislikes: 668
 * Total Accepted:    51.7K
 * Total Submissions: 99K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a
 * sibling (a left node that shares the same parent node) or empty, flip it
 * upside down and turn it into a tree where the original right nodes turned
 * into left leaf nodes. Return the new root.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,4,5]
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \
 * 4   5
 * 
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠5   2
 * ⁠   / \
 * ⁠  3   1  
 * 
 * 
 * Clarification:
 * 
 * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is
 * serialized on OJ.
 * 
 * The serialization of a binary tree follows a level order traversal, where
 * '#' signifies a path terminator where no node exists below.
 * 
 * Here's an example:
 * 
 * 
 * ⁠  1
 * ⁠ / \
 * ⁠2   3
 * ⁠   /
 * ⁠  4
 * ⁠   \
 * ⁠    5
 * 
 * 
 * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode temp = null;

        while (cur!=null) {
            TreeNode next = cur.left;
            cur.left = temp;
            temp =  cur.right;
            cur.right = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}

