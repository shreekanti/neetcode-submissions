class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen =0;

        for(int i=0;i<n;i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for(int j=i;j<n;j++) {
                hash[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j)-'A']);
                int changes = (j-i+1)-maxFreq;
                if(changes<=k) {
                    maxlen= Math.max(maxlen, j-i+1);
                }else {
                    break;
                }
            }
        }
        return maxlen;
    }
}
