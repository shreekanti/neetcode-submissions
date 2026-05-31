class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(0,new ArrayList<>(), res, target, nums);
        return res;
    }

    public void f(int ind, List<Integer> temp, List<List<Integer>> res, int target, int[] nums) {
        if(ind==nums.length) {
            if(target==0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if(target>=nums[ind]) {
            temp.add(nums[ind]);
            f(ind, temp,res,target-nums[ind],nums);
            temp.remove(temp.size()-1);

        }
        f(ind+1, temp,res,target,nums);
    }
}
