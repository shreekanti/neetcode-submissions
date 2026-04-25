class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int ind =1;
        ans[0] = nums[0];

        for(int i=1;i<n;i++) {
            if(nums[i]!=nums[i-1]) {
                ans[ind++] = nums[i];
            }
        }
        for(int i=0;i<ind;i++) {
            nums[i]=ans[i];
        }
        return ind;

    }
}