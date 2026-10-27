class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i ++) {
            secondDim[i] = envelopes[i][1];
        }
        return lIS(secondDim);
    }
    private int lIS(int[] arr) {
        List<Integer> dp = new ArrayList<>();
        for (int i : arr) {
            if (dp.isEmpty() || dp.get(dp.size() - 1) < i) {
                dp.add(i);
            } else {
                int index = binarySearch(dp, i);
                dp.set(index, i);
            }
        }
        return dp.size();
    }
    private int binarySearch(List<Integer> dp, int target) {
        int l = 0;
        int r = dp.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (dp.get(m) == target) {
                return m;
            } else if (dp.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}