class Solution {
    public int[] getConcatenation(int[] nums) {
        //Brute
        int n = nums.length;
        int[] res = new int[2*n];

        int ind =0;

        for(int i=0;i<2;i++) {
            for(int j=0;j<n;j++) {
                res[ind++] = nums[j];
            }
        }

        return res;
        //Tc-O(n). sc-O(n)
    }
}