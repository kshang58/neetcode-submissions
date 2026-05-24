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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rslt = new ArrayList<>();
        if (root == null) {
            return rslt;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sol = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.pollLast();
                sol.add(cur.val);
                if(cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if(cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
            rslt.add(sol);
        }
        return rslt;
    }
}
