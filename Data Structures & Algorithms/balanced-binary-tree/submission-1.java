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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int[] rslt = dfs(root);
        return rslt[1] == 0;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if(left[1] != 0 || right[1] != 0) {
            return new int[]{0, 1};
        } else if (Math.abs(left[0] - right[0]) > 1) {
            return new int[]{0, 1};
        } else {
            return new int[]{Math.max(left[0], right[0]) + 1, 0};
        }
    }
}
