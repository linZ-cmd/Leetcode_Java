import java.util.ArrayList;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (46.80%)
 * Likes:    972
 * Dislikes: 73
 * Total Accepted:    239.4K
 * Total Submissions: 511.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        //corner case
        if (root == null) return res;
        dfs(root, res, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode node, List<String> res, StringBuilder path) {
        //before adding node value, first record current position
        int currentLength = path.length();
        //add node value
        path.append(node.val);
        //ending condition
        if (node.left == null && node.right == null) {
            res.add(path.toString());
            //return to upper level
            path.setLength((currentLength));
            return;
        }
        path.append("->");
        if (node.left != null) dfs(node.left, res, path);
        if (node.right != null) dfs(node.right, res, path);
        //return to upper level
        path.setLength(currentLength);
    }
}

