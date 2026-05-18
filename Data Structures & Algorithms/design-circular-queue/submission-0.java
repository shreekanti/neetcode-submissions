class Node{
    int val;
    Node next;
    Node prev;

    public Node(int val, Node next, Node prev ) {
        this.val = val;
        this.next = next;
        this.prev=prev;
    }
}



class MyCircularQueue {
    int capacity;
    private Node left;
    private Node right;
    public MyCircularQueue(int k) {
        left = new Node(0,null,null);
        right = new Node(0, null, left);
        left.next = right;
        capacity=k;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;

        Node newNode = new Node(value,right,right.prev);

        right.prev= newNode;
        newNode.prev.next = newNode;
        capacity--;
        return true;


    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        left.next = left.next.next;
        left.next.prev = left;
        capacity++;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return left.next.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return right.prev.val;
        
    }
    
    public boolean isEmpty() {
        return left.next==right;
    }
    
    public boolean isFull() {
        return capacity==0;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */