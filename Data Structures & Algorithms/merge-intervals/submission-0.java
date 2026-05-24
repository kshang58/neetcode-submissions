class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 1;
        while(i < intervals.length && j < intervals.length) {
            int[] slow = intervals[i];
            while (j < intervals.length) {
                int[] fast = intervals[j];
                if (fast[0] <= slow[1]) {
                    slow[1] = Math.max(slow[1], fast[1]);
                    j ++;
                } else {
                    i ++;
                    intervals[i] = intervals[j];
                    j ++;
                    break;
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
