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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('N');
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        preOrder(root.left, sb);
        preOrder(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[]{0};
        return helper(data, index);
    }
    private TreeNode helper(String data, int[] index) {
        if (data.charAt(index[0]) == 'N') {
            index[0] += 2;
            return null;
        }
        int i = index[0];
        int val = 0;
        while (Character.isDigit(data.charAt(i))) {
            val = val * 10 + Character.getNumericValue(data.charAt(i));
            i ++;
        }
        TreeNode cur = new TreeNode(val);
        index[0] = i + 1;
        TreeNode left = helper(data, index);
        TreeNode right = helper(data, index);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}
