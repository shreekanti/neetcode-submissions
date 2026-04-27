class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];
        int l=0;
        int max =0;
        Arrays.fill(hash,-1);

        for(int r=0;r<n;r++) {
            char c = s.charAt(r);
            if(hash[c]!=-1 && hash[c]>=l) {
                l = hash[c]+1;
            }
            max= Math.max(max, r-l+1);
            hash[c] =r;
        }
        return max;
    }
}
