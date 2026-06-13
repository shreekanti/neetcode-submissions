class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();


        f(0,new ArrayList<>(), set, res, s);
        return res;
    }

    public void f(int ind,List<String> curr, Set<String> set, List<String> res, String s) {
        if(ind==s.length()) {
            res.add(String.join(" ",curr));
            return;
        }

        for(int i=ind;i<s.length();i++) {
            String w = s.substring(ind, i+1);
            if(set.contains(w)) {
                curr.add(w);
                f(i+1, curr,set,res,s);
                curr.remove(curr.size()-1);
            }
        }
    }
}