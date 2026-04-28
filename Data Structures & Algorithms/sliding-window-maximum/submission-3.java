class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int max = Integer.MIN_VALUE;
        int l=0;
        if(k==1) return nums;

        for(int r=0;r<n;r++) {
            max =Math.max(max,nums[r]);

            if(r-l+1==k) {
                ans[l] =max;
                l++;
                max=nums[l];
                r=l;
            }
        }

        return ans;
    }

        
}
