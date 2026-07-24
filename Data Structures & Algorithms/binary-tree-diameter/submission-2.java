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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] globalMax = new int[1];
        dbt(root, globalMax);
        return globalMax[0];
    }
    private int dbt(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int left = dbt(root.left, globalMax);
        int right = dbt(root.right, globalMax);
        globalMax[0] = Math.max(globalMax[0], left + right);
        return Math.max(left, right) + 1;
    }
}
