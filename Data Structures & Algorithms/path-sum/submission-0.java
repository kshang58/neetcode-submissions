/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode root, int tot, int targetSum) {
        if (root == null) {
            return false;
        }
        tot += root.val;
        if (tot == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, tot, targetSum) || dfs(root.right, tot, targetSum);
    }
}