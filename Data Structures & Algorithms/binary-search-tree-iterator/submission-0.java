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
class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (root.left != null) {
            stack.offerLast(root.left);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pollLast();
        int rslt = cur.val;
        if (cur.right != null) {
            stack.offerLast(cur.right);
            cur = cur.right;
            while(cur.left != null) {
                stack.offerLast(cur.left);
                cur = cur.left;
            }
        }
        return rslt;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */