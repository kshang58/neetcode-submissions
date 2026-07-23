class Solution {
    public int characterReplacement(String s, int k) {
        char[] sc = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int mostFreq = 0;

        while(right < sc.length) {
            hm.put(sc[right], hm.getOrDefault(sc[right], 0) + 1);
            mostFreq = Math.max(mostFreq, hm.get(sc[right]));
            if (right - left + 1 - mostFreq > k) {
                hm.put(sc[left], hm.getOrDefault(sc[left], 0) - 1);
                left ++;
            }
            right ++;
        }
        return Math.min(mostFreq + k, sc.length);
    }
}
