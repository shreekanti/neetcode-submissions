class KthLargest {
    private PriorityQueue<Integer> minh;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minh = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            minh.add(nums[i]);
            if(minh.size()>k) {
                minh.poll();
            }
        }
    }
    
    public int add(int val) {
        minh.add(val);

        while(minh.size()>k) {
            minh.poll();
        }
        return minh.peek();
        
    }
}
