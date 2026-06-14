class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        f(0, new ArrayList<>(), res, nums);
        return res;
    }

    public void f(int ind, List<Integer> ds, List<List<Integer>> res, int[] nums) {
        if(ind==nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[ind]);
        f(ind+1, ds, res, nums);
        ds.remove(ds.size()-1);
        f(ind+1, ds, res, nums);
    }
}
