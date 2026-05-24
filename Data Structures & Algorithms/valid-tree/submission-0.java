class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = hm.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> list1 = hm.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[1]);
            list1.add(edge[0]);
            hm.put(edge[0], list);
            hm.put(edge[1], list1);
        }
        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, visit, hm)) {
            return false;
        }
        return visit.size() == n;
    }
    private boolean dfs(int node, int parent, Set<Integer> visit, Map<Integer, List<Integer>> hm) {
        if (visit.contains(node)) {
            return false;
        }
        visit.add(node);
        List<Integer> neighbors = hm.getOrDefault(node, new ArrayList<>());
        for (Integer i : neighbors) {
            if (i == parent) {
                continue;
            }
            if (!dfs(i, node, visit, hm)) {
                return false;
            }
        }
        return true;
    }
}
