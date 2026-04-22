class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        

        int prefix =1;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++) {
            res[i] = res[i-1]*nums[i-1];

        }
        int suffix =1;
        for(int i=n-2;i>=0;i--) {
            res[i+1] = res[i+1]*suffix;
            suffix = suffix*nums[i+1];
            
        }
        res[0]  =res[0]*suffix;

        

        
        return res;
    }
}  
