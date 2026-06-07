class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        f(0,0,new StringBuilder(),res,n);
        return res;
    }

    public void f(int open, int close, StringBuilder ds, List<String> res, int n) {
        if(open==close && close==n) {
            res.add(ds.toString());
            return;
        }

        if(open<n) {
            ds.append("(");
            
            
            f(open+1,close,ds,res,n);

            ds.deleteCharAt(ds.length()-1);
            
        }

        if(close<open) {
            ds.append(")");
           
            f(open,close+1,ds,res,n);
            ds.deleteCharAt(ds.length()-1);
            
        }
    }
}
