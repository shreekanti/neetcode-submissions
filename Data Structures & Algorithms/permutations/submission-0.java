class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        f(new ArrayList<>(), res, vis, nums);
        return res;
    }

    public void f(List<Integer> ds, List<List<Integer>> res, boolean[] vis, int[] nums) {
        if(ds.size()==nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!vis[i]) {
                ds.add(nums[i]);
                vis[i]=true;
                f(ds,res,vis,nums);
                vis[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
