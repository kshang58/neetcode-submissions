class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] posSpeed = new double[n][3];
        for (int i = 0; i < n; i ++) {
            posSpeed[i][0] = (double)position[i];
            posSpeed[i][1] = (double)speed[i];
            posSpeed[i][2] = (target - posSpeed[i][0]) / posSpeed[i][1];
        }
        Arrays.sort(posSpeed, (a, b) -> Double.compare(a[0], b[0]));
        int num = n;
        int j = n - 2;
        double fleetTime = posSpeed[n - 1][2];
        while (j >= 0) {
            if (fleetTime >= posSpeed[j][2]) {
                num --;
            } else {
                fleetTime = posSpeed[j][2];
            }
            j --;
        }
        return num;
    }
}
