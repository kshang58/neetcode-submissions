class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rslt = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int i = 0;
        int length = 0;
        while (i < words.length) {
            if (length + words[i].length() + line.size() <= maxWidth) {
                // line not full yet
                line.add(words[i]);
                length += words[i].length();
                i ++;
            } else {
                // line full
                int numOfSpace = Math.max(1, (line.size() - 1));
                int space = maxWidth - length;
                int spaceEach = space / numOfSpace;
                int module = space % numOfSpace;
                for (int j = 0; j < numOfSpace; j ++) {
                    line.set(j, line.get(j) + " ".repeat(spaceEach));
                    if (module > 0) {
                        line.set(j, line.get(j) + " ");
                        module--;
                    }
                }
                rslt.add(String.join("", line));
                line.clear();
                length = 0; 
            }
        }
        String last_line = String.join(" ", line);
        int trail_space = maxWidth - last_line.length();
        rslt.add(last_line + " ".repeat(trail_space));
        return rslt;
    }
}