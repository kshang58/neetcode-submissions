/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/


class Solution {
    public Node trueNode = new Node(true, true);
    public Node falseNode = new Node(false, true);
    public Node construct(int[][] grid) {
        return helper(grid, grid.length, 0, 0);
    }
    private Node helper(int[][] grid, int n, int r, int c) {
        if (n == 1) {
            return grid[r][c] == 1 ? trueNode : falseNode;
        }
        n /= 2;
        Node tl = helper(grid, n, r, c);
        Node tr = helper(grid, n, r, c + n);
        Node bl = helper(grid, n, r + n, c);
        Node br = helper(grid, n, r + n, c + n);
        if (tl.val == tr.val && tl.val == bl.val && tl.val == br.val && tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            return tl;
        }
        return new Node(false, false, tl, tr, bl, br);
    }
}