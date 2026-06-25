class Solution {
    public boolean isAnagram(String s, String t) {
        //Brute optimised
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();

        Arrays.sort(sarray);
        Arrays.sort(tarray);

        return Arrays.equals(sarray, tarray);
        
        // Tc -O(nlogn +mlogn) sc O(n+m)
    }
}
