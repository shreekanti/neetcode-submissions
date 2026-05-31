class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(0,new ArrayList<>(),res,nums);
        return res;
    }

    public void f(int ind, List<Integer> temp, List<List<Integer>> res, int[] nums) {

        if(ind==nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        f(ind+1, temp,res,nums);
        temp.remove(temp.size()-1);
        f(ind+1,temp,res,nums);

    }
}
