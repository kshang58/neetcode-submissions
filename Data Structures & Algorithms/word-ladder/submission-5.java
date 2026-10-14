class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); 
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            for (int s = 0; s < size; s ++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step;
                for (int i = 0; i < cur.length(); i ++) {
                    for (char c = 'a'; c <= 'z'; c ++) {
                        String nei = cur.substring(0, i) + c + cur.substring(i + 1);
                        if (!wordSet.contains(nei) || visited.contains(nei)) continue;
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }
        }
        return 0;
    }
}
