class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rslt = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length; i ++) {
            if (intervals[i][1] < newInterval[0]) {
                rslt.add(intervals[i]);
            } else {
                break;
            }
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
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
