class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rslt = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            rslt.add(intervals[i]);
            i ++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] =  Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] =  Math.max(intervals[i][1], newInterval[1]);
            i ++;
        }
        rslt.add(newInterval);
        while (i < intervals.length) {
            rslt.add(intervals[i]);
            i ++;
        }
        int[][] finalRslt = new int[rslt.size()][2];
        for (int j = 0; j < rslt.size(); j ++) {
            finalRslt[j] = rslt.get(j);
        }
        return finalRslt;
    }
}
