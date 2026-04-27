class Solution {
    public String minWindow(String s, String t) {
        int n1 =s.length();
        int n2 = t.length();
        if(n2>n1) return "";
        int sInd =-1;
        int minLen = Integer.MAX_VALUE;
        int l=0;
        int[] hash = new int[256];
        int count=0;
        for(int i=0;i<n2;i++) {
            hash[t.charAt(i)]++;
        }

        for(int r=0;r<n1;r++) {
            if(hash[s.charAt(r)]>0) {
                count++;
            }
            hash[s.charAt(r)]--;
            while(count==n2) {
                if(r-l+1<minLen) {
                    minLen=r-l+1;
                    sInd=l;
                }
            
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) {
                    count--;
                }
                l++;
            }
        }
        return sInd==-1?"":s.substring(sInd,sInd+minLen);
    }
    //tc -O(2n+m) sc O(256)
}
