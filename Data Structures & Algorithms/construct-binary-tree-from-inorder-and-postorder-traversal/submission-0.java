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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderIndex.put(inorder[i], i);
        }
        return construct(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderIndex);
    }
    private TreeNode construct(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2, Map<Integer, Integer> inorderIndex) {
        if (p1 > p2) return null;
        TreeNode root = new TreeNode(postorder[p2]);
        int rootIndex = inorderIndex.get(postorder[p2]);
        int leftsize = rootIndex - i1;
        root.left = construct(inorder, postorder, i1, rootIndex - 1, p1, p1 + leftsize - 1, inorderIndex);
        root.right = construct(inorder, postorder, rootIndex + 1, i2, p1 + leftsize, p2 - 1, inorderIndex);
        return root;
    }
}