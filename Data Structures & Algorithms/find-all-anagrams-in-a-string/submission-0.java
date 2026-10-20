class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;
        char[] arr = s.toCharArray();
        int[] needs = new int[26];
        int count = 0;
        for (char c : p.toCharArray()) {
            if (needs[c - 'a'] == 0) count ++;
            needs[c - 'a'] ++;
        }
        for (int i = 0; i < p.length(); i ++) {
            needs[arr[i] - 'a'] --;
            if (needs[arr[i] - 'a'] == 0) count --;
        }
        if (count == 0) result.add(0);
        for (int i = p.length(); i < arr.length; i ++) {
            needs[arr[i] - 'a'] --;
            if (needs[arr[i] - 'a'] == 0) count --;
            if (needs[arr[i - p.length()] - 'a'] == 0) count ++;
            needs[arr[i - p.length()] - 'a'] ++;
            if (count == 0) result.add(i - p.length() + 1);
        }
        return result;
    }
}