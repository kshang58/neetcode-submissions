class Twitter {
    int globalTime;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        globalTime = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[]{tweetId, globalTime});
        globalTime ++;
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<Integer> rslt = new ArrayList<>();
        Set<Integer> cur = followMap.getOrDefault(userId, new HashSet<>());
        cur.add(userId);
        for (int i : cur) {
            List<int[]> tweets = tweetMap.getOrDefault(i, new ArrayList<>());
            for (int[] tweet : tweets) {
                maxHeap.add(tweet);
            }
        }
        while(rslt.size() < 10 && maxHeap.size() > 0) {
            rslt.add(maxHeap.poll()[0]);
        }
        return rslt;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followMap.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        followMap.put(followerId, followers);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followMap.getOrDefault(followerId, new HashSet<>());
        if(followers.contains(followeeId)) {
            followers.remove(followeeId);
            followMap.put(followerId, followers);
        }
    }
}
