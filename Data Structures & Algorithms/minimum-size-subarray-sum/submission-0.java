class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min =Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            int sum =0;
            for(int j=i;j<n;j++) {
                sum=sum+nums[j];
                if(sum>=target) {
                    min= Math.min(min, j-i+1);
                    break;
                    // System.out.println (min);
                    
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}