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
            open++;
            
            f(open,close,ds,res,n);

            ds.deleteCharAt(ds.length()-1);
            open--;

        }

        if(close<open) {
            ds.append(")");
            close++;
            f(open,close,ds,res,n);
            ds.deleteCharAt(ds.length()-1);
            close--;
        }
    }
}
