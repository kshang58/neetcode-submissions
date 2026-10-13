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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else {
                if (flag) return false;
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else {
                if (flag) return false;
                queue.offer(cur.right);
            }
        }
        return true;
    }
}