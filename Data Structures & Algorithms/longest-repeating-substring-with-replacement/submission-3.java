class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen =0;
        int l=0;
        int[] hash = new int[26];
        int maxFreq =0;

        for(int r=0;r<n;r++) {
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r)-'A']);

            if(r-l+1-maxFreq>k) {
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen =Math.max(maxLen , r-l+1);
            
        }
        return maxLen;
    }
}
