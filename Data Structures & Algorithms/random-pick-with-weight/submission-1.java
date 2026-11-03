class Solution {
    long[] prefixSum;
    long max;
    public Solution(int[] w) {
        prefixSum = new long[w.length];
        for (int i = 0; i < w.length; i ++) {
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + w[i];
        }
        max = prefixSum[w.length - 1];
    }
    
    public int pickIndex() {
        double target = Math.random() * max;
        int left = 0;
        int right = prefixSum.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;
            if (prefixSum[m] <= target) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */