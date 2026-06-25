class Solution {
    public int[] getConcatenation(int[] nums) {
        //Brute
        int n = nums.length;
        int[] res = new int[2*n];


        for(int i=0;i<n;i++) {
            res[i]=nums[i];
            res[i+n] =nums[i];
        }
        return res;
        //Tc-O(n). sc-O(n)
    }
}