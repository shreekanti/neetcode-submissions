class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] digitsToMap = new String[10];
        digitsToMap[2] = "abc";
        digitsToMap[3] ="def";
        digitsToMap[4] ="ghi";
        digitsToMap[5] = "jkl";
        digitsToMap[6] ="mno";
        digitsToMap[7] ="pqrs";
        digitsToMap[8] ="tuv";
        digitsToMap[9] ="wxyz";
        if(digits.length()==0) return res;
        f(0,new StringBuilder(),digitsToMap, digits,res);
        return res;


    }

    public void f(int ind, StringBuilder contri, String[] digitsToMap, String digits, List<String> res) {
        if(ind == digits.length()) {
            res.add(contri.toString());
            return;
        }

        for(int i =0;i< digitsToMap[digits.charAt(ind)-'0'].length();i++) {
            contri.append(digitsToMap[digits.charAt(ind)-'0'].charAt(i));
            f(ind+1, contri, digitsToMap, digits,res);
            contri.deleteCharAt(contri.length()-1);
        }
    }
}
