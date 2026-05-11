class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map= new HashMap<>();
    }
    class Pair {
        String val;
        int time;

        public Pair(String val, int time) {
            this.val = val;
            this.time=time;
        }
    }
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int n = list.size();
        int l= 0;
        int r = n-1;
        String ans = "";
        while(l<=r) {
            int mid = (l+r)/2;
            Pair pair = list.get(mid);
            if(pair.time==timestamp) {
                return pair.val;
            }else if(pair.time<timestamp) {
                ans = pair.val;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}
