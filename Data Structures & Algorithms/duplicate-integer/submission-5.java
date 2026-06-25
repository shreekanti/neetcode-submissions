class Solution {
    public boolean hasDuplicate(int[] nums) {
        //brute
        int n =nums.length;

        for(int i=0;i<n;i++) {
            int num  = nums[i];

            for(int j=i+1;j<n;j++) {
                if(num== nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //Tc -O(n*n). sc -O(1)
}