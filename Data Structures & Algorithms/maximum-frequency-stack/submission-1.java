class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        maxFreq=0;
        freq= new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val, f);
        if(f>maxFreq) {
            maxFreq= f;
            group.putIfAbsent(f, new Stack<>());
        }


        group.get(f).push(val);
    }
    
    public int pop() {
        int max = group.get(maxFreq).pop();

        if(group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        freq.put(max, freq.get(max)-1);
        return max;
    }
    //push O(1) popO(1) sc -O(n)
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */