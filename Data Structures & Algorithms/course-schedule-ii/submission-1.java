class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] rslt = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int[] pre : prerequisites) {
            indegree[pre[0]] ++;
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i ++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            rslt[index] = cur;
            index ++;
            List<Integer> dependencies = map.get(cur);
            if (dependencies == null) continue;
            for (int d : dependencies) {
                indegree[d] --;
                if (indegree[d] == 0) {
                    queue.offer(d);
                }
            }
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return rslt;
    }
}
