class PrefixTree {
    class TreeNode {
        boolean isEnd;
        Map<Character, TreeNode> children = new HashMap<>();
    }
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TreeNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return true;
    }
}
