class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] sC = s.toCharArray();
            Arrays.sort(sC);
            String sorted = new String(sC);
            List<String> val = hm.getOrDefault(sorted, new ArrayList<String>());
            val.add(s);
            hm.put(sorted, val);
        }
        return hm.values().stream().collect(Collectors.toList());
    }
}
