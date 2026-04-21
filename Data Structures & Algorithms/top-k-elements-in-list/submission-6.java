class Solution {
    // class Pair{
    //     int key;
    //     int val;
    //     Pair(int a ,int b){
    //         this.key = a;
    //         this.val = b;
    //     }
    // }
    public int[] topKFrequent(int[] nums, int k) {
        //  PriorityQueue<Pair> minh = new PriorityQueue<>((a,b)-> Integer.compare
        //  (a.key,b.key));

         int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }  

        List<Integer>[] bucket = new ArrayList[n+1];
        // initialse with empty list

        for(int key: map.keySet()) {
            int freq = map.get(key);

            if(bucket[freq]==null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
 
        int[] ans = new int[k];
        int ind = 0;

        for(int i=n;i>0 && ind<k;i--) {

            if(bucket[i]!=null) {
                for(int num =0;num<bucket[i].size();num++) {
                    ans[ind]= bucket[i].get(num);
                    ind+=1;
                    System.out.println(ind);
                    if(ind==k) {
                        break;
                    }
                }

            }
            
        }
        return ans;



        // for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
        //     if(minh.size()>=k) {
        //         Pair top  = minh.peek();
        //         if(top.key<entry.getValue()){
        //             minh.poll();
        //             minh.add(new Pair(entry.getValue(), entry.getKey()));
        //         }


        //     }
        //     else {
        //         minh.add(new Pair(entry.getValue(), entry.getKey()));
        //     }
        // }    
        // int [] ans  = new int[k];
        // for(int i=0;i<k;i++){
        //     Pair top = minh.peek();
        //     ans[i] = top.val;
        //     minh.poll();
        // } 
        // return ans;      


    }
}
