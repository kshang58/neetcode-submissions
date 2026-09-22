class WordDictionary {
    class TreeNode {
        boolean isEnd;
        TreeNode[] children;
        public TreeNode() {
            children = new TreeNode[26];
        }
    }
    TreeNode root;
    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TreeNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, TreeNode root) {
        for (int i = index; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TreeNode child : root.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (root.children[c - 'a'] == null) return false;
                root = root.children[c - 'a'];
            }
        }
        return root.isEnd;
    }
}
