class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        int sl = s.length();
        int tl = t.length();

        if(sl!=tl) return false;

        for(int i=0;i<sl;i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<tl;i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
            }
        }

        for(int val : map.values()) {
            if(val!=0) {
                return false;
            }
        }
        return true;
        
    }
}
