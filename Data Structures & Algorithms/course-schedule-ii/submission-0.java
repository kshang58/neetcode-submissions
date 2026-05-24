class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int[] preNumber = new int[numCourses];
        int[] rslt = new int[numCourses];

        for (int[] pres : prerequisites) {
            preNumber[pres[0]] ++;
            List<Integer> val = hm.getOrDefault(pres[1], new ArrayList<>());
            val.add(pres[0]);
            hm.put(pres[1], val);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i ++) {
            if (preNumber[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            rslt[index] = cur;
            List<Integer> reduce = hm.getOrDefault(cur, new ArrayList<>());
            for (int i : reduce) {
                preNumber[i] --;
                if (preNumber[i] == 0) {
                    queue.offer(i);
                }
            }
            index ++;
        }
        if (index != numCourses) {
            return new int[0];
        } else {
            return rslt;
        }
    }
}
