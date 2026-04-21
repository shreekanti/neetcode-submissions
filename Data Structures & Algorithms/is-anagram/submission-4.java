class Solution {
    public boolean isAnagram(String s, String t) {
        int sl= s.length();
        int tl = t.length();
        if(sl!=tl) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i =0;i<s.length();i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i =0;i<t.length();i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }
        if(map1.equals(map2)) {
            return true;
        }
        // for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
        //     char key = entry.getKey();
        //     if(!map2.containsKey(key)) {
        //         return false;
        //     }else if((map1.get(key)).equals(map2.get(key))) {
        //         return false;
        //     }
        // }
        return false;
    }
}
