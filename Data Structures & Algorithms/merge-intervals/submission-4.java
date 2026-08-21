class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> rslt = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i ++) {
            int[] next = intervals[i];
            // overlap, need to merge
            if (cur[1] >= next[0]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                // no overlap, add cur to rslt
                rslt.add(cur);
                cur = next;
            }
        }
        // last one has no next, so need to post processing
        rslt.add(cur);
        return rslt.toArray(new int[rslt.size()][]);
    }
}
