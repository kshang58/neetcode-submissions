class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int l = 0, r = 0, curMax = 0;
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            curMax = Math.max(curMax, map.get(arr[r]));
            if (r - l + 1 - curMax > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                l ++;
            }
            r ++;
        }
        return Math.min(curMax + k, arr.length);
    }
}
