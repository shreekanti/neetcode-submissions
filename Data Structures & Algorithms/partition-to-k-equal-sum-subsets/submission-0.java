class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n  = nums.length;
        int sum =0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }

        if(sum%k!=0) return false;

        int part  = sum/k;

        Arrays.sort(nums);
        reverse(nums);
        int[] parts = new int[k];

        return f(0, parts, nums, k, part);
    }

    public void reverse(int[] nums) {
        int i=0;
        int j= nums.length-1;
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] =temp;
            i++;
            j--;
        }

    }

    public boolean f(int ind, int[] parts, int[] nums, int k, int part) {
        if(ind==nums.length) {
            return true;
        }

        for(int i=0;i<k;i++) {
            if(parts[i]+nums[ind]<=part) {
                parts[i]+=nums[ind];
                if(f(ind+1, parts, nums, k, part)) {
                    return true;
                }
                parts[i]-=nums[ind];

            }
        }

        return false;
    }
}