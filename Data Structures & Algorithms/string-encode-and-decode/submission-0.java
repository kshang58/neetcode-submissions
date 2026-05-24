class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] s = str.toCharArray();
        List<String> rslt = new ArrayList<>();
        int i = 0;
        while (i < s.length){
            int num = 0;
            for(int j = i; j < s.length; j ++) {
                if (s[j] == '#') {
                    i = j + 1;
                    break;
                }
                num = num * 10 + s[j] - '0';
            }
            rslt.add(new String(s, i, num));
            i = i + num;
        }
        return rslt;
    }
}
