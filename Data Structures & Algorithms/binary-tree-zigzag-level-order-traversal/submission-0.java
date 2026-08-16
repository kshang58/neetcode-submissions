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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rslt = new ArrayList<>();
        if (root == null) {
            return rslt;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            // 3 9 20
            int size = queue.size();
            Integer[] sol = new Integer[size];
            for (int i = 0; i < size; i ++) {
                int index = rslt.size() % 2 == 0 ? i : size - 1 - i;
                TreeNode cur = queue.pollLast();
                sol[index] = cur.val;
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
            rslt.add(Arrays.asList(sol));
        }
        return rslt;
    }
}