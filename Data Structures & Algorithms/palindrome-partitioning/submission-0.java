class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rslt = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        char[] c = s.toCharArray();
        dfs(rslt, sol, c, 0);
        return rslt;
    }
    private void dfs(List<List<String>> rslt, List<String> sol, char[] c, int index) {
        if(index == c.length) {
            rslt.add(new ArrayList<>(sol));;
            return;
        }
        for(int i = index; i < c.length; i ++) {
            if(isPalindrome(c, index, i)) {
                sol.add(new String(c, index, i - index + 1));
                dfs(rslt, sol, c, i + 1);
                sol.remove(sol.size() - 1);
            }
        }
    }
    private boolean isPalindrome(char[] c, int i, int j) {
        while(i < j) {
            if(c[i] != c[j]) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
