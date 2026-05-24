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
    public int maxPathSum(TreeNode root) {
        int[] globalMax = new int[]{Integer.MIN_VALUE};
        mps(root, globalMax);
        return globalMax[0];
    }
    private int mps(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int left = mps(root.left, globalMax);
        int right = mps(root.right, globalMax);
        globalMax[0] = Math.max(globalMax[0], left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
