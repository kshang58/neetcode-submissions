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
    public int sumNumbers(TreeNode root) {
        List<Integer> rslt = new ArrayList<>();
        dfs(root, rslt, 0);
        return rslt.stream().mapToInt(Integer::intValue).sum();
    }
    private void dfs(TreeNode root, List<Integer> rslt, int prev) {
        if (root == null) {
            return;
        }
        int cur = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            rslt.add(cur);
            return;
        }
        dfs(root.left, rslt, cur);
        dfs(root.right, rslt, cur);
    }
}