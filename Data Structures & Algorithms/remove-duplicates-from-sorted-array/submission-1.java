class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=1) return n;
        int i =0;
        int j=1;
        while(j<n) {
            if(nums[i]==nums[j]) {
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;

    }
}