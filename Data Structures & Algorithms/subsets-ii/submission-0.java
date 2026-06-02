class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        f(0,new ArrayList<>(), res,nums);
        return res;
    }

    public void f(int ind, List<Integer> ds, List<List<Integer>> res, int[] nums) {
        // if(ind==nums.length) {
        //     res.add(new ArrayList<>(ds));
        //     return;
        // }
        res.add(new ArrayList<>(ds));

        for(int i=ind;i<nums.length;i++) {
            if(i!=ind && nums[i]==nums[i-1]){
                continue;
            }

            ds.add(nums[i]);
            f(i+1,ds,res,nums);
            ds.remove(ds.size()-1);
            

        }
    }
}
