class Solution {
    Map<Character, String> hm;
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
    public List<String> letterCombinations(String digits) {
        hm = preprocessing();
        char[] arr = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if (arr.length == 0) return result;
        StringBuilder sb = new StringBuilder();
        dfs(arr, result, sb, 0);
        return result;
    }
    private void dfs(char[] arr, List<String> result, StringBuilder sb, int index) {
        if (index == arr.length) {
            result.add(sb.toString());
            return;
        }
        String cur = hm.get(arr[index]);
        for (char c : cur.toCharArray()) {
            sb.append(c);
            dfs(arr, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}