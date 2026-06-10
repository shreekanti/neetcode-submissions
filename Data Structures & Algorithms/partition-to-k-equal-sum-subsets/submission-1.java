class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n  = nums.length;
        int sum =0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }

        if(sum%k!=0) return false;

        int target  = sum/k;

        Arrays.sort(nums);
        reverse(nums);
        
        boolean[] used = new boolean[n];
        return f(0, nums, k, target, 0,used);
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

    public boolean f(int start,  int[] nums, int k, int target, int currSum, boolean[] used) {
        if(k==0) {
            return true;
        }
        if(target==currSum) {
            return f(0,nums,k-1,target,0,used);
        }

        for(int i =start;i<nums.length;i++) {
            if(used[i] || currSum+nums[i]>target) {
                continue;
            }
            used[i]=true;
            if(f(i+1,nums,k,target,currSum+nums[i],used)) {
                return true;
            }
            used[i]=false;
            if(currSum==0) {
                return false;
            }
        }
        return false;
    }
}