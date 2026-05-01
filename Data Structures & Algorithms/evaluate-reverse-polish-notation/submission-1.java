class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int n = tokens.length;

        for(int i=0;i<n;i++) {
            String str = tokens[i];
            if(!str.equals("+") && !str.equals("*") && !str.equals("-") && !str.equals("/")) {
                s.push(Integer.parseInt(str));
            }else {
                int num1 = s.pop();
                int num2 = s.pop();
                int res =-1;
                if(str.equals("+")) {
                     res = num2+num1;
                }else if (str.equals("-")) {
                     res = num2-num1;
                }else if(str.equals("*")) {
                     res = num2*num1;
                }else{
                     res = num2/num1;
                }

                s.push(res);
            }
        }
        return s.pop();
    }
}
