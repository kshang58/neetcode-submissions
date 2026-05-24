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
        ArrayList<Integer> rslt = new ArrayList<>();
        inOrder(root, rslt, k);
        return rslt.get(k - 1);
    }
    private void inOrder(TreeNode root, ArrayList<Integer> rslt, int k) {
        if (rslt.size() == k || root == null) {
            return;
        }
        inOrder(root.left, rslt, k);
        rslt.add(root.val);
        inOrder(root.right, rslt, k);
    }
}
