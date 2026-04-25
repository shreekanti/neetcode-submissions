class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0;i<n1 && i<n2;i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(n1>n2) {
            sb.append(word1.substring(i));
        }else {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}