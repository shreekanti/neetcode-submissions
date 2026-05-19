class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val =val;
            next = null;
            prev=null;
        }
    }

    
    int capacity;
    Node left;
    Node right;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity= capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        map = new HashMap<>();
    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;

    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

       

        Node newNode = new Node(key,value);
        map.put(key,newNode);
        insert(newNode);

         if(map.size()>capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
