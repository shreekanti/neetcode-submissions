class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        f(1,k,new ArrayList<>(), res, n);
        return res;
        
    }

    public void f(int num, int k,List<Integer> ds, List<List<Integer>> res, int n) {
        if(k==0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=num;i<=n;i++) {
            ds.add(i);
            f(i+1,k-1,ds,res,n);
            ds.remove(ds.size()-1);
        }
    }
}