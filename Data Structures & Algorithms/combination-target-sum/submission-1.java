class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(0,target, new ArrayList<>(),res,nums);
        return res;
    }

    public void f(int ind, int target, List<Integer> ds, List<List<Integer>> res, int[] nums ) {
        if(ind==nums.length) {
            if(target==0) {
                res.add(new ArrayList<>(ds));
           
            }
        
            return;
        }

        if(nums[ind]<=target) {
            ds.add(nums[ind]);
            f(ind, target-nums[ind], ds, res, nums);
            ds.remove(ds.size()-1);

        }
        f(ind+1, target, ds, res, nums);
    }
}
