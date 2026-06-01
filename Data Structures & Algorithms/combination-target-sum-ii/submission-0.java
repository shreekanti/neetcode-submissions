class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        f(0,target,new ArrayList<>(), res,candidates);
        return res; 
    }

    public void f(int ind, int target, List<Integer> ds, List<List<Integer>> res, int[] candidates) {
        if(target==0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<candidates.length;i++) {
            if(i!=ind && candidates[i]==candidates[i-1]) {
                continue;
            }
            if(candidates[i]>target) {
                break;
            }
            ds.add(candidates[i]);
            f(i+1,target-candidates[i],ds,res,candidates);
            ds.remove(ds.size()-1);
        }
    }
}
