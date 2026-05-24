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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode root, int pathMax) {
        if (root == null) {
            return 0;
        }
        int newPathMax = Math.max(pathMax, root.val);
        int left = dfs(root.left, newPathMax);
        int right = dfs(root.right, newPathMax);
        if(root.val < pathMax){
            return left + right;
        } else {
            return left + right + 1;
        }
    }
}
