class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 1;
        int counter = 0;
        while(j < intervals.length) {
            if (intervals[j][0] < intervals[i][1]) {
                intervals[i][1] = Math.min(intervals[i][1], intervals[j][1]);
                counter ++;
                j ++;
            } else {
                i = j;
                j ++;
            }
        }
        return counter;
    }
}
