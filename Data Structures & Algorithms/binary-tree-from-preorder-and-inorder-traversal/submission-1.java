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
    private Map<Integer, Integer> inMap = new HashMap<>();
    private Integer preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preIndex]);
        int mid = inMap.get(preorder[preIndex]);
        preIndex ++;
        TreeNode left = dfs(preorder, inorder, l, mid - 1);
        TreeNode right = dfs(preorder, inorder, mid + 1, r);
        cur.left = left;
        cur.right = right;
        return cur;
    }

}
