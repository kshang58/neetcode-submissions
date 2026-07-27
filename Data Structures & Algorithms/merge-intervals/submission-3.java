class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = i + 1;
        List<int[]> rslt = new ArrayList<>();
        while (j < intervals.length) {
            if (intervals[i][1] < intervals[j][0]) {
                rslt.add(intervals[i]);
                i = j;
                j ++;
            } else {
                intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j ++;
            }
        }
        rslt.add(intervals[i]);
        int[][] finalRslt = new int[rslt.size()][2];
        for (int k = 0; k < rslt.size(); k ++) {
            finalRslt[k] = rslt.get(k);
        }
        return finalRslt;
    }
}
