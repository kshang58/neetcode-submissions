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
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, globalMax);
        int right = helper(root.right, globalMax);
        globalMax[0] = Math.max(globalMax[0], left + right);
        return Math.max(left, right) + 1;
    }
}
