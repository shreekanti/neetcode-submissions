class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;

        int[] frq1 = new int[26];
        int[] frq2 = new int[26];


        for(int i=0;i<n1;i++) {
            frq1[s1.charAt(i)-'a']++;
            frq2[s2.charAt(i)-'a']++;
        }

        for(int i=n1;i<n2;i++) {
            if(Arrays.equals(frq1,frq2)) return true;

            frq2[s2.charAt(i)-'a']++;
            frq2[s2.charAt(i-n1)-'a']--;
            
        }

        return Arrays.equals(frq1,frq2);

        
    }
}
