class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int[] p : prerequisites) {
            hm.putIfAbsent(p[1], new ArrayList<>());
            hm.get(p[1]).add(p[0]);
            indegree[p[0]] ++;
        }
        for (int i = 0; i < numCourses; i ++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nei = hm.getOrDefault(cur, new ArrayList<>());
            for (int i : nei) {
                indegree[i] --;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        for (int i : indegree) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
