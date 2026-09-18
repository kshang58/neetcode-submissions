class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new HashSet<>());
        }
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i ++) {
            if (!dfs(i, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int num, Map<Integer, Set<Integer>> preMap, Set<Integer> visiting) {
        if (visiting.contains(num)) {
            return false;
        }
        visiting.add(num);
        for (int p : preMap.get(num)) {
            if (!dfs(p, preMap, visiting)) {
                return false;
            }
        }
        visiting.remove(num);
        preMap.put(num, new HashSet<>());
        return true;
    }
}
