class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;
    
    public Twitter() {
        time=0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time--;
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followId : followMap.get(userId)) {
            if(tweetMap.containsKey(followId)) {
                List<int[]> tweets = tweetMap.get(followId);
                int index = tweets.size()-1;
                int[] tweet = tweets.get(index);
                minh.add(new int[]{tweet[0],tweet[1],followId,index});
            }
        }

        while(!minh.isEmpty() && res.size()<10) {
            int[] curr = minh.poll();
            res.add(curr[1]);
            int index = curr[3];
            if(index >0) {
                int[] tweet = tweetMap.get(curr[2]).get(index-1);
                minh.add(new int[]{tweet[0],tweet[1],curr[2],index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}
