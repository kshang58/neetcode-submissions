class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> hs = new HashSet<>(wordList);
        hs.remove(beginWord);
        Queue<String> queue = new ArrayDeque<>();
        int n = wordList.size();
        int m = beginWord.length();
        queue.offer(beginWord);
        int trans = 0;
        while(!queue.isEmpty()) {
            trans ++;
            int size = queue.size();
            for (int s = 0; s < size; s ++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return trans;
                for (int i = 0; i < m; i ++) {
                    for (char c = 'a'; c <= 'z'; c ++) {
                        if (cur.charAt(i) == c) continue;
                        String nei = cur.substring(0, i) + c + cur.substring(i + 1);
                        if (hs.contains(nei)) {
                            queue.offer(nei);
                            hs.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
