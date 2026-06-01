class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] vis = new boolean[nums.length];
        f( 0,res,nums);
        return res;
    }

    public void f(int ind, List<List<Integer>> res, int[] nums) {
        if(ind==nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++) {
                ds.add(nums[i]);
            }
            res.add(ds);
            return;
        }

        for(int i=ind;i<nums.length;i++) {
            swap(i,ind,nums);
            f(ind+1,res,nums);
            swap(i,ind,nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
