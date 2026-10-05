class Solution {
    // 1 2 2 2 5
    // 1 2 

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, sol, 0);
        return result;
    }
    private void dfs(int[] arr, int target, List<List<Integer>> result, List<Integer> sol, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(sol));
            return;
        }
        // 1 1 2 5 6 7 10
        for (int i = index; i < arr.length; i ++) {
            if (target < arr[i]) break;
            if (i > index && arr[i] == arr[i - 1]) continue;
            sol.add(arr[i]);
            dfs(arr, target - arr[i], result, sol, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}