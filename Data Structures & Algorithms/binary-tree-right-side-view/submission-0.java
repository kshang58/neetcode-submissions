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
    public List<Integer> rightSideView(TreeNode root) {
        // cornor case
        List<Integer> rslt = new ArrayList<>();
        if (root == null) {
            return rslt;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.pollLast();
                if (i == size - 1) {
                    rslt.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
        }
        return rslt;
    }
}
