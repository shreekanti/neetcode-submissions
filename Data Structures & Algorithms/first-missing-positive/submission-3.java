class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++) {
            if(nums[i]<0 || nums[i]>n) {
                nums[i]=0;
            }
        }

        for(int i=0;i<n;i++) {
            int num = Math.abs(nums[i]);
            if((num>=1) && num<=n) {
                if(nums[num-1]>0){
                    nums[num-1]*=-1;
                }else if(nums[num-1]==0) {
                    nums[num-1] = -1*(n+1);
                }
            }
        }

        for(int i=1;i<=n;i++) {
            if(nums[i-1]>=0) {
                return i;
            }
        }
        return n+1;
    } 
}