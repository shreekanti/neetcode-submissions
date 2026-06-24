class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);

        int res= 0; int curr = nums[0]; int length =0;
        for(int i=0;i<nums.length;) {
            if(curr!=nums[i]) {
                curr=nums[i];
                length=0;
            }
            
            while(i<nums.length && nums[i]==curr) {
                i++;
            }
            length++;
            curr++;

            res= Math.max(res, length);

            
        }
        return res;
    }
}
