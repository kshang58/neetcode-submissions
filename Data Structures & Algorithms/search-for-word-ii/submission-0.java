class Solution {
    class TreeNode {
        TreeNode[] children;
        int index = -1;
        int remaining = 0;
        public TreeNode() {
            this.children = new TreeNode[26];
        }
    }
    TreeNode root;
    private void addWord(String word, int i) {
        TreeNode node = root;
        node.remaining ++;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TreeNode();
            node = node.children[c - 'a'];
            node.remaining ++;
        }
        node.index = i;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        this.root = new TreeNode();
        for (int i = 0; i < words.length; i ++) {
            addWord(words[i], i);
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                root.remaining -= dfs(board, i, j, root, result, words);
            }
        }
        return result;
    }
    private int dfs(char[][] board, int r, int c, TreeNode root, List<String> result, String[] words) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return 0;
        char cur = board[r][c];
        if (cur == '#') return 0;
        if (root.children[cur - 'a'] == null) return 0;
        board[r][c] = '#';
        TreeNode prev = root;
        root = root.children[cur - 'a'];
        int found = 0;
        if (root.index != -1) {
            result.add(words[root.index]);
            root.index = -1;
            found ++;
        }
        found += dfs(board, r + 1, c, root, result, words);
        found += dfs(board, r - 1, c, root, result, words);
        found += dfs(board, r, c + 1, root, result, words);
        found += dfs(board, r, c - 1, root, result, words);
        board[r][c] = cur;
        root.remaining -= found;
        if (root.remaining == 0) {
            prev.children[cur - 'a'] = null;
        }
        return found;
    }
}










