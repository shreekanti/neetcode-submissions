class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max =0;
        int sum =0;
        if(n<k) return -1;
        for(int i=0;i<n;i++) {
            max =Math.max(max, nums[i]);
            sum +=nums[i];
        }


        int l = max;
        int h = sum;

        while(l<=h) {
            int mid = (l+h)/2;

            int countK = fun(nums, mid);

            if(countK<=k) {
                h=mid-1;
            }else {
                l=mid+1;
            }
        }
        return l;
    }

    public int fun(int[] nums, int k) {
        int count =1;
        int sum =0;

        for(int i=0;i<nums.length;i++) {

            if(sum+nums[i]<=k) {
                sum+=nums[i];
            }else {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}