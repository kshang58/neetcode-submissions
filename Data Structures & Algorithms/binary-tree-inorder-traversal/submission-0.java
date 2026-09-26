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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rslt = new ArrayList<>();
        dfs(root, rslt);
        return rslt;
    }
    private void dfs(TreeNode root, List<Integer> rslt) {
        if (root == null) return;
        dfs(root.left, rslt);
        rslt.add(root.val);
        dfs(root.right, rslt);
    }
}