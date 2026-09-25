class Solution {
    public int compress(char[] chars) {
        int slow = 0, fast = 0;
        while (fast < chars.length) {
            chars[slow] = chars[fast];
            fast ++;
            int count = 1;
            while(fast < chars.length && chars[fast] == chars[fast - 1]) {
                fast ++;
                count ++;
            }
            if (count == 1) {
                slow ++;
                continue;
            }
            int countLen = String.valueOf(count).length();
            int len = countLen;
            while (count != 0) {
                int cur = count % 10;
                count = count / 10;
                chars[slow + len] = (char) (cur + '0');
                len --;
            }
            slow = slow + countLen + 1;
        }
        return slow;
    }
}