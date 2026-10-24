class Solution {
    public int findNumberOfLIS(int[] nums) {
        //[1,3,5,4,7]
        // 1 2 3 3 4
        // 1 
        // len[i] longest increasing subseq ending at i
        int[] len = new int[nums.length];
        // count[i] number of increasing subseq ending at i at len len[i]
        int[] count = new int[nums.length];
        int globalMax = 0, maxCount = 0;
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (len[i] > globalMax) {
                globalMax = len[i];
                maxCount = count[i];
            } else if (len[i] == globalMax) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}