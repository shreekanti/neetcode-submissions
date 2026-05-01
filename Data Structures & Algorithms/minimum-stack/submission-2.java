class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        s= new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);

        if(min.isEmpty()) {
            min.push(val);
        }else if(val<=min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;

        if(min.peek().equals(s.peek())) {
            min.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}
