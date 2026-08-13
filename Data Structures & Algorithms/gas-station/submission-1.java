class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] diff = new int[n];
        int tot = 0;
        for (int i = 0; i < n; i ++) {
            diff[i] = gas[i] - cost[i];
            tot += diff[i];
        }
        if (tot < 0) return -1;
        tot = 0;
        int rslt = 0;
        for (int i = 0; i < n; i ++) {
            tot += diff[i];
            if (tot < 0) {
                tot = 0;
                rslt = i + 1;
                continue;
            } 
        }
        return rslt;
    }
}
