class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        f(new ArrayList<>(), res, vis, nums);
        return res;
    }

    public void f( List<Integer> ds, List<List<Integer>> res, boolean[] vis, int[] nums) {
        if(ds.size()==nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i]==nums[i-1] && !vis[i-1]) {
                continue;
            }

            if(!vis[i]) {
                vis[i] =true;
                ds.add(nums[i]);
                f(ds,res,vis,nums);
                ds.remove(ds.size()-1);
                vis[i]=false;
            }
        }
    }
}