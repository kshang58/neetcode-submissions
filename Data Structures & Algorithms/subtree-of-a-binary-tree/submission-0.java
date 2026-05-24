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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case
        if(root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        boolean isSameTree = false;
        if(root.val == subRoot.val){
            isSameTree = isSame(root, subRoot);
        }
        // recursion rule
        return isSameTree || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        }
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
