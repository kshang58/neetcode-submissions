class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = i + 1;
        int rslt = 0;
        while (j < intervals.length) {
            if (intervals[i][1] > intervals[j][0]) {
                intervals[i][1] = Math.min(intervals[i][1], intervals[j][1]);
                j ++;
                rslt ++;
            } else {
                i = j;
                j ++;
            }
        }
        return rslt;
    }
}
