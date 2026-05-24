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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> rslt = new ArrayList<>();
        inOrder(root, rslt, k);
        return rslt.get(k - 1);
    }
    private void inOrder(TreeNode root, List<Integer> rslt, int k) {
        if(root == null) {
            return;
        }
        if(rslt.size() == k) {
            return;
        }
        inOrder(root.left, rslt, k);
        rslt.add(root.val);
        inOrder(root.right, rslt, k);
    }
}
