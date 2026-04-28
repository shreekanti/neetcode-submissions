class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> st = new Stack<>();
        int sum =0;

        for(int i=0;i<n;i++) {
            if(operations[i].equals("D")) {
                int record = 2*st.peek();
                sum+=record;
                st.push(record);
            }else if(operations[i].equals("C")) {
                int record = st.peek();
                sum-=record;
                st.pop();
            }else if(operations[i].equals("+")) {
                int top = st.pop();
                int newScore =top+st.peek();
                st.push(top);
                st.push(newScore);
                sum+=newScore;
            }else {
                st.push(Integer.parseInt(operations[i]));
                sum+=Integer.parseInt(operations[i]);
            }
        }
        return sum;
        
    }
}