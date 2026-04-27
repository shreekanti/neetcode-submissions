class Solution {
    public String minWindow(String s, String t) {
        int n1 =s.length();
        int n2 = t.length();
        if(n2>n1) return "";
        int sInd =-1;
        int minLen = Integer.MAX_VALUE;

        for(int i=0;i<n1;i++) {
            int[] hash = new int[256];
            Arrays.fill(hash,0);
            int count=0;
            for(int j=0;j<n2;j++) {
                hash[t.charAt(j)]++;
            }

            for(int j=i;j<n1;j++) {
                if(hash[s.charAt(j)]>0) {
                    count++;
                    
                }
                hash[s.charAt(j)]--;
                if(count==n2) {
                    if(minLen>(j-i+1)) {
                        minLen = j-i+1;
                        sInd =i;
                        break;
                    }
                }
            }
        }
        return sInd==-1?"":s.substring(sInd,sInd+minLen);
    }
}
