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
    Map<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();
        int[] preIndex = new int[1];
        for (int i = 0; i < inorder.length; i ++) {
            hm.put(inorder[i], i);
        }
        return bt(preorder, inorder, preIndex, 0, inorder.length - 1);
    }
    private TreeNode bt(int[] preorder, int[] inorder, int[] preIndex, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = hm.get(preorder[preIndex[0]]);
        TreeNode cur = new TreeNode(preorder[preIndex[0]]);
        preIndex[0] ++;
        TreeNode left = bt(preorder, inorder, preIndex, l, mid - 1);
        TreeNode right = bt(preorder, inorder, preIndex, mid + 1, r);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}
