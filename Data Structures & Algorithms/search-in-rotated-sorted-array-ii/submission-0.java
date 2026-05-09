class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int l=0;
        int h =n-1;
        while(l<=h) {
            int mid = (l+h)/2;
            if(nums[mid]==target) {
                return true;
            }else if(nums[mid]==nums[l] && nums[mid]==nums[h]) {
                l=l+1;
                h=h-1;
            }else if(nums[l]<=nums[mid]) {
                if(nums[l]<=target && nums[mid]>=target) {
                    h=mid-1;
                }else {
                    l=mid+1;
                }
            }else{
                if(nums[mid]<=target && nums[h]>=target) {
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return false;
    }
}