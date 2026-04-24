class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
        }

        int[] hash = new int[max+1];
        
        for(int i=0;i<n;i++) {
            if(nums[i]>0)
                hash[nums[i]]++;
        }

        for(int i=1;i<max+1;i++) {
            if(hash[i]==0) {
                return i;
            }
        }
        return max+1;
    }
}