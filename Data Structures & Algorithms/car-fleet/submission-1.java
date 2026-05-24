class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] time = new int[speed.length];
        double[][] map = new double[speed.length][2];
        for (int i = 0; i < speed.length; i ++) {
            map[i][0] = (double)(target - position[i]) / speed[i];
            map[i][1] = (double)(position[i]);
        }
        Deque<Double> stack = new ArrayDeque<>();
        Arrays.sort(map, (a, b) -> Double.compare(a[1], b[1]));
        // 4 1 0 7
        // 3 4.5 10 3
        // 0  1   4  7
        // 10 4.5 3  3
        for (int i = map.length - 1; i >= 0; i --) {
            if (stack.isEmpty() || stack.peekFirst() < map[i][0]) {
                stack.offerFirst(map[i][0]);
            }
        }
        return stack.size();
    }
}
