class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int[] preNumber = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        int courseTaken = 0;
        for (int[] pres : prerequisites) {
            preNumber[pres[0]] ++;
            List<Integer> preList = hm.getOrDefault(pres[1], new ArrayList<>());
            preList.add(pres[0]);
            hm.put(pres[1], preList);
        }
        for (int i = 0; i < numCourses; i ++) {
            if (preNumber[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            courseTaken ++;
            List<Integer> li = hm.getOrDefault(cur, new ArrayList<>());
            for (int i : li) {
                preNumber[i] --;
                if (preNumber[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return courseTaken == numCourses;
    }
}
