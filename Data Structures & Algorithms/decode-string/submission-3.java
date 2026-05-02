class Solution {
    public String decodeString(String s) {
        Stack<String> ss = new Stack<>();

        int n = s.length();
        int num =0;
        StringBuilder curr =new StringBuilder();

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
            }else if(c=='[') {
                ss.push(String.valueOf(num));
                ss.push(curr.toString());
                num =0;
                curr= new StringBuilder();
            }else if(c==']') {
                String prev = ss.pop();
                int count = Integer.parseInt(ss.pop());

                StringBuilder sb = new StringBuilder(prev);

                for(int j=0;j<count;j++) {
                    sb.append(curr);
                }
                curr = sb;
            }else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
    //tc o(n) sc -O(n)
}