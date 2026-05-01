class StockSpanner {
    Stack<int[]> s;
    int ind;
    public StockSpanner() {
        ind =-1;
        s = new Stack<>();
    }
    
    public int next(int price) {
        ind = ind+1;
        while(!s.isEmpty() && s.peek()[0]<=price) {
            s.pop();
        }

        int ans = s.isEmpty()?ind-(-1):ind-s.peek()[1];
        s.push(new int[]{price,ind});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */