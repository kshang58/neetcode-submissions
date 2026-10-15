class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] pre : prerequisites) {
            prereq.putIfAbsent(pre[1], new ArrayList<>());
            prereq.get(pre[1]).add(pre[0]);
            indegree[pre[0]] ++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i ++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int courseToken = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            courseToken ++;
            List<Integer> neis = prereq.getOrDefault(cur, new ArrayList<>());
            for (int nei : neis) {
                indegree[nei] --;
                if (indegree[nei] == 0) queue.offer(nei);
            }
        }
        return courseToken == numCourses;
    }
}