class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(result, sol, arr, 0);
        return result;
    }
    private void dfs(List<List<String>> result, List<String> sol, char[] arr, int index) {
        if (index == arr.length) {
            result.add(new ArrayList<>(sol));
            return;
        }
        for (int i = index; i < arr.length; i ++) {
            if (isPali(arr, index, i)) {
                sol.add(new String(arr, index, i - index + 1));
                dfs(result, sol, arr, i + 1);
                sol.remove(sol.size() - 1);
            }
        }
    }
    private boolean isPali(char[] array, int l, int r) {
        while (l < r) {
            if (array[l] != array[r]) return false;
            l ++;
            r --;
        }
        return true;
    }
}
