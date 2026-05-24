class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int timestamp;
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> userTweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        userTweets.add(new int[]{tweetId, timestamp});
        tweetMap.put(userId, userTweets);
        timestamp ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<Integer> rslt = new ArrayList<>();
        Set<Integer> followee = followMap.getOrDefault(userId, new HashSet<>());
        followee.add(userId);
        for (int user : followee) {
            List<int[]> userTweets = tweetMap.getOrDefault(user, new ArrayList<>());
            for (int[] i : userTweets) {
                maxHeap.offer(i);
            }
        }
        for (int i = 0; i < 10; i ++) {
            if (!maxHeap.isEmpty()) {
                int[] cur = maxHeap.poll();
                rslt.add(cur[0]);
            } else {
                break;
            }
        }
        return rslt;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followee = followMap.getOrDefault(followerId, new HashSet<>());
        followee.add(followeeId);
        followMap.put(followerId, followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followee = followMap.getOrDefault(followerId, new HashSet<>());
        followee.remove(followeeId);
        followMap.put(followerId, followee);
    }
}
