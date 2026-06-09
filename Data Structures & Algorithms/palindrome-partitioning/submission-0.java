class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        f(0,new ArrayList<>(), s,res);
        return res;
    }

    public void f(int ind, List<String> ds, String s, List<List<String>> res) {
        if(ind==s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<s.length();i++) {
            if(isPalindrome(s.substring(ind,i+1))) {
                ds.add(s.substring(ind,i+1));
                f(i+1,ds,s,res);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        while(i<j) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
