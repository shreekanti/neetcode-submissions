class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(0,0,target, new ArrayList<>(),res,nums);
        return res;
    }

    public void f(int ind,int total, int target, List<Integer> ds, List<List<Integer>> res, int[] nums ) {
       
        if(target==total) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int j=ind;j<nums.length;j++) {
            if(total+nums[j]>target) {
                return;
            }
            ds.add(nums[j]);
            f(j, total+nums[j],target, ds, res, nums);
            ds.remove(ds.size()-1);

        }

    }
}
