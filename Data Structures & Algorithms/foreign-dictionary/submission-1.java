class Solution {
    Map<Character, List<Character>> map;
    List<Character> rslt;
    Map<Character, Boolean> visited;
    public String foreignDictionary(String[] words) {
        map = new HashMap<>();
        rslt = new ArrayList<>();
        visited = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i ++) {
            String w1 = words[i], w2 = words[i + 1];
            int w1l = w1.length(), w2l = w2.length();
            int minLen = Math.min(w1l, w2l);
            if (w1l > w2l && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j ++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        for (char c : map.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        Collections.reverse(rslt);
        StringBuilder sb = new StringBuilder();
        for (char c : rslt) {
            sb.append(c);
        }
        return sb.toString();
    }
    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);
        for (char nxt : map.get(c)) {
            if (dfs(nxt)) {
                return true;
            }
        }
        visited.put(c, false);
        rslt.add(c);
        return false;
    }
}
