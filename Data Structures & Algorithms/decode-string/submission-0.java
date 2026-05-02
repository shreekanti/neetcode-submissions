class Solution {
    public String decodeString(String s) {
        Stack<Integer> numS = new Stack<>();
        Stack<String> ss = new Stack<>();

        int n = s.length();
        int num =0;
        String curr ="";

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
            }else if(c=='[') {
                numS.push(num);
                ss.push(curr);
                num =0;
                curr="";
            }else if(c==']') {
                int count = numS.pop();
                String prev = ss.pop();

                StringBuilder sb = new StringBuilder(prev);

                for(int j=0;j<count;j++) {
                    sb.append(curr);
                }
                curr = sb.toString();
            }else {
                curr+=c;
            }
        }
        return curr;
    }
}