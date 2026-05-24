class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 1;
        while (i < intervals.length && j < intervals.length) {
            while (j < intervals.length) {
                if (intervals[j][0] > intervals[i][1]) {
                    i ++;
                    intervals[i] = intervals[j];
                    j ++;
                } else {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    j ++;
                }
            }
        }
        int[][] rslt = new int[i + 1][2];
        for (int k = 0; k < i + 1; k ++) {
            rslt[k] = intervals[k];
        }
        return rslt;
    }
}
