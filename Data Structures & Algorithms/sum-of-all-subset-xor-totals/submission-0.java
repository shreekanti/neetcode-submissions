class Solution {
    public int subsetXORSum(int[] nums) {
        return f(0,0,nums);
    }

    public int f(int ind , int total,int[] nums) {
        if(ind==nums.length) {
            return total;
        }

        return f(ind+1, total^nums[ind],nums) + f(ind+1, total,nums);
    }
}