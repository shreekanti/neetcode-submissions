class Solution {
    class Pair{
        int key;
        int val;
        Pair(int a ,int b){
            this.key = a;
            this.val = b;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
         PriorityQueue<Pair> minh = new PriorityQueue<>((a,b)-> Integer.compare
         (a.key,b.key));

         int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }  

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(minh.size()>=k) {
                Pair top  = minh.peek();
                if(top.key<entry.getValue()){
                    minh.poll();
                    minh.add(new Pair(entry.getValue(), entry.getKey()));
                }


            }
            else {
                minh.add(new Pair(entry.getValue(), entry.getKey()));
            }
        }    
        int [] ans  = new int[k];
        for(int i=0;i<k;i++){
            Pair top = minh.peek();
            ans[i] = top.val;
            minh.poll();
        } 
        return ans;      


    }
}
