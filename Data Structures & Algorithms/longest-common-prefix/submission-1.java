class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        Arrays.sort(strs);

        String res = strs[0];

        for(int i=0;i<res.length();i++) {
            if(res.charAt(i)!=strs[n-1].charAt(i)) {
                return res.substring(0,i);
            }else if(i==(res.length()-1)) {
                return res;
            }
        }

        return "";
    }
}