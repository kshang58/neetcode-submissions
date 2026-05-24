class Solution {
    Map<Character, String> hm;
    List<String> rslt;
    public List<String> letterCombinations(String digits) {
        rslt = new ArrayList<>();
        hm = preprocessing();
        char[] d = digits.toCharArray();
        if (d.length == 0) {
            return rslt;
        }
        StringBuilder sb = new StringBuilder();
        dfs(d, 0, sb);
        return rslt;
    }
    private void dfs(char[] d, int index, StringBuilder sb) {
        if(index == d.length) {
            rslt.add(sb.toString());
            return;
        }
        String cur = hm.get(d[index]);
        for(int i = 0; i < cur.length(); i ++) {
            sb.append(cur.charAt(i));
            dfs(d, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private Map<Character, String> preprocessing() {
        hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        return hm;
    }
}
