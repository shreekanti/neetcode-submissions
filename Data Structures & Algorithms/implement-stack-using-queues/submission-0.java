class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q= new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int n = q.size();

        for(int i=1;i<n;i++) {
            int num = q.peek();
            q.poll();
            q.add(num);
        }
        
    }
    
    public int pop() {
        if(empty()) return -1;
        int num = q.peek();
        q.poll();

        return num;
    }
    
    public int top() {
        if(empty()) return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */