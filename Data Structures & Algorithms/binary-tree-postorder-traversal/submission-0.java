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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rslt = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Boolean> visited = new ArrayDeque<>();
        if (root == null) return rslt;
        TreeNode cur = root;
        stack.offerFirst(cur);
        visited.offerFirst(false);
        while (!stack.isEmpty()) {
            cur = stack.pollFirst();
            boolean v = visited.pollFirst();
            if (!v) {
                stack.offerFirst(cur);
                visited.offerFirst(true);
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                    visited.offerFirst(false);
                }
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                    visited.offerFirst(false);
                }
            } else {
                rslt.add(cur.val);
            }
        }
        return rslt;
    }
}