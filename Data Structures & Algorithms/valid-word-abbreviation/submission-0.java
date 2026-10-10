class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length()) return false;
        return valid(word, abbr, 0, 0);
    }
    private boolean valid(String word, String abbr, int i, int j) {
        if (j == abbr.length() && i == word.length()) return true;
        if (j >= abbr.length() || i >= word.length()) return false;
        if (abbr.length() - i > word.length() - j) return false;
        if (!Character.isDigit(abbr.charAt(j))) {
            if (word.charAt(i) != abbr.charAt(j)) return false;
            return valid(word, abbr, i + 1, j + 1);
        }
        if (abbr.charAt(j) == '0') return false;
        int num = 0;
        while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
            num = num * 10 + abbr.charAt(j) - '0';
            j ++;
        } 
        return valid(word, abbr, i + num, j);
    }
}