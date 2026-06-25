class Solution {
    public boolean isAnagram(String s, String t) {
        //Brute optimised
        Map<Character, Integer> smap = new HashMap<>();
        

        for(int i=0;i<s.length();i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++) {
            smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i),0)-1);
        }

        for(Map.Entry<Character, Integer> entry : smap.entrySet()){
            if(entry.getValue()!=0) {
                return false;
            }
        }

        return true;
        // Tc -O(n) sc O(n)
    }
}
