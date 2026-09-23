class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> rslt = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            if (!rslt.isEmpty() && rslt.get(rslt.size() - 1)[1] >= interval[0]) {
                int[] last = rslt.get(rslt.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
                rslt.set(rslt.size() - 1, last);
            } else {
                rslt.add(interval);
            }
        }
        int[][] r = new int[rslt.size()][2];
        for (int i = 0; i < r.length; i ++) {
            r[i] = rslt.get(i);
        }
        return r;
    }
}