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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderIndex.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderIndex);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2, Map<Integer, Integer> inorderIndex) {
        if (p1 > p2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p1]);
        int rootIndex = inorderIndex.get(preorder[p1]);
        int leftsize = rootIndex - i1;
        root.left = helper(preorder, inorder, p1 + 1, p1 + leftsize, i1, rootIndex - 1, inorderIndex);
        root.right = helper(preorder, inorder, p1 + leftsize + 1, p2, rootIndex + 1, i2, inorderIndex);
        return root;
    }
}