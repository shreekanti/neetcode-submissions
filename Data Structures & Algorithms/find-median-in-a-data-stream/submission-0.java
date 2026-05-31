class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small =  new PriorityQueue<>((a,b)-> b-a);
        large = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        small.add(num);
        // in small elements are greater than large
        if(!small.isEmpty() && !large.isEmpty() && small.peek()>large.peek() ) {
            int val = small.poll();
            large.add(val);
        }

        //size diff greater than 1
        if(small.size()> large.size()+1) {
            int val = small.poll();
            large.add(val);
        }  
        if(large.size()>small.size()+1) {
            int val = large.poll();
            small.add(val);
        }
    }
    
    public double findMedian() {
        if(small.size()>large.size()) {
            return small.peek();
        }else if(large.size()>small.size()){
            return large.peek();
        }else{
            return (double)(small.peek()+large.peek())/2;
        }
        
    }
}
