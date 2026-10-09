class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] count = new int[candidates.length];
        dfs(candidates, result, count, 0, target);
        return result;
    }
    private void dfs(int[] candidates, List<List<Integer>> result, int[] count, int index, int remaining) {
        if (index == candidates.length) {
            if (remaining == 0) {
                List<Integer> path = new ArrayList<>();
                for (int i = 0; i < candidates.length; i ++) {
                    for (int c = 0; c < count[i]; c ++) {
                        path.add(candidates[i]);
                    }
                }
                result.add(path);
            }
            return;
        }
        for (int i = 0; i <= remaining / candidates[index]; i ++) {
            count[index] = i;
            dfs(candidates, result, count, index + 1, remaining - candidates[index] * i);
            count[index] = 0;
        }
    }

}