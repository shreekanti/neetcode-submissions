class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        for(int i=0;i<n2-n1+1;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<i+n1;j++) {
                sb.append(s2.charAt(j));
            }

                
            char[] a2 = sb.toString().toCharArray();
            Arrays.sort(a2);
            if(Arrays.equals(a1,a2)) {
                return true;
            }
                
            
        }
        return false;
        
    }
}
